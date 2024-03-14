package com.iisollated.CreateScrapandSalvage.block.entity;

import com.iisollated.CreateScrapandSalvage.screen.GimmickBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;

public class GimmickBlockEntity extends BlockEntity implements MenuProvider, GeoBlockEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private InteractionResult interactionResult;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 70;

    public GimmickBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GIMMICK_GLOCK_BE.get(), pPos, pBlockState);
        this.interactionResult = interactionResult;
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GimmickBlockEntity.this.progress;
                    case 1 -> GimmickBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GimmickBlockEntity.this.progress = pValue;
                    case 1 -> GimmickBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }

    private final ItemStackHandler itemHandler = new ItemStackHandler(27);

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.minecraft.chest");
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

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new GimmickBlockMenu(pContainerId, pPlayerInventory, this, this.data);
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

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {

    }

    public InteractionResult getInteractionResult() {
        return interactionResult;
    }

    public void setInteractionResult(InteractionResult interactionResult) {
        this.interactionResult = interactionResult;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        InteractionResult interactionResult = ((GimmickBlockEntity) this).getInteractionResult(); // Get interaction result

        if (interactionResult == InteractionResult.SUCCESS) {
            tAnimationState.getController().setAnimationSpeed(0.6);
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("gimmick.open", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            tAnimationState.getController().setAnimationSpeed(0.6);
            tAnimationState.getController().setAnimation(RawAnimation.begin()
                    .then("gimmick.closed", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object blockEntity) {
        return RenderUtils.getCurrentTick();
    }
}
