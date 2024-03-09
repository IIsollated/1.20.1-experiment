package com.iisollated.CreateScrapandSalvage.item.client;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.item.custom.BrassBeetleGliderItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BrassBeetleGliderModel extends GeoModel<BrassBeetleGliderItem> {

    @Override
    public ResourceLocation getModelResource(BrassBeetleGliderItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "geo/brassbeetleglider.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrassBeetleGliderItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/armor/brassbeetleglider.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BrassBeetleGliderItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "animations/brassbeetleglider.animations.json");
    }
}