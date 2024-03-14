package com.iisollated.CreateScrapandSalvage.block.entity.client;

import com.iisollated.CreateScrapandSalvage.block.entity.WorkshopChestEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WorkshopChestRenderer extends GeoBlockRenderer<WorkshopChestEntity> {
    public WorkshopChestRenderer(BlockEntityRendererProvider.Context context) {
        super(new WorkshopChestModel());
    }
}
