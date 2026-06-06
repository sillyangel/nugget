package dev.sillyangel.nuggetmod.fabric.blocks.entities;

import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.block.entities.NuggetFurnaceEntity;
import dev.sillyangel.nuggetmod.block.entities.ModBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class ModBlockEntityTypesFabric extends ModBlockEntityTypes {

    public static void initBlockEntityTypes(){
        NUGGET_FURNACE = registerBlockEntity("ruby_furnace", () -> FabricBlockEntityTypeBuilder.create(NuggetFurnaceEntity::new, ModBlocks.NUGGET_FURNACE.get()).build());

        init();
    }

}