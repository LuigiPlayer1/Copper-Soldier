package net.luigi.copper_war.entity.ai;

import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SoldierAttackGoal extends RangedAttackGoal {

    private final SoldierEntity soldier;
    private final double moveSpeed;
    private final float attackRadius;
    private int attackCooldown;
    private int attackCooldownvision;
    private int standStillTicks;
    private final double retreatDistance = 10.0D; // blocks
    private final double retreatChance = 1D;   // 40% chance
    private int lostSightTicks = 0;
    private static final int MAX_LOST_SIGHT_TIME = 40; // 2 seconds
    private int lostSightTicksvision = 0;
    private static final int MAX_LOST_SIGHT_TIME_VISION = 40;

    public SoldierAttackGoal(SoldierEntity soldier, double speed, int attackInterval, float attackRadius) {
        super(soldier, speed, attackInterval, attackRadius);
        this.soldier = soldier;
        this.moveSpeed = speed;
        this.attackRadius = attackRadius;
        this.attackCooldown = 0;
        this.attackCooldownvision = 0;
        this.standStillTicks = 0;
    }

    @Override
    public void start() {
        super.start();
        attackCooldown = 0;
        attackCooldownvision = 0;
        standStillTicks = 0;
        soldier.setAttacking(false);
        soldier.setAttackingvision(false);
        soldier.setAttackingvisionafter(false);
    }

    @Override
    public void stop() {
        super.stop();
        soldier.getNavigation().stop();
        soldier.setAttacking(false);
        soldier.setAttackingvision(false);
        soldier.setAttackingvisionafter(false);
        standStillTicks = 0;
    }




    private int chaseDelay = 0;

    private int chaseDelayvision = 0;

    private int holddelay = 0;

    private int ticktimeleader = 0;
    private int ticktimeleaderwait = 0;
    private int supnewdistance = 0;
    private int ticktimesup = 0;
    private int ticktimesupwait = 0;
    private boolean hasrole = false;
    private int attackleader = 0;
    private int timetoattack = 0;
    private int bulletcount = 4;
    private int bulletcountwait = 6;

    private int attacksup = 0;
    private int timetoattacksup = 0;
    private int bulletcountsup = 4;
    private int bulletcountwaitsup = 6;

    private int ticktimeflank = 0;
    private int ticktimeflankwait = 180;
    private int attackflank = 0;
    private int timetoattackflank = 0;
    private int bulletcountflank = 4;
    private int bulletcountwaitflank = 6;
    private int ticktimeflankrun = 0;
    private int ticktimeflankwaitrun = 0;

    @Override
    public void tick() {
        LivingEntity target = soldier.getTarget();
        if (target == null) return;
        soldier.enterCombatMode();

        if(hasrole == false) {
            soldier.assignSquadRoles();
            hasrole = true;
        }
        soldier.getLookControl().setLookAt(target, 30.0F, 30.0F);

        double distanceSq = soldier.distanceToSqr(target);

        boolean canSee = soldier.hasLineOfSight(target);


        int minwalk = 15;
        int maxwalk = 20;

        int minwait = 40;
        int maxwait = 60;

        int minwalksup = 25;
        int maxwalksup = 30;

        int minwaitsup = 10;
        int maxwaitsup = 40;
        switch (soldier.getSquadRole()) {
            case SQUAD_LEADER:
//                if(soldier.hasLineOfSight(target)){
                    soldier.getNavigation().stop();
                    if (ticktimeleaderwait <= 0){
                        ticktimeleaderwait = (int)(Math.random() * (maxwait - minwait + 1)) + minwait;
                        ticktimeleader = (int)(Math.random() * (maxwalk - minwalk + 1)) + minwalk;
                    }


                    if (ticktimeleader > 0 && distanceSq > 3 * 3){
                        soldier.getNavigation().moveTo(target, moveSpeed);
                        ticktimeleader--;
                        bulletcountwait = 6;
                    }else if (ticktimeleader > 0){
                        bulletcount = 4;
                        ticktimeleader--;
                        bulletcountwait = 6;
                    }

                     if (ticktimeleader > 0 && !soldier.hasLineOfSight(target)){

                    }
                    if(ticktimeleader <= 0 && ticktimeleaderwait > 0){
                        ticktimeleaderwait--;
                        bulletcountwait--;
                        soldier.getNavigation().stop();
                        if(attackleader > 5 && soldier.hasLineOfSight(target) && timetoattack <= 0 && bulletcount > 0 && bulletcountwait <= 0){
                            soldier.performRangedAttack(target,1.0f);
                            //System.out.println("fire");
                            attackleader = 0;
                            bulletcount--;
                        }else if(timetoattack <= 0){
                            attackleader++;
                        }
                        //break;
                    }else if(distanceSq <= 2 * 2 && soldier.hasLineOfSight(target)){
                        ticktimeleaderwait = (int)(Math.random() * (maxwait - minwait + 1)) + minwait;
                        ticktimeleader = 0;
                    }else if(distanceSq <= 3 * 3 && !soldier.hasLineOfSight(target)){
                        soldier.getNavigation().moveTo(target, moveSpeed);
                    }
//                }else{
//                    soldier.getNavigation().moveTo(target, moveSpeed);
//                }
                break;
            case FLANKER:
                if (distanceSq > 10 * 10 && ticktimeflank <= 0) {
                    soldier.getNavigation().moveTo(target, 1f);
                } else if (distanceSq <= 9 * 9) {

                    soldier.getNavigation().stop();
                    if(ticktimeflankwait <= 0){
                        bulletcountflank = 4;
                        bulletcountwaitflank = 6;
                        ticktimeflankwait = 180;
                        double radius = 5.0;


                        List<SoldierEntity> soldiers = target.level().getEntitiesOfClass(
                                SoldierEntity.class,
                                target.getBoundingBox().inflate(radius)
                        );

                        if (!soldiers.isEmpty()) {
                            break;
                        }else
                        if(distanceSq > 5 * 5 & soldier.canThrowPotion(0.8,9)) {

                                Vec3 lookDir = soldier.getViewVector(1.0F); // direction the soldier is looking

// Move backwards from that direction
                                Vec3 moveBack = soldier.position().subtract(lookDir.scale(2.0)); // 3 blocks back

                                soldier.getNavigation().moveTo(moveBack.x, moveBack.y, moveBack.z, moveSpeed);
                                soldier.trowpotion(true);
                                soldier.performRangedAttack(target, 1.0f);
                                soldier.trowpotion(false);
                                ticktimeflank = 20;
//                            } else {
//                                ticktimeflank--;
//                            }
                        }


                    }else{
                        soldier.getNavigation().stop();

                        ticktimeflankwait--;
                        if(ticktimeflankwait > 0){
                            System.out.println("wait");
                            bulletcountwaitflank--;
                            if(attackflank > 5 && soldier.hasLineOfSight(target) && timetoattackflank <= 0 && bulletcountflank > 0 && bulletcountwaitflank <= 0){
                                soldier.performRangedAttack(target,1.0f);
                                System.out.println("fire");
                                attackflank = 0;
                                bulletcountflank--;
                            }else if(timetoattackflank <= 0){
                                attackflank++;
                            }
                            ticktimeflankwait--;
                        }
                    }

                }else{
                    ticktimeflank--;
                }
                if(ticktimeflankwaitrun > 0){
                    ticktimeflankwaitrun--;
                }else
                if(ticktimeflankrun > 0 && distanceSq <= 8 * 8 && target.hasLineOfSight(soldier) && ticktimeflankwaitrun <= 0){
                    // Get positions
                    Vec3 currentPos = soldier.position();
                    Vec3 targetPos = target.position();

                    // Calculate direction vector from target to soldier
                    Vec3 direction = currentPos.subtract(targetPos).normalize(); // points away from target

                    // Decide how far away you want to move
                    double distance = 3.0; // blocks to move away

                    // Calculate new destination
                    Vec3 newPos = currentPos.add(direction.scale(distance));

                    // Tell the navigation to move there
                    soldier.getNavigation().moveTo(newPos.x, newPos.y, newPos.z, moveSpeed);
                    ticktimeflankrun--;
                }else{
                    ticktimeflankrun = 20;
                    ticktimeflankwaitrun = 30;
                }

                break;
            case SUPPORT:
                if (ticktimesupwait <= 0){
                    ticktimesupwait = (int)(Math.random() * (maxwaitsup - minwaitsup + 1)) + minwaitsup;
                    ticktimesup = (int)(Math.random() * (maxwalksup - minwalksup + 1)) + minwalksup;
                }
                if(ticktimesup > 0) {
                    bulletcountsup = 4;
                    bulletcountwaitsup = 6;
                    if (target.hasLineOfSight(soldier) && distanceSq < 6 * 6 && distanceSq > 3 * 3) {
                        // Get positions
                        Vec3 currentPos = soldier.position();
                        Vec3 targetPos = target.position();

                        // Calculate direction vector from target to soldier
                        Vec3 direction = currentPos.subtract(targetPos).normalize(); // points away from target

                        // Decide how far away you want to move
                        double distance = 3.0; // blocks to move away

                        // Calculate new destination
                        Vec3 newPos = currentPos.add(direction.scale(distance));

                        // Tell the navigation to move there
                        soldier.getNavigation().moveTo(newPos.x, newPos.y, newPos.z, moveSpeed);


                    }if(!soldier.hasLineOfSight(target) && !soldier.isSquadLeaderAlive()){
                        soldier.getNavigation().moveTo(target, moveSpeed);
                    }
                    if (distanceSq < 3 * 3) {
                        if (supnewdistance <= 0) {
                            Vec3 randomAwayPos = DefaultRandomPos.getPosAway(
                                    soldier,
                                    10, // horizontal search radius
                                    4,  // vertical range
                                    target.position()
                            );

                            if (randomAwayPos != null) {
                                soldier.getNavigation().moveTo(randomAwayPos.x, randomAwayPos.y, randomAwayPos.z, moveSpeed);
                            }
                            supnewdistance = 5;
                        } else {
                            supnewdistance--;
                        }

                    } else if (distanceSq > 10 * 10) {
                        soldier.getNavigation().moveTo(target, moveSpeed);
                        supnewdistance = 5;
                    } else if (distanceSq >= 9 * 9 && soldier.isSquadLeaderAlive()


                    ) {
                        soldier.getNavigation().stop();
                    }
                    ticktimesup--;
                }else if(ticktimesupwait>0){
                    soldier.getNavigation().stop();
                    bulletcountwaitsup--;
                    if(attacksup > 5 && soldier.hasLineOfSight(target) && timetoattacksup <= 0 && bulletcountsup > 0 && bulletcountwaitsup <= 0){
                        soldier.performRangedAttack(target,1.0f);
                        System.out.println("fire");
                        attacksup = 0;
                        bulletcountsup--;
                    }else if(timetoattacksup <= 0){
                        attacksup++;
                    }
                    ticktimesupwait--;






                }
        }



    }
//    @Override
//    public void tick() {
//        LivingEntity target = soldier.getTarget();
//        if (target == null) return;
//
//
//
//        // Count nearby soldiers in 8 block radius
//        int nearbySoldiers = soldier.level().getEntitiesOfClass(
//                SoldierEntity.class,
//                soldier.getBoundingBox().inflate(24.0D)
//        ).size();
//
//        // Look at target
//        soldier.getLookControl().setLookAt(target, 30.0F, 30.0F);
//
//        // If in post-shot pause, don't move or attack
//        //if (standStillTicks > 0) {
//        //    standStillTicks--;
//         //   soldier.getNavigation().stop();
//         //   return;
//        //}
//
//        // Calculate distance squared to target
//        double distanceSq = soldier.distanceToSqr(target);
//        double attackRangeSq = attackRadius * attackRadius;
//
//
//
//        // Handle attack timing
//        boolean canSee = soldier.hasLineOfSight(target);
//
//        if (!canSee && lostSightTicks < MAX_LOST_SIGHT_TIME_VISION && soldier.getRandom().nextFloat() < 0.4F && chaseDelay == 0) {
//            soldier.getNavigation().moveTo(target, moveSpeed);
//            chaseDelay = 80;
//        }
//
//        if (canSee) {
//            lostSightTicks = 0;
//        } else {
//            lostSightTicks++;
//        }
//
//        if(chaseDelay > 0){
//            chaseDelay--;
//        }
//
//        if(chaseDelayvision > 0){
//            chaseDelayvision--;
//        }
//
//        if (!canSee && lostSightTicksvision < MAX_LOST_SIGHT_TIME_VISION && soldier.getRandom().nextFloat() < 0.4F && chaseDelayvision == 0) {
//            soldier.getNavigation().moveTo(target, moveSpeed);
//            chaseDelayvision = 80;
//        }
//
//        if (canSee) {
//            lostSightTicksvision = 0;
//        } else {
//            lostSightTicksvision++;
//        }
//
//        if (soldier.isAttackingvision() && !canSee){
//            attackCooldownvision = this.adjustedTickDelay(160);
//        }
//
//        if (soldier.isAttackingvision() && canSee || holddelay != 0) {
//
//            if (holddelay == 0) {
//                holddelay = 4;
//            } else if (holddelay > 0) {
//                holddelay--;
//                if (holddelay == 0) {
//                    soldier.setAttacking(false);
//                    soldier.setAttackingvision(false);
//
//                    soldier.setAttackingvisionafter(true);
//
//                    soldier.performRangedAttack(target, 1.0F);
//                    soldier.swing(InteractionHand.MAIN_HAND);
//
//                    // Refresh combat mode whenever he attacks
//                    soldier.enterCombatMode();
//
//                    standStillTicks = 00; // already there
//
//                    // ---- GROUP TACTIC CHECK ----
//                    if (nearbySoldiers >= 3 && soldier.getRandom().nextFloat() < 0.4F) {
//
//                        // Random aggressive movement around the target
//                        double angle = soldier.getRandom().nextDouble() * Math.PI * 2;
//                        double radius = 2.0D + soldier.getRandom().nextDouble() * 3.0D; // 2–5 blocks offset
//
//                        double offsetX = Math.cos(angle) * radius;
//                        double offsetZ = Math.sin(angle) * radius;
//
//                        double moveX = target.getX() + offsetX;
//                        double moveZ = target.getZ() + offsetZ;
//
//                        soldier.getNavigation().moveTo(moveX, target.getY(), moveZ, moveSpeed);
//
//                    } else {
//
//                        // ---- NORMAL RETREAT LOGIC ----
//                        if (distanceSq < retreatDistance * retreatDistance && soldier.getRandom().nextFloat() < 0.4F) {
//
//                            double retreatAmount = 4.0D + soldier.getRandom().nextDouble() * 4.0D;
//
//                            double dx = soldier.getX() - target.getX();
//                            double dz = soldier.getZ() - target.getZ();
//
//                            double length = Math.sqrt(dx * dx + dz * dz);
//                            if (length > 0) {
//                                dx /= length;
//                                dz /= length;
//                            }
//
//                            double retreatX = soldier.getX() + dx * retreatAmount;
//                            double retreatZ = soldier.getZ() + dz * retreatAmount;
//
//                            soldier.getNavigation().moveTo(retreatX, soldier.getY(), retreatZ, moveSpeed);
//                        }
//                    }
//                    attackCooldown = this.adjustedTickDelay(40);
//                }
//            }
//        }
//
//        if (attackCooldown <= 0 && canSee) {
//            System.out.println("regular");
//            soldier.setAttacking(true);
//            soldier.setAttackingvision(false);
//            soldier.setAttackingvisionafter(false);
//            soldier.attackTickCounter = 0; // reset counter
//            attackCooldown = this.adjustedTickDelay(80);
//        }
//
//
//
//        if (attackCooldownvision <= 0 && !canSee && lostSightTicksvision > 160 && soldier.distanceToSqr(target) < 6 * 6) {
//            soldier.getNavigation().stop();
//            soldier.setDeltaMovement(0, soldier.getDeltaMovement().y, 0);
//
//            System.out.println("holding");
//            soldier.setAttackingvision(true);
//            soldier.setAttacking(false);
//            soldier.setAttackingvisionafter(false);
//            soldier.attackTickCountervision = 0; // reset counter
//            attackCooldownvision = this.adjustedTickDelay(160);
//            attackCooldown = this.adjustedTickDelay(80);
//            return;
//        }else if(!canSee && soldier.distanceToSqr(target) > 6 * 6){
//            soldier.setAttackingvision(false);
//            //soldier.setAttacking(false);
//            soldier.setAttackingvisionafter(false);
//        }
//
//
//
//
//
//        // Fire mid-animation
//        if (soldier.isAttacking() && soldier.attackTickCounter == 20) {
//            soldier.performRangedAttack(target, 1.0F);
//            soldier.swing(InteractionHand.MAIN_HAND);
//
//            // Refresh combat mode whenever he attacks
//            soldier.enterCombatMode();
//
//            standStillTicks = 00; // already there
//
//            float thinking = soldier.getRandom().nextFloat();
//            // ---- GROUP TACTIC CHECK ----
//            if (nearbySoldiers >= 3 &&  thinking < 0.6F) {
//
//                // Random aggressive movement around the target
//                double angle = soldier.getRandom().nextDouble() * Math.PI * 2;
//                double radius = 2.0D + soldier.getRandom().nextDouble() * 3.0D; // 2–5 blocks offset
//
//                double offsetX = Math.cos(angle) * radius;
//                double offsetZ = Math.sin(angle) * radius;
//
//                double moveX = target.getX() + offsetX;
//                double moveZ = target.getZ() + offsetZ;
//
//                soldier.getNavigation().moveTo(moveX, target.getY(), moveZ, moveSpeed);
//
//
//
//            } else {
//
//                // ---- NORMAL RETREAT LOGIC ----
//                if (distanceSq < retreatDistance * retreatDistance && soldier.getRandom().nextFloat() < 0.4F) {
//
//                    double retreatAmount = 4.0D + soldier.getRandom().nextDouble() * 4.0D;
//
//                    double dx = soldier.getX() - target.getX();
//                    double dz = soldier.getZ() - target.getZ();
//
//                    double length = Math.sqrt(dx * dx + dz * dz);
//                    if (length > 0) {
//                        dx /= length;
//                        dz /= length;
//                    }
//
//                    double retreatX = soldier.getX() + dx * retreatAmount;
//                    double retreatZ = soldier.getZ() + dz * retreatAmount;
//
//                    soldier.getNavigation().moveTo(retreatX, soldier.getY(), retreatZ, moveSpeed);
//
//
//                }
//            }
//        }
//
//        if (attackCooldown > 0) attackCooldown--;
//
//        if (attackCooldownvision > 0) attackCooldownvision--;
//
//        // Stop attacking flag when cooldown expires
//        if (attackCooldown <= 0 && soldier.isAttacking() ) {
//            soldier.setAttacking(false);
//
//        }
//
//        if (attackCooldownvision <= 0 && soldier.isAttackingvision() ) {
//            soldier.setAttackingvision(false);
//
//        }
//    }
}
