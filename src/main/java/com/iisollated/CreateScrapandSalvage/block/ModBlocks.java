package com.iisollated.CreateScrapandSalvage.block;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.custom.GimmickBlock;
import com.iisollated.CreateScrapandSalvage.block.custom.WorkshopChest;
import com.iisollated.CreateScrapandSalvage.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CreateScrapandSalvage.MOD_ID);

    public static final RegistryObject<Block> SCRAP_HEAP = registerBlock("scrap_heap",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.CHAIN).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GIMMICK_BLOCK = BLOCKS.register("gimmick_block",
            () -> new GimmickBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> WORKSHOP_CHEST = BLOCKS.register("workshop_chest",
            () -> new WorkshopChest(BlockBehaviour.Properties.of().sound(SoundType.WOOD).noOcclusion()));

    private static <T extends  Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
