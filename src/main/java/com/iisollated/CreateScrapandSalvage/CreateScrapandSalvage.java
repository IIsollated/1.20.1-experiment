package com.iisollated.CreateScrapandSalvage;

import com.iisollated.CreateScrapandSalvage.block.ModBlocks;
import com.iisollated.CreateScrapandSalvage.block.entity.ModBlockEntities;
import com.iisollated.CreateScrapandSalvage.block.entity.client.GimmickBlockRenderer;
import com.iisollated.CreateScrapandSalvage.block.entity.client.WorkshopChestRenderer;
import com.iisollated.CreateScrapandSalvage.item.ModCreativeModeTabs;
import com.iisollated.CreateScrapandSalvage.item.ModItems;
import com.iisollated.CreateScrapandSalvage.networking.ModMessages;
import com.iisollated.CreateScrapandSalvage.screen.GimmickBlockScreen;
import com.iisollated.CreateScrapandSalvage.screen.ModMenuTypes;
import com.iisollated.CreateScrapandSalvage.screen.WorkshopChestScreen;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateScrapandSalvage.MOD_ID)
public class CreateScrapandSalvage
{
    public static final String MOD_ID = "create_scrapandsalvage";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateScrapandSalvage()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {

        });
        ModMessages.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            BlockEntityRenderers.register(ModBlockEntities.GIMMICK_GLOCK_BE.get(), GimmickBlockRenderer::new);
            MenuScreens.register(ModMenuTypes.GIMMICK_BLOCK_MENU.get(), GimmickBlockScreen::new);
            BlockEntityRenderers.register(ModBlockEntities.WORKSHOP_CHEST_BE.get(), WorkshopChestRenderer::new);
            MenuScreens.register(ModMenuTypes.WORKSHOP_CHEST_MENU.get(), WorkshopChestScreen::new);
        }
    }
}
