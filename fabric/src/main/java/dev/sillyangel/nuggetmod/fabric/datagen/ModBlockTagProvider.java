package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
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

