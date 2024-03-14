package com.iisollated.CreateScrapandSalvage.block.entity.client;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.entity.WorkshopChestEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WorkshopChestModel extends GeoModel<WorkshopChestEntity> {
    @Override
    public ResourceLocation getModelResource(WorkshopChestEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "geo/workshop_chest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WorkshopChestEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/block/workshop_chest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WorkshopChestEntity animatable) {
        return new ResourceLocation(CreateScrapandSalvage.MOD_ID, "animations/workshop_chest.animations.json");
    }
}
