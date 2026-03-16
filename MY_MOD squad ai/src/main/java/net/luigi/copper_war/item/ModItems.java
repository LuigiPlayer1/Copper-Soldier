package net.luigi.copper_war.item;

import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CopperWar.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //public static final RegistryObject<Item> SOLDIER_SPAWN_EGG = ITEMS.register("Soldier_spawn_egg",
    //        () -> new ForgeSpawnEggItem(ModEntities.SOLDIER, 0x7e9680, 0xc5d1c5,
        //            new Item.Properties()));

    public static final RegistryObject<Item> SOLDIER_SPAWN_EGG =
            ITEMS.register("soldier_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.SOLDIER, 0x123456, 0x654321, new Item.Properties()));
}