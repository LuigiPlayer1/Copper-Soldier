package net.luigi.copper_war.entity.custom;

import net.luigi.copper_war.entity.animations.ModAnimationDefinitions;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;

public class AnimatedRandomLookAroundGoal extends RandomLookAroundGoal {
    private final SoldierEntity soldier;
    private int duration;
    private final int maxDuration = 55; // 2.71 seconds (20 ticks per second)

    public AnimatedRandomLookAroundGoal(SoldierEntity soldier) {
        super(soldier);
        this.soldier = soldier;
    }

    @Override
    public void start() {
        super.start();
        this.duration = 0;
        soldier.setIdleLooking(true);
        //soldier.idleLookingAnimationState.stop();  // Stops any previous animation

    }

    @Override
    public void tick() {
        super.tick();
        duration++;
    }

    @Override
    public boolean canContinueToUse() {
        return duration < maxDuration;
    }

    @Override
    public void stop() {
        super.stop();
        soldier.setIdleLooking(false);
    }
}