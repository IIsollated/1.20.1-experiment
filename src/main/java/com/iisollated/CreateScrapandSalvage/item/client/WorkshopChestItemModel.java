package com.iisollated.CreateScrapandSalvage.item.client;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.item.custom.WorkshopChestItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WorkshopChestItemModel extends GeoModel<WorkshopChestItem> {
    @Override
    public ResourceLocation getModelResource(WorkshopChestItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "geo/workshop_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WorkshopChestItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/block/workshop_chest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WorkshopChestItem animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "animations/workshop_chest.animations.json");
    }
}