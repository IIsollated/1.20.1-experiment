package com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata;

import net.minecraft.nbt.CompoundTag;

public class BrassBeetleBooleans {

        private boolean glideState = false;

        public boolean getGlideState() {
            return glideState;
        }

        public void setGlideState(boolean glideState) {
            this.glideState = glideState;
        }

        public void copyFrom(BrassBeetleBooleans source) {
            this.glideState = source.glideState;
        }

        public void saveNBTData(CompoundTag nbt) {
            nbt.putBoolean("glideState", glideState);
        }

        public void loadNBTData(CompoundTag nbt) {
            glideState = nbt.getBoolean("glideState");
        }
    }
