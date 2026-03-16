package net.luigi.copper_war.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.luigi.copper_war.entity.projectile.BulletEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class BulletRenderer extends EntityRenderer<BulletEntity> {

    public BulletRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(BulletEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        // Minimal: do nothing, just avoid crashes
    }

    @Override
    public ResourceLocation getTextureLocation(BulletEntity entity) {
        // Return any valid texture
        return new ResourceLocation("minecraft", "textures/item/arrow.png");
    }
}