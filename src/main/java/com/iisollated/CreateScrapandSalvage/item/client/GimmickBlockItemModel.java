package com.iisollated.CreateScrapandSalvage.item.client;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.item.custom.GimmickBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GimmickBlockItemModel extends GeoModel<GimmickBlockItem> {
    @Override
    public ResourceLocation getModelResource(GimmickBlockItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "geo/gimmick_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GimmickBlockItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/block/gimmick_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GimmickBlockItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "animations/gimmick_block.animations.json");
    }
}