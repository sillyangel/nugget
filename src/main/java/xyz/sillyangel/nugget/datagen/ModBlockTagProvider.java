package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import xyz.sillyangel.nugget.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NuggetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NUGGET_BLOCK.get())
                .add(ModBlocks.RAW_NUGGET_BLOCK.get())
                .add(ModBlocks.NUGGET_ORE.get())
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NUGGET_DEEPSLATE_ORE.get())
                .add(ModBlocks.NUGGET_BLOCK.get())
                .add(ModBlocks.RAW_NUGGET_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_NUGGET_TOOL)
                .add(ModBlocks.RAW_NUGGET_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_NUGGET_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_NUGGET_TOOL);
    }
}