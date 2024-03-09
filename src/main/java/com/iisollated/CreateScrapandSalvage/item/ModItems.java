package com.iisollated.CreateScrapandSalvage.item;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.ModBlocks;
import com.iisollated.CreateScrapandSalvage.item.custom.BrassBeetleGliderItem;
import com.iisollated.CreateScrapandSalvage.item.custom.GimmickBlockItem;
import com.iisollated.CreateScrapandSalvage.item.custom.SickleItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateScrapandSalvage.MOD_ID);

        public static final RegistryObject<Item> SCRAP_SICKLE = ITEMS.register("scrap_sickle",
                () -> new SickleItem(Tiers.WOOD, 2, 2, new Item.Properties()));

    public static final RegistryObject<Item> BRASS_GLIDER = ITEMS.register("brassbeetleglider",
            () -> new BrassBeetleGliderItem(ModArmorMaterials.CARBONSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    
    public static final RegistryObject<Item> GIMMICK_BLOCK_ITEM = ITEMS.register("gimmick_block",
            () -> new GimmickBlockItem(ModBlocks.GIMMICK_BLOCK.get(), new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
