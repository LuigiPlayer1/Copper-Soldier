package net.luigi.copper_war.event;

import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.entity.ModEntities;
import net.luigi.copper_war.entity.client.ModModelLayers;
import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.luigi.copper_war.entity.client.copper_soldier_blank;

@Mod.EventBusSubscriber(modid = CopperWar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.SOLDIER.get(), SoldierEntity.createAttributes().build());
    }

}