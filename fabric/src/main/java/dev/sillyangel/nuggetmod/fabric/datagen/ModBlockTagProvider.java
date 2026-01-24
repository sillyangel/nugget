package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NUGGET_BLOCK.get())
                .add(ModBlocks.RAW_NUGGET_BLOCK.get())
                .add(ModBlocks.NUGGET_ORE.get())
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE.get());

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE.get())
                .add(ModBlocks.NUGGET_BLOCK.get())
                .add(ModBlocks.RAW_NUGGET_BLOCK.get());

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NUGGET_BLOCK.get());

        valueLookupBuilder(ModTags.Blocks.NEEDS_NUGGET_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NUGGET_BLOCK.get());
    }
}

