package net.luigi.copper_war.entity.custom;

import net.luigi.copper_war.entity.ModEntities;
import net.luigi.copper_war.entity.ai.SoldierAttackGoal;
import net.luigi.copper_war.entity.ai.SoldierAttackWithCoverGoal;
import net.luigi.copper_war.entity.ai.SoldierHurtByTargetGoal;
import net.luigi.copper_war.entity.ai.SoldierTakeCoverGoal;
import net.luigi.copper_war.entity.projectile.BulletEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoldierEntity extends Animal implements RangedAttackMob {

    private static final EntityDataAccessor<Boolean> IDLE_LOOKING =
            SynchedEntityData.defineId(SoldierEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(SoldierEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> ATTACKINGVISION =
            SynchedEntityData.defineId(SoldierEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> SHOOT =
            SynchedEntityData.defineId(SoldierEntity.class, EntityDataSerializers.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState idleLookingAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState attackAnimationStateloop = new AnimationState();
    public final AnimationState attackAnimationStateshoot = new AnimationState();

    public int attackAnimationTick = 0; // counts ticks since attack animation started
    public int attackAnimationTickvision = 0; // counts ticks since attack animation started


    private int idleAnimationTimeout = 0;
    private int attackAnimationTimeout = 0;
    private int attackAnimationTimeoutvision = 0;
    private int combatSpeedTicks = 0;
    private static final double NORMAL_SPEED = 0.3D;
    private static final double COMBAT_SPEED = 0.45D;
    private boolean potion = false;

    public SoldierEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.1F);
    }



    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SoldierAttackGoal(this, 1.0D, 40, 16.0F));
        //this.goalSelector.addGoal(1, new SoldierAttackWithCoverGoal(this, 1.2D, 40, 16.0F));
        //this.goalSelector.addGoal(1, new SoldierTakeCoverGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new net.luigi.copper_war.entity.custom.AnimatedRandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new SoldierHurtByTargetGoal(this));
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IDLE_LOOKING, false);
        this.entityData.define(ATTACKING, false);
        this.entityData.define(ATTACKINGVISION, false);
        this.entityData.define(SHOOT, false);
    }

    public enum SoldierRole {
        NONE,
        SQUAD_LEADER,
        FLANKER,
        SUPPORT
    }

    private SoldierRole squadRole = SoldierRole.NONE;

    public SoldierRole getSquadRole() {
        return squadRole;
    }

    public void setSquadRole(SoldierRole role) {
        this.squadRole = role;
    }

    public boolean isSquadLeaderAlive() {
        List<SoldierEntity> nearby = this.level().getEntitiesOfClass(
                SoldierEntity.class,
                this.getBoundingBox().inflate(16.0D)
        );

        for (SoldierEntity soldier : nearby) {
            if (soldier.getSquadRole() == SoldierRole.SQUAD_LEADER && soldier.isAlive()) {
                return true;
            }
        }

        return false;
    }

    private int countNearbySoldiers(double radius) {
        List<SoldierEntity> nearby = this.level().getEntitiesOfClass(
                SoldierEntity.class,
                this.getBoundingBox().inflate(radius)
        );

        return nearby.size();
    }

    @Nullable
    private Player getVisiblePlayer(double range) {
        List<Player> players = this.level().getEntitiesOfClass(
                Player.class,
                this.getBoundingBox().inflate(range)
        );

        for (Player player : players) {
            if (this.hasLineOfSight(player)) {
                return player;
            }
        }

        return null;
    }

    public boolean canThrowPotion(double forwardDistance, double upDistance) {

        Vec3 eye = this.getEyePosition();
        Vec3 look = this.getViewVector(1.0F);

        // Forward check
        Vec3 forwardEnd = eye.add(look.scale(forwardDistance));

        BlockHitResult forwardHit = this.level().clip(
                new ClipContext(
                        eye,
                        forwardEnd,
                        ClipContext.Block.COLLIDER,
                        ClipContext.Fluid.NONE,
                        this
                )
        );

        if (forwardHit.getType() != HitResult.Type.MISS) {
            return false; // block directly in front
        }

        // Upward check
        Vec3 upEnd = eye.add(0, upDistance, 0);

        BlockHitResult upHit = this.level().clip(
                new ClipContext(
                        eye,
                        upEnd,
                        ClipContext.Block.COLLIDER,
                        ClipContext.Fluid.NONE,
                        this
                )
        );

        if (upHit.getType() != HitResult.Type.MISS) {
            return false; // ceiling above
        }

        return true;
    }

    public void assignSquadRoles() {
        // Only assign if targeting a player
        LivingEntity target = this.getTarget();
        if (target == null || this.getSquadRole() == null) return;

        // Find nearby soldiers in 8 block radius
        List<SoldierEntity> squad = this.level().getEntitiesOfClass(
                SoldierEntity.class,
                this.getBoundingBox().inflate(30.0D),
                s -> s.getTarget() == target && s.getSquadRole() == SoldierRole.NONE
        );

        if (squad.size() < 3) return; // need at least 3 to form a squad

        if (squad.size() == 3) {
            // Assign roles (first soldier = leader, next = flanker, last = support)
            boolean leaderAssigned = false;
            boolean flankerAssigned = false;
            boolean supportAssigned = false;
            for (SoldierEntity soldier : squad) {
                if (!leaderAssigned) {
                    soldier.setSquadRole(SoldierRole.SQUAD_LEADER);
                    System.out.println("leader assigned");
                    leaderAssigned = true;
                } else if (!flankerAssigned) {
                    soldier.setSquadRole(SoldierRole.FLANKER);
                    System.out.println("flanker assigned");
                    flankerAssigned = true;
                } else if (!supportAssigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    supportAssigned = true;
                }
            }
        }else
        if (squad.size() == 4) {
            // Assign roles (first soldier = leader, next = flanker, last = support)
            boolean leaderAssigned = false;
            boolean flankerAssigned = false;
            boolean supportAssigned = false;
            boolean support2Assigned = false;
            for (SoldierEntity soldier : squad) {
                if (!leaderAssigned) {
                    soldier.setSquadRole(SoldierRole.SQUAD_LEADER);
                    System.out.println("leader assigned");
                    leaderAssigned = true;
                } else if (!flankerAssigned) {
                    soldier.setSquadRole(SoldierRole.FLANKER);
                    System.out.println("flanker assigned");
                    flankerAssigned = true;
                } else if (!supportAssigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    supportAssigned = true;
                }else if (!support2Assigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    support2Assigned = true;
                }
            }
        }else
        if (squad.size() == 5) {
            // Assign roles (first soldier = leader, next = flanker, last = support)
            boolean leaderAssigned = false;
            boolean flankerAssigned = false;
            boolean flanker2Assigned = false;
            boolean supportAssigned = false;
            boolean support2Assigned = false;
            for (SoldierEntity soldier : squad) {
                if (!leaderAssigned) {
                    soldier.setSquadRole(SoldierRole.SQUAD_LEADER);
                    System.out.println("leader assigned");
                    leaderAssigned = true;
                } else if (!flankerAssigned) {
                    soldier.setSquadRole(SoldierRole.FLANKER);
                    System.out.println("flanker assigned");
                    flankerAssigned = true;
                } else if (!supportAssigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    supportAssigned = true;
                }else if (!support2Assigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    support2Assigned = true;
                } else if (!flanker2Assigned) {
                    soldier.setSquadRole(SoldierRole.FLANKER);
                    System.out.println("flanker assigned");
                    flanker2Assigned = true;
                }
            }
        }else{
            boolean leaderAssigned = false;
            boolean flankerAssigned = false;
            boolean supportAssigned = false;
            for (SoldierEntity soldier : squad) {
                if (!leaderAssigned) {
                    soldier.setSquadRole(SoldierRole.SQUAD_LEADER);
                    System.out.println("leader assigned");
                    leaderAssigned = true;
                } else if (!flankerAssigned) {
                    soldier.setSquadRole(SoldierRole.FLANKER);
                    System.out.println("flanker assigned");
                    flankerAssigned = true;
                } else if (!supportAssigned) {
                    soldier.setSquadRole(SoldierRole.SUPPORT);
                    System.out.println("support assigned");
                    supportAssigned = true;
                }
            }
        }
    }
    

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {

            Player visiblePlayer = getVisiblePlayer(15.0D);

            if (visiblePlayer != null) {

                int nearbySoldiers = countNearbySoldiers(24.0D);

                // Only aggro if enough soldiers nearby
                if (nearbySoldiers >= 4 && this.getTarget() == null) {

                    this.setTarget(visiblePlayer);
                    this.enterCombatMode();

                    // Optional: alert the squad
                    alertNearbySoldiers(visiblePlayer);
                }
            }
        }

        if (this.level().isClientSide()) {
            updateAnimations();
        }

        if (this.combatSpeedTicks > 0) {
            combatSpeedTicks--;
            // If in combat, use higher speed
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        } else {
            // Back to normal when timer runs out
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        }

        if (this.level().isClientSide()) {
            updateAnimations();
        }

        tickAttackAnimation();
        tickAttackAnimationvision();
    }


    private void updateAnimations() {
        // Idle animation
        if (!idleAnimationState.isStarted()) {
            idleAnimationState.start(this.tickCount);
        }

        // Idle-looking animation
        if (isIdleLooking()) {
            if (!idleLookingAnimationState.isStarted()) {
                idleLookingAnimationState.start(this.tickCount);
            }
        } else {
            idleLookingAnimationState.stop();
        }

        // Attack animation — start only once per attack
        // Attack animation
        if (this.isAttacking()) {
            if (!attackAnimationState.isStarted()) {
                attackAnimationState.start(this.tickCount); // start once
                attackAnimationTick = 0; // reset counter
            } else {
                attackAnimationTick++; // count ticks since attack started

            }
        } else {
            --this.attackAnimationTimeout;

            attackAnimationTick = 0;
        }

        if (this.isAttackingvisionafter()) {
            if (!attackAnimationStateshoot.isStarted()){
                attackAnimationStateshoot.start(this.tickCount);
            }

        }

        if (this.isAttackingvision()) {
            if (!attackAnimationStateloop.isStarted()) {
                attackAnimationStateloop.start(this.tickCount); // start once
                attackAnimationTickvision = 0; // reset counter
            } else {
                 attackAnimationTickvision++; // count ticks since attack started

            }
        } else {
            --this.attackAnimationTimeoutvision;

            attackAnimationTickvision = 0;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

        if(!this.isAttackingvision()) {
            attackAnimationStateloop.stop();
        }

        if (!this.isAttackingvisionafter()) {
            attackAnimationStateshoot.stop();
        }

    }

    public boolean trowpotion(boolean thow){
        potion = thow;
        return thow;
    }



    public void enterCombatMode() {
        this.combatSpeedTicks = 20; // stays in combat for 5 seconds
    }

    public int attackTickCounter = 0;
    public int attackTickCountervision = 0;

    public void tickAttackAnimation() {
        if (!this.level().isClientSide()) {
            if (isAttacking()) {
                attackTickCounter++;
            } else {
                attackTickCounter = 0;
            }
        }
    }

    public void tickAttackAnimationvision() {
        if (!this.level().isClientSide()) {
            if (isAttackingvision()) {
                attackTickCountervision++;
            } else {
                attackTickCountervision = 0;
            }
        }
    }

    protected void updateWalkAnimation(float partialTick) {
        float f = (this.getPose() == Pose.STANDING) ? Math.min(partialTick * 6F, 1f) : 0f;
        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);

        if (!level().isClientSide && result) {

            Entity attacker = source.getEntity();

            if (attacker instanceof LivingEntity livingAttacker) {

                // Set this soldier's target
                this.setTarget(livingAttacker);

                // Alert nearby soldiers
                alertNearbySoldiers(livingAttacker);
            }
        }

        return result;
    }

    @Override
    public boolean isAlliedTo(Entity entity) {
        if (entity instanceof SoldierEntity) {
            return true;
        }
        return super.isAlliedTo(entity);
    }

    private void alertNearbySoldiers(LivingEntity attacker) {

        double alertRadius = 24.0D;

        List<SoldierEntity> nearby = this.level().getEntitiesOfClass(
                SoldierEntity.class,
                this.getBoundingBox().inflate(alertRadius)
        );

        for (SoldierEntity soldier : nearby) {

            if (soldier != this && soldier.getTarget() == null) {

                soldier.setTarget(attacker);

                // Optional: enter combat mode if you have one
                soldier.enterCombatMode();
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.6D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0D);
    }

    // Synced data setters/getters
    public void setIdleLooking(boolean value) { this.entityData.set(IDLE_LOOKING, value); }
    public boolean isIdleLooking() { return this.entityData.get(IDLE_LOOKING); }

    public void setAttacking(boolean value) { this.entityData.set(ATTACKING, value); }
    public boolean isAttacking() { return this.entityData.get(ATTACKING); }

    public void setAttackingvision(boolean value) { this.entityData.set(ATTACKINGVISION, value); }
    public boolean isAttackingvision() { return this.entityData.get(ATTACKINGVISION); }

    public void setAttackingvisionafter(boolean value) { this.entityData.set(SHOOT, value); }
    public boolean isAttackingvisionafter() { return this.entityData.get(SHOOT); }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (this.level().isClientSide()) return; // Server only

        //setAttacking(true);
        if(this.getSquadRole() == SoldierRole.SUPPORT || this.getSquadRole() == SoldierRole.SQUAD_LEADER ||(this.getSquadRole() == SoldierRole.FLANKER && !potion)){
            BulletEntity bullet = new BulletEntity(ModEntities.BULLET.get(), this.level());
            bullet.setPos(this.getX(), this.getEyeY(), this.getZ());

            double dx = target.getX() - this.getX();
            double dy = target.getEyeY() - this.getEyeY();
            double dz = target.getZ() - this.getZ();

            double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);

            dx /= distance;
            dy /= distance;
            dz /= distance;

            bullet.shoot(dx, dy, dz, 5F, 15.0F);
            this.level().addFreshEntity(bullet);

            this.swing(InteractionHand.MAIN_HAND);
        }else{
            if (this.level().isClientSide()) return;

            ThrownPotion potion = new ThrownPotion(this.level(), this);

            ItemStack potionStack = PotionUtils.setPotion(
                    new ItemStack(Items.SPLASH_POTION),
                    Potions.HARMING
            );

            potion.setItem(potionStack);

            double dx = target.getX() - this.getX();
            double dy = target.getEyeY() - potion.getY();
            double dz = target.getZ() - this.getZ();

            double distance = Math.sqrt(dx * dx + dz * dz);

            potion.shoot(dx, dy + distance * 2.5, dz, 0.90F, 0.0F);

            this.level().addFreshEntity(potion);
        }


    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}