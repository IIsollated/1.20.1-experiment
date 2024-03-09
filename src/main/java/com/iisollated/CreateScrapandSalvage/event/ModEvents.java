package com.iisollated.CreateScrapandSalvage.event;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.BrassBeetleBooleans;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.PlayerBBBProvider;
import com.iisollated.CreateScrapandSalvage.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = CreateScrapandSalvage.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).isPresent()) {
                event.addCapability(new ResourceLocation(CreateScrapandSalvage.MOD_ID, "properties"), new PlayerBBBProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(BrassBeetleBooleans.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).ifPresent(ableToGlide -> {
                if(EquipmentSlot.CHEST.equals(ModItems.BRASS_GLIDER)) {
                    ableToGlide.getGlideState();
                    event.player.sendSystemMessage(Component.literal("ableToGlide " + ableToGlide));
                }
            });
        }
    }
}

