package net.luigi.copper_war.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.luigi.copper_war.CopperWar;
import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SoldierRenderer extends MobRenderer<SoldierEntity,copper_soldier_blank<SoldierEntity>>{

    public SoldierRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new copper_soldier_blank<>(pContext.bakeLayer((ModModelLayers.SOLDIER_LAYER))), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SoldierEntity soldierEntity) {
        return new ResourceLocation(CopperWar.MOD_ID, "textures/entity/copper_soldier_blank.png");
    }

    @Override
    public void render(SoldierEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {



        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
