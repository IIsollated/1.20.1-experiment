package com.iisollated.CreateScrapandSalvage.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.iisollated.CreateScrapandSalvage.util.ModTags.Blocks.SCRAP_HEAP;
import static net.minecraft.world.item.Tiers.WOOD;


public class SickleItem extends DiggerItem {
    public static TagKey<Block> getScrapHeap() {
        return SCRAP_HEAP;

    }

    public SickleItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super((float)pAttackDamageModifier, pAttackSpeedModifier, WOOD, SCRAP_HEAP, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Only tool able to break Scrap Blocks efficiently").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            components.add(Component.literal("Hold Shift For Tool Use").withStyle(ChatFormatting.DARK_PURPLE));
        }
        super.appendHoverText(stack, level, components, flag);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
        return net.minecraftforge.common.ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction);
    }
}
