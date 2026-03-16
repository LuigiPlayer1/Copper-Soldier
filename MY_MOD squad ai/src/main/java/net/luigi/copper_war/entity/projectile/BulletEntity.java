package net.luigi.copper_war.entity.projectile;

import net.luigi.copper_war.entity.ModEntities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BulletEntity extends AbstractArrow {

    public BulletEntity(EntityType<? extends BulletEntity> type, Level level) {
        super(type, level);
        this.setBaseDamage(1.0D); // base damage per hit
        this.setSilent(true);
        this.setNoGravity(true); // bullets fly straight
    }

    public BulletEntity(Level level, LivingEntity shooter) {
        super(ModEntities.BULLET.get(), shooter, level);
        this.setBaseDamage(1.0D);
        this.setSilent(true);
        this.setNoGravity(true);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY; // cannot be picked up
    }

    @Override
    protected void tickDespawn() {
        // remove after 3 seconds (60 ticks)
        if (this.tickCount > 60) {
            this.discard();
        }
    }

    @Override
    protected void doPostHurtEffects(LivingEntity target) {
        super.doPostHurtEffects(target);
        this.playSound(SoundEvents.GENERIC_HURT, 1.0F, 1.0F);
    }

    @Override
    protected void onHitEntity(net.minecraft.world.phys.EntityHitResult result) {
        super.onHitEntity(result);
        this.discard(); // bullet disappears on impact
    }
    @Override
    public void tick() {
        super.tick();

        // Only run particle code on the client
        if (this.level().isClientSide) {
            // Simple smoke trail
            this.level().addParticle(
                    ParticleTypes.SMOKE, // you can change to FLAME, END_ROD, etc.
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    0.0D,
                    0.0D,
                    0.0D
            );

            // Optional: add a tiny sparkle for visibility
            this.level().addParticle(
                    ParticleTypes.END_ROD,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    0.0D,
                    0.0D,
                    0.0D
            );
        }
    }
}