package com.iisollated.CreateScrapandSalvage.item.client;

import com.iisollated.CreateScrapandSalvage.item.custom.WorkshopChestItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WorkshopChestItemRenderer extends GeoItemRenderer<WorkshopChestItem> {
    public WorkshopChestItemRenderer() {
        super(new WorkshopChestItemModel());
    }
}