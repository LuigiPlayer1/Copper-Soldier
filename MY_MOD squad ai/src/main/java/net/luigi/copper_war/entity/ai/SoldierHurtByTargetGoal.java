package net.luigi.copper_war.entity.ai;

import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class SoldierHurtByTargetGoal extends HurtByTargetGoal {
    private final SoldierEntity soldier;

    public SoldierHurtByTargetGoal(SoldierEntity soldier) {
        super(soldier);
        this.soldier = soldier;
    }

    @Override
    public void start() {
        super.start();
        soldier.enterCombatMode();
    }

}
