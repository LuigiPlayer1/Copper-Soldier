package net.luigi.copper_war.entity;

import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.luigi.copper_war.entity.projectile.BulletEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CopperWar.MOD_ID);

    public static final RegistryObject<EntityType<SoldierEntity>> SOLDIER =
            ENTITY_TYPES.register("soldier", () -> EntityType.Builder.of(SoldierEntity::new, MobCategory.CREATURE)
                    .sized(0.6f,0.6f)
                    .build("soldier"));

    public static final RegistryObject<EntityType<BulletEntity>> BULLET =
            ENTITY_TYPES.register("bullet",
                    () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("bullet"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }


}
