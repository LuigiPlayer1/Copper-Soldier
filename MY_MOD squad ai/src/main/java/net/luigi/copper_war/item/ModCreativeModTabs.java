package net.luigi.copper_war.item;

import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CopperWar.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COPPERWAR_TAB = CREATIVE_MODE_TABS.register("copperwar_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.copperwar_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());

                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ModBlocks.SOLDIER_BLOCK.get());

                        pOutput.accept(ModItems.SOLDIER_SPAWN_EGG.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}