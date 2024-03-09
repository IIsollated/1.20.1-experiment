package com.iisollated.CreateScrapandSalvage.util;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SCRAP_HEAP = tag("scrap_heap");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CreateScrapandSalvage.MOD_ID, name));
        }
    }

    public static class Items {
            public static final TagKey<Item> SCRAP_BLOCK = null;

            private static TagKey<Item> tag(String name) {
                return ItemTags.create(new ResourceLocation(CreateScrapandSalvage.MOD_ID, name));
            }


    }
}