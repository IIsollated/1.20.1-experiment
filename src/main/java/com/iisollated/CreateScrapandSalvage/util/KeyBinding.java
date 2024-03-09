package com.iisollated.CreateScrapandSalvage.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_SCRAPANDSALVAGE = "key.category.create_scrapandsalvage.scrapandsalvage";
    public static final String KEY_TOGGLE_GLIDING = "key.create_scrapandsalvage.toggle_gliding";

    public static final KeyMapping TOGGLE_GLIDING = new KeyMapping(KEY_TOGGLE_GLIDING, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KEY_CATEGORY_SCRAPANDSALVAGE);
}
