package com.iisollated.CreateScrapandSalvage.item.custom;

import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.BrassBeetleBooleans;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.PlayerBBBProvider;
import com.iisollated.CreateScrapandSalvage.item.client.BrassBeetleGliderRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;

public class BrassBeetleGliderItem extends ArmorItem implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private boolean glideState = false;
    
    public BrassBeetleGliderItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BrassBeetleGliderRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new BrassBeetleGliderRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    public static boolean isFlyEnabled(ItemStack pElytraStack) {
        return pElytraStack.getDamageValue() < pElytraStack.getMaxDamage() - 1;
    }


    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        BrassBeetleBooleans playerBooleans = entity.getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).orElse(null);
        return ElytraItem.isFlyEnabled(stack) && playerBooleans != null && playerBooleans.getGlideState();
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                if (nextFlightTick % 20 == 0) {
                    stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
                }
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.CHEST;
    }

    private PlayState predicate(AnimationState animationState) {
        BrassBeetleBooleans playerBooleans = Minecraft.getInstance()
                .player.getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).orElse(null);
        if (playerBooleans != null) {
            glideState = playerBooleans.getGlideState();
        }
        if (glideState) {
            animationState.getController().setAnimationSpeed(0.5);
            animationState.getController().setAnimation(RawAnimation.begin().
                    then("wings_spread", Animation.LoopType.PLAY_ONCE)
                    .then("wings_open", Animation.LoopType.LOOP));
        } else {
            animationState.getController().setAnimationSpeed(0.5);
            animationState.getController().setAnimation(RawAnimation.begin().
                    then("wings_retract", Animation.LoopType.PLAY_ONCE)
                    .then("wings_closed", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}