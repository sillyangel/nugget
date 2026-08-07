package dev.sillyangel.nuggetmod.neoforge.blocks.entities;

import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.block.entities.ModBlockEntityTypes;
import dev.sillyangel.nuggetmod.block.entities.NuggetFurnaceEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypesNeoForge extends ModBlockEntityTypes {

    public static void initBlockEntityTypes(){
        NUGGET_FURNACE = registerBlockEntity("nugget_furnace", () -> new BlockEntityType<>(NuggetFurnaceEntity::new, ModBlocks.NUGGET_FURNACE.get()));

        register();
    }

}