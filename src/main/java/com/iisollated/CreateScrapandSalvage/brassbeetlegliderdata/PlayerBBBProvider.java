package com.iisollated.CreateScrapandSalvage.brassbeetlegliderdata;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerBBBProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
   public static Capability<BrassBeetleBooleans> GLIDE_STATE_TOGGLE =
           CapabilityManager.get(new CapabilityToken<BrassBeetleBooleans>() {});

   private BrassBeetleBooleans glideState = null;
   private final LazyOptional<BrassBeetleBooleans> optional = LazyOptional.of(this::createBrassBeetleBooleans);

   private BrassBeetleBooleans createBrassBeetleBooleans() {
       if (this.glideState == null) {
           this.glideState = new BrassBeetleBooleans();
       }
       return this.glideState;
   }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

       if(cap == GLIDE_STATE_TOGGLE) {
           return optional.cast();
       }

       return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createBrassBeetleBooleans().saveNBTData(nbt);
       return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createBrassBeetleBooleans().loadNBTData(nbt);
    }
}
