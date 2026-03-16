package net.luigi.copper_war.entity.ai;

import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumSet;

public class SoldierTakeCoverGoal extends Goal {
    private final SoldierEntity soldier;
    private BlockPos targetBlockPos;

    public SoldierTakeCoverGoal(SoldierEntity soldier) {
        this.soldier = soldier;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Only use if soldier has a target
        LivingEntity target = soldier.getTarget();
        if (target == null) return false;

        // Find the nearest oak log
        targetBlockPos = findNearestOakLog();
        return targetBlockPos != null;
    }

    @Override
    public void start() {
        if (targetBlockPos != null) {
            soldier.getNavigation().moveTo(targetBlockPos.getX() + 0.5,
                    targetBlockPos.getY(),
                    targetBlockPos.getZ() + 0.5,
                    1.0D); // speed
        }
    }

    @Override
    public void tick() {
        if (targetBlockPos != null) {
            soldier.getLookControl().setLookAt(targetBlockPos.getX() + 0.5,
                    targetBlockPos.getY(),
                    targetBlockPos.getZ() + 0.5);
        }
    }

    @Override
    public boolean canContinueToUse() {
        if (targetBlockPos == null) return false;
        // Stop when within 3 blocks
        return soldier.distanceToSqr(targetBlockPos.getX() + 0.5,
                targetBlockPos.getY(),
                targetBlockPos.getZ() + 0.5) > 9.0;
    }

    private BlockPos findNearestOakLog() {
        BlockPos soldierPos = soldier.blockPosition();
        BlockPos closest = null;
        double closestDist = Double.MAX_VALUE;

        // simple radius search around the soldier
        for (int x = -10; x <= 10; x++) {
            for (int y = -5; y <= 5; y++) {
                for (int z = -10; z <= 10; z++) {
                    BlockPos pos = soldierPos.offset(x, y, z);
                    if (soldier.level().getBlockState(pos).getBlock() == Blocks.OAK_LOG) {
                        double dist = soldier.distanceToSqr(pos.getX() + 0.5,
                                pos.getY(),
                                pos.getZ() + 0.5);
                        if (dist < closestDist) {
                            closestDist = dist;
                            closest = pos;
                        }
                    }
                }
            }
        }
        return closest;
    }
}
