package com.iisollated.CreateScrapandSalvage.block.entity.client;

import com.iisollated.CreateScrapandSalvage.block.entity.GimmickBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class GimmickBlockRenderer extends GeoBlockRenderer<GimmickBlockEntity> {
    public GimmickBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new GimmickBlockModel());
    }
}
