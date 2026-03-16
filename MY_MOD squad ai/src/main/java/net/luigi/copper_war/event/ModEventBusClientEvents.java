package net.luigi.copper_war.event;

import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.entity.ModEntities;
import net.luigi.copper_war.entity.client.ModModelLayers;
import net.luigi.copper_war.entity.client.renderer.BulletRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.luigi.copper_war.entity.client.copper_soldier_blank;

@Mod.EventBusSubscriber(modid = CopperWar.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.SOLDIER_LAYER, copper_soldier_blank::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Register the bullet renderer
        event.registerEntityRenderer(ModEntities.BULLET.get(), BulletRenderer::new);
    }

}
