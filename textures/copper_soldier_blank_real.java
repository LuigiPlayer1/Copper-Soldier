// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class copper_soldier_blank_real<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "copper_soldier_blank_real"), "main");
	private final ModelPart soldier;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart helmet;
	private final ModelPart right_arm;
	private final ModelPart rightItem;
	private final ModelPart left_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public copper_soldier_blank_real(ModelPart root) {
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

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		soldier.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}