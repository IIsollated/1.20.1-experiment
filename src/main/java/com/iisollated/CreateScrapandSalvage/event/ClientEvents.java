package com.iisollated.CreateScrapandSalvage.event;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.BrassBeetleBooleans;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.PlayerBBBProvider;
import com.iisollated.CreateScrapandSalvage.networking.ModMessages;
import com.iisollated.CreateScrapandSalvage.networking.packet.ToggleGlidingC2SPacket;
import com.iisollated.CreateScrapandSalvage.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ClientEvents {
    @Mod.EventBusSubscriber(modid = CreateScrapandSalvage.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.TOGGLE_GLIDING.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a Key!"));
                ModMessages.sendToServer(new ToggleGlidingC2SPacket());

                BrassBeetleBooleans playerBooleans = Minecraft.getInstance().player.getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).orElse(null);
                if (playerBooleans != null) {
                    // Toggle the gliding state for the player who used the keybind
                    playerBooleans.setGlideState(!playerBooleans.getGlideState());
                    System.out.println("glideState " + playerBooleans.getGlideState());
                }
            }
        }


        @Mod.EventBusSubscriber(modid = CreateScrapandSalvage.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event) {
                event.register(KeyBinding.TOGGLE_GLIDING);
            }
        }
    }
}