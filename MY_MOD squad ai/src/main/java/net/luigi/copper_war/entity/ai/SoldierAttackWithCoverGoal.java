package net.luigi.copper_war.entity.ai;

import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumSet;

public class SoldierAttackWithCoverGoal extends Goal {

    private final SoldierEntity soldier;
    private final double speed;
    private final float attackRadius;

    private int attackCooldown;
    private int standStillTicks;
    private BlockPos coverOak;

    public SoldierAttackWithCoverGoal(SoldierEntity soldier, double speed, int attackInterval, float attackRadius) {
        this.soldier = soldier;
        this.speed = speed;
        this.attackRadius = attackRadius;
        this.attackCooldown = 0;
        this.standStillTicks = 0;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return soldier.getTarget() != null;
    }

    @Override
    public void start() {
        attackCooldown = 0;
        standStillTicks = 0;
        coverOak = null;
        soldier.setAttacking(false);
    }

    @Override
    public void stop() {
        soldier.setAttacking(false);
        soldier.getNavigation().stop();
        standStillTicks = 0;
        coverOak = null;
    }

    @Override
    public void tick() {
        LivingEntity target = soldier.getTarget();
        if (target == null) return;

        soldier.getLookControl().setLookAt(target, 30.0F, 30.0F);

        // If standing still after shooting, just decrement counter
        if (standStillTicks > 0) {
            standStillTicks--;
            soldier.getNavigation().stop();
            return;
        }

        // If soldier has cover destination, move there first
        if (coverOak != null) {
            double distSq = soldier.blockPosition().distSqr(coverOak);
            if (distSq > 1) {
                soldier.getNavigation().moveTo(coverOak.getX() + 0.5, coverOak.getY(), coverOak.getZ() + 0.5, speed);
                return; // wait until at cover
            } else {
                // Reached cover, reset cover target and start cooldown
                coverOak = null;
                standStillTicks = 20; // wait 1 second behind cover
            }
        }

        // Move toward target if too far or too close
        double distanceSq = soldier.distanceToSqr(target);
        double attackRadiusSq = attackRadius * attackRadius;

        if (distanceSq > attackRadiusSq * 0.75) {
            // too far -> move closer
            soldier.getNavigation().moveTo(target, speed);
        } else if (distanceSq < attackRadiusSq * 0.25) {
            // too close -> back up
            BlockPos away = soldier.blockPosition().offset(
                    -(int) Math.signum(target.getX() - soldier.getX()),
                    0,
                    -(int) Math.signum(target.getZ() - soldier.getZ())
            );
            soldier.getNavigation().moveTo(away.getX(), away.getY(), away.getZ(), speed);
        } else {
            soldier.getNavigation().stop();
        }

        // Start attack if cooldown is done
        if (attackCooldown <= 0 && soldier.hasLineOfSight(target)) {
            soldier.setAttacking(true);
            attackCooldown = 60; // total cooldown
        }

        // Fire mid-animation (tick counter from SoldierEntity)
        if (soldier.isAttacking() && soldier.attackTickCounter == 20) {
            soldier.performRangedAttack(target, 1.0F);
            soldier.swing(InteractionHand.MAIN_HAND);

            // Find nearest oak as cover
            coverOak = findNearestOak();
            soldier.setAttacking(false); // stop attack animation
        }

        if (attackCooldown > 0) attackCooldown--;
    }

    private BlockPos findNearestOak() {
        BlockPos soldierPos = soldier.blockPosition();
        double nearestDist = Double.MAX_VALUE;
        BlockPos nearestOak = null;
        int radius = 10;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -1; y <= 3; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = soldierPos.offset(x, y, z);
                    if (soldier.level().getBlockState(checkPos).is(Blocks.OAK_WOOD)) {
                        double dist = soldierPos.distSqr(checkPos);
                        if (dist < nearestDist) {
                            nearestDist = dist;
                            nearestOak = checkPos;
                        }
                    }
                }
            }
        }

        return nearestOak;
    }
}
