package net.luigi.copper_war.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {
    static float offsetX = 46F; // degrees
    static float offsetX2 = offsetX + 20;
    float offsetY = 0F;
    float offsetZ = 0F;

        public static final AnimationDefinition idle = AnimationDefinition.Builder.withLength(0.01F)
                .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();


        public static final AnimationDefinition walking = AnimationDefinition.Builder.withLength(1.0417F).looping()
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -12.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -12.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 12.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 12.5F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 5.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.11F, -12.8872F, 3.8764F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(5.2957F, 20.5735F, -5.6627F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(5.4961F, 25.5514F, -5.1518F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(4.9812F, -5.633F, 7.0382F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(5.0436F, -10.614F, 6.597F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0436F, 10.614F, -6.597F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(5.2957F, 20.5735F, -5.6627F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0289F, -7.9067F, 4.3255F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(5.11F, -12.8872F, 3.8764F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-55.0202F, -6.1598F, -4.2694F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-54.7684F, 6.1378F, 4.3184F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-54.7684F, 6.1378F, 4.3184F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-54.6423F, -4.0845F, -2.9132F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-54.6423F, -4.0845F, -2.9132F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-54.3313F, 8.1489F, 5.7891F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-54.3313F, 8.1489F, 5.7891F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-55.2257F, -2.0571F, -1.4036F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-55.0202F, -6.1598F, -4.2694F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-64.9162F, -4.5305F, -2.1175F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-64.9162F, 4.5305F, 2.1175F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-64.9162F, 4.5305F, 2.1175F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-64.6624F, -9.0548F, -4.2617F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-64.6624F, -9.0548F, -4.2617F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-64.9791F, 2.2656F, 1.0571F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-64.9791F, 2.2656F, 1.0571F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-64.9791F, -2.2656F, -1.0571F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-64.9162F, -4.5305F, -2.1175F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();

        public static final AnimationDefinition start_walking = AnimationDefinition.Builder.withLength(0.2083F)
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(4.9811F, -0.4352F, 4.9811F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

    public static final AnimationDefinition animationwalking_to_aim = AnimationDefinition.Builder.withLength(3F)
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.434F, -0.0379F, -0.0096F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(7.5F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-20.0F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(7.5F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.434F, -0.0379F, -0.0096F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.2292F, 0.0417F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(5.6664F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.6664F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-6.8336F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-19.3336F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.5F, KeyframeAnimations.degreeVec(-6.8336F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(10.6664F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(5.6664F, -4.718F, -2.9513F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.2292F, 0.0417F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-45.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-82.3563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-82.3563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-74.8563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-89.8563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-74.8563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-82.3563F , 34.0544F, 8.6177F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(-45.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-90.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-90.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-82.5F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(-95.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.6667F, KeyframeAnimations.degreeVec(-82.5F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.875F, KeyframeAnimations.degreeVec(-90.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.0F, KeyframeAnimations.degreeVec(-90.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(-65.0F , 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(17.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(-22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();

        public static final AnimationDefinition idle_looking = AnimationDefinition.Builder.withLength(2.7083F)
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-11.2431F, 27.0478F, -5.1652F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-14.1848F, 29.4168F, -6.0887F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-14.1848F, 29.4168F, -6.0887F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-4.8868F, 1.2978F, -0.5028F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-10.8884F, -22.1346F, 4.1521F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.degreeVec(-13.6906F, -24.5328F, 4.903F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-13.6906F, -24.5328F, 4.903F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, 180.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.degreeVec(0.0F, 360.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("helmet", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 2.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-5.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-7.5239F, 7.4904F, -0.2197F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.1009F, -12.4331F, 1.5379F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-7.6552F, -14.9231F, 1.7678F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-45.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-65.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();


        public static final AnimationDefinition holdingfire = AnimationDefinition.Builder.withLength(10f)
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("head",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_leg",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_leg",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(10f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
        public static final AnimationDefinition shooting = AnimationDefinition.Builder.withLength(0.875f)
                .addAnimation("head",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08333f, KeyframeAnimations.degreeVec(7.5f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(-20f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.66667f, KeyframeAnimations.degreeVec(7.5f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.875f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(0.43f, 2.46f, 0.01f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08333f, KeyframeAnimations.degreeVec(-6.83f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(-19.33f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.5f, KeyframeAnimations.degreeVec(-6.83f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.75f, KeyframeAnimations.degreeVec(10.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.875f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(5.46f, -4.96f, -0.45f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08333f, KeyframeAnimations.degreeVec(-74.86f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(-89.86f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-74.86f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.875f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(-55f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.08333f, KeyframeAnimations.degreeVec(-82.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.25f, KeyframeAnimations.degreeVec(-95f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.66667f, KeyframeAnimations.degreeVec(-82.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(0.875f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(-65f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_leg",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_leg",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.25f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR),
                                new Keyframe(1.5f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition IDLE_LOOKING = AnimationDefinition.Builder.withLength(2.70833f)
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.54167f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.45833f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-11.24f, 27.05f, -5.17f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.375f, KeyframeAnimations.degreeVec(-14.18f, 29.42f, -6.09f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.54167f, KeyframeAnimations.degreeVec(-14.18f, 29.42f, -6.09f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.79167f, KeyframeAnimations.degreeVec(-4.89f, 1.3f, -0.5f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-10.89f, -22.13f, 4.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.08333f, KeyframeAnimations.degreeVec(-13.69f, -24.53f, 4.9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(-13.69f, -24.53f, 4.9f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.54167f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.degreeVec(0f, 180f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.20833f, KeyframeAnimations.degreeVec(0f, 360f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.45833f, KeyframeAnimations.degreeVec(0f, 360f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("helmet",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.54167f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.83333f, KeyframeAnimations.posVec(0f, 2f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.33333f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("body",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.29167f, KeyframeAnimations.degreeVec(-5f, 5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.54167f, KeyframeAnimations.degreeVec(-7.52f, 7.49f, -0.22f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-5.1f, -12.43f, 1.54f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(-7.66f, -14.92f, 1.77f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.54167f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-65f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition HOLDINGFIRE = AnimationDefinition.Builder.withLength(10f)
            .addAnimation("body",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(5.67f, -4.72f, -2.95f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 2.5f, -10f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_arm",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(-82.36f, 34.05f, 8.62f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(10f, KeyframeAnimations.degreeVec(-22.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
