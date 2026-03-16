package net.luigi.copper_war.entity.client;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.luigi.copper_war.entity.animations.ModAnimationDefinitions;
import net.luigi.copper_war.entity.custom.SoldierEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class copper_soldier_blank<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart soldier;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart helmet;
    private final ModelPart right_arm;
    private final ModelPart rightItem;
    private final ModelPart left_arm;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public copper_soldier_blank(ModelPart root) {
        this.soldier = root.getChild("soldier");
        this.body = this.soldier.getChild("body");
        this.head = this.body.getChild("head");
        this.helmet = this.head.getChild("helmet");
        this.right_arm = this.body.getChild("right_arm");
        this.rightItem = this.right_arm.getChild("rightItem");
        this.left_arm = this.body.getChild("left_arm");
        this.left_leg = this.soldier.getChild("left_leg");
        this.right_leg = this.soldier.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition soldier = partdefinition.addOrReplaceChild("soldier", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = soldier.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(56, 0).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(37, 8).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.01F))
                .texOffs(37, 0).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -1.0F, -2.0F, 10.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(30, 55).addBox(-7.0F, 0.0F, -2.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 52).addBox(-6.0F, 0.0F, 9.0F, 8.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(-1, 50).addBox(2.0F, 0.0F, -1.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(40, 49).addBox(-7.0F, 0.0F, -1.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(1, 0).addBox(2.0F, 3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 0).addBox(-7.0F, 3.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, -4.0F));

        PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 16).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 0.0F));

        PartDefinition rightItem = right_arm.addOrReplaceChild("rightItem", CubeListBuilder.create(), PartPose.offset(-1.0F, 7.4F, -1.0F));

        PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(50, 16).addBox(0.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -6.0F, 0.0F));

        PartDefinition left_leg = soldier.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 27).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.0F, 0.0F));

        PartDefinition right_leg = soldier.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 27).addBox(-1.9F, 0.0F, -1.99F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    private double idleTime = 0;        // how long the entity has been standing still
    private boolean playedSpecialIdle = false; // flag for playing the special idle once

    @Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        if (((SoldierEntity) entity).isIdleLooking() && ((SoldierEntity) entity).getPose() == Pose.STANDING && !((SoldierEntity) entity).isAttackingvision() && !((SoldierEntity) entity).isAttacking() && !((SoldierEntity) entity).isAttackingvisionafter()) {
            this.animate(((SoldierEntity) entity).idleLookingAnimationState, ModAnimationDefinitions.idle_looking, ageInTicks, 1f);
        }if(!((SoldierEntity) entity).isIdleLooking() && !((SoldierEntity) entity).isAttackingvision() && !((SoldierEntity) entity).isAttacking() && !((SoldierEntity) entity).isAttackingvisionafter()){
            this.animate(((SoldierEntity) entity).idleAnimationState, ModAnimationDefinitions.idle, ageInTicks, 1f);

        }


        if (((SoldierEntity) entity).isAttacking()) {
            this.animate(((SoldierEntity) entity).attackAnimationState, ModAnimationDefinitions.animationwalking_to_aim, ageInTicks, 1f);
        }
        if (((SoldierEntity) entity).getPose() == Pose.STANDING && ((SoldierEntity) entity).isAttackingvision()) {
            this.animate(((SoldierEntity) entity).attackAnimationStateloop, ModAnimationDefinitions.holdingfire, ageInTicks, 1f);

        }

        if (((SoldierEntity) entity).getPose() == Pose.STANDING && ((SoldierEntity) entity).isAttackingvisionafter()) {
            this.animate(((SoldierEntity) entity).attackAnimationStateshoot, ModAnimationDefinitions.shooting, ageInTicks, 1f);
        }





        this.animateWalk(ModAnimationDefinitions.walking, limbSwing, limbSwingAmount, 2.5f, 2.5f);
        //this.animate(((SoldierEntity) entity).idleAnimationState, ModAnimationDefinitions.idle, ageInTicks, 1f);







    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		soldier.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return soldier;
    }
}