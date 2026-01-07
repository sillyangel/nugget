package dev.sillyangel.nuggetmod.fabric.datagen;

import dev.sillyangel.nuggetmod.fabric.item.ModArmorMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import dev.sillyangel.nuggetmod.fabric.block.ModBlocks;
import dev.sillyangel.nuggetmod.fabric.item.ModItems;
import net.minecraft.client.data.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    // Blocks are generated here
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NUGGET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_DEEPSLATE_ORE);
    }
    // Items are generated here
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.NUGGET_SPEAR, Models.SPEAR_IN_HAND);

        itemModelGenerator.registerArmor(ModItems.NUGGET_HELMET, ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_CHESTPLATE, ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_LEGGINGS, ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_BOOTS, ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.NUGGET_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_MUSIC_DISC, Models.GENERATED);

    }
}