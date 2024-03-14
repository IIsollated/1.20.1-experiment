package com.iisollated.CreateScrapandSalvage.block.entity.client;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.entity.GimmickBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GimmickBlockModel extends GeoModel<GimmickBlockEntity> {
    @Override
    public ResourceLocation getModelResource(GimmickBlockEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "geo/gimmick_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GimmickBlockEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/block/gimmick_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GimmickBlockEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "animations/gimmick_block.animations.json");
    }
}
