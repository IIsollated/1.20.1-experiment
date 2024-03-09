package com.iisollated.CreateScrapandSalvage.block.entity.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GimmickBlockRenderer extends GeoBlockRenderer<GimmickBlock> {

    public GimmickBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new GimmickBlockModel());
    }
}