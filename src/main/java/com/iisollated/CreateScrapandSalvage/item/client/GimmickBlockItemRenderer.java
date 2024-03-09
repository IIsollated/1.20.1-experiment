package com.iisollated.CreateScrapandSalvage.item.client;

import com.iisollated.CreateScrapandSalvage.item.custom.GimmickBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GimmickBlockItemRenderer extends GeoItemRenderer<GimmickBlockItem> {
    public GimmickBlockItemRenderer() {
        super(new GimmickBlockItemModel());
    }
}