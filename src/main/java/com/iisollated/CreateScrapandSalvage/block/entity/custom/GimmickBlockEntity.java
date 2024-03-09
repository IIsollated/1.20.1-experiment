package com.iisollated.CreateScrapandSalvage.block.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class GimmickBlockEntity extends BlockEntity implements MenuProvider {

   private final ItemStackHandler itemHandler = new ItemStackHandler(0);

   private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

   public GimmickBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
      super(pType, pPos, pBlockState);

   }

   @Override
   public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
      if(cap == ForgeCapabilities.ITEM_HANDLER) {
         return lazyItemHandler.cast();
      }
      return super.getCapability(cap, side);
   }

   @Override
   public void onLoad() {
      super.onLoad();
      lazyItemHandler = LazyOptional.of(() -> itemHandler);
   }

   @Override
   public void invalidateCaps() {
      super.invalidateCaps();
      lazyItemHandler.invalidate();
   }
   /*
   public void drops() {
      SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
      for(int i = 0; i < itemHandler.getSlots(); i++) {
         inventory.setItem(i, itemHandler.getStackInSlot(i));
      }
      Containers.dropContents(this.level, this.worldPosition, inventory);
   }
   */

   @Nullable
   @Override
   public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
      return null;
   }

   @Override
   public Component getDisplayName() {
      return null;
   }


   @Override
   protected void saveAdditional(CompoundTag pTag) {
      pTag.put("inventory", itemHandler.serializeNBT());
      super.saveAdditional(pTag);
   }

   @Override
   public void load(CompoundTag pTag) {
      super.load(pTag);
      itemHandler.deserializeNBT(pTag.getCompound("inventory"));
   }
}
