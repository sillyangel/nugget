package dev.sillyangel.nuggetmod.block.entities;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;

import java.util.function.Supplier;

public class ModBlockEntityTypes {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(NuggetMod.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static RegistrySupplier<BlockEntityType<FurnaceBlockEntity>> NUGGET_FURNACE;

    public static void init(){
        BLOCK_ENTITIES.register();
    }

    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(String name, Supplier<T> blockEntity){
        return BLOCK_ENTITIES.register(Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name), blockEntity);
    }

}