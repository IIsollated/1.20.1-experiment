package com.iisollated.CreateScrapandSalvage.item;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateScrapandSalvage.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCRAPANDSALVAGE_TAB =
            CREATIVE_MODE_TABS.register("scrap_and_salvage_tab", () -> CreativeModeTab.builder().icon(()
                            -> new ItemStack(ModBlocks.GIMMICK_BLOCK.get()))
                    .title(Component.translatable("creativetab.create_scrapandsalvage.scrap_and_salvage_tab"))
                    .displayItems((pParameters, pOutput) -> {

                      pOutput.accept(ModItems.BRASS_GLIDER.get());
                      pOutput.accept(ModItems.GIMMICK_BLOCK_ITEM.get());
                      pOutput.accept(ModItems.WORKSHOP_CHEST_ITEM.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
