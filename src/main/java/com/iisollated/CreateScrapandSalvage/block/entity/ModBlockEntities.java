package com.iisollated.CreateScrapandSalvage.block.entity;

import com.iisollated.CreateScrapandSalvage.CreateScrapandSalvage;
import com.iisollated.CreateScrapandSalvage.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateScrapandSalvage.MOD_ID);

    public static final RegistryObject<BlockEntityType<GimmickBlockEntity>> GIMMICK_GLOCK_BE =
            BLOCK_ENTITIES.register("gimmick_block_be", () ->
                    BlockEntityType.Builder.of(GimmickBlockEntity::new,
                            ModBlocks.GIMMICK_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<WorkshopChestEntity>> WORKSHOP_CHEST_BE =
            BLOCK_ENTITIES.register("workshop_chest_be", () ->
                    BlockEntityType.Builder.of((pPos, pBlockState) -> new WorkshopChestEntity(pPos, pBlockState),
                            ModBlocks.WORKSHOP_CHEST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
