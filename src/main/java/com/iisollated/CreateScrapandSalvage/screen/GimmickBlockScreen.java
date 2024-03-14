package com.iisollated.CreateScrapandSalvage.screen;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GimmickBlockScreen extends AbstractContainerScreen<GimmickBlockMenu> {
    public GimmickBlockScreen(GimmickBlockMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(CreateScrapandSalvage.MOD_ID, "textures/gui/gimmick_block_gui.png");

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        renderBiteProgress(pGuiGraphics, x, y);
    }

    private void renderBiteProgress(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isOpen()) {
            guiGraphics.blit(TEXTURE, x+ 85, y+ 30, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float delta) {
        renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, delta);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }


}
