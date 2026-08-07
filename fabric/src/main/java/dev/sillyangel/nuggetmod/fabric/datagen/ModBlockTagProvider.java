package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.NUGGET_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_FURNACE.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_NUGGET_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_DEEPSLATE_ORE.get()));

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.NUGGET_DEEPSLATE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_FURNACE.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_NUGGET_BLOCK.get()));

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.NUGGET_FURNACE.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_BLOCK.get()));

        tag(ModTags.Blocks.NEEDS_NUGGET_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.NUGGET_FURNACE.get()))
                .add(ModBlocks.getRK(ModBlocks.NUGGET_BLOCK.get()));
    }
}

