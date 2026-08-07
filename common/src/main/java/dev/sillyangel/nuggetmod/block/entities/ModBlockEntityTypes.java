package dev.sillyangel.nuggetmod.block.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(NuggetMod.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<NuggetFurnaceEntity>> NUGGET_FURNACE;

    public static void register() {
        BLOCK_ENTITIES.register();
    }

    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(
            String name,
            Supplier<T> blockEntity
    ) {
        return BLOCK_ENTITIES.register(
                Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name),
                blockEntity
        );
    }
}