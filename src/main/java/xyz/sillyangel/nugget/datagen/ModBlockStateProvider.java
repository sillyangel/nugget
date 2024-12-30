package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NuggetMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NUGGET_BLOCK);
        blockWithItem(ModBlocks.RAW_NUGGET_BLOCK);

        blockWithItem(ModBlocks.NUGGET_ORE);
        blockWithItem(ModBlocks.NUGGET_DEEPSLATE_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}