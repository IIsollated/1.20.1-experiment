package com.iisollated.CreateScrapandSalvage.networking.packet;

import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.BrassBeetleBooleans;
import com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata.PlayerBBBProvider;
import com.iisollated.CreateScrapandSalvage.item.ModItems;
import com.iisollated.CreateScrapandSalvage.item.custom.BrassBeetleGliderItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ToggleGlidingC2SPacket {

    private static final String MESSAGE_GLIDER_EQUIPPED = "message.create_scrapandsalvage.glider_equipped";
    private static final String MESSAGE_NO_GLIDER = "message.create_scrapandsalvage.no_glider";

    public ToggleGlidingC2SPacket() {

    }

    public ToggleGlidingC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();

            if (hasGliderEquipped(player)) {

                player.sendSystemMessage(Component.translatable(MESSAGE_GLIDER_EQUIPPED)
                        .withStyle(ChatFormatting.DARK_RED));

                player.getCapability(PlayerBBBProvider.GLIDE_STATE_TOGGLE).ifPresent(hasGliderEquipped -> {
                    hasGliderEquipped(player);
                });

            } else {

                player.sendSystemMessage(Component.translatable(MESSAGE_NO_GLIDER)
                        .withStyle(ChatFormatting.AQUA));

            }
        });
        return true;
    }

    public boolean hasGliderEquipped(ServerPlayer player) {
        for (ItemStack stack : player.getInventory().armor) {
            if (stack.getItem() instanceof BrassBeetleGliderItem) {
                return true;
            }
        }
        return false;
    }
}