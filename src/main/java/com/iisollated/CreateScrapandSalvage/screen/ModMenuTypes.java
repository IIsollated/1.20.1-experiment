package com.iisollated.CreateScrapandSalvage.screen;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, CreateScrapandSalvage.MOD_ID);


public static final RegistryObject<MenuType<GimmickBlockMenu>> GIMMICK_BLOCK_MENU =
        registerMenuType("gimmick_block_menu", GimmickBlockMenu::new);

    public static final RegistryObject<MenuType<WorkshopChestMenu>> WORKSHOP_CHEST_MENU =
            registerMenuType("workshop_chest_menu", WorkshopChestMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>>
    registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
