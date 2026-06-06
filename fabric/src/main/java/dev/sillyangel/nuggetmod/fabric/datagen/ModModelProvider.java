package dev.sillyangel.nuggetmod.fabric.datagen;

import dev.sillyangel.nuggetmod.item.ModArmorMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }
    // Blocks are generated here
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.NUGGET_BLOCK.get());
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_NUGGET_BLOCK.get());
        blockStateModelGenerator.createTrivialCube(ModBlocks.NUGGET_ORE.get());
        blockStateModelGenerator.createTrivialCube(ModBlocks.NUGGET_DEEPSLATE_ORE.get());

        blockStateModelGenerator.createFurnace(
                ModBlocks.NUGGET_FURNACE.get(), TexturedModel.ORIENTABLE
        );
//        blockStateModelGenerator.blockStateOutput.accept();
    }
    // Items are generated here
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.NUGGET_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NUGGET_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NUGGET_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NUGGET_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NUGGET_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateSpear(ModItems.NUGGET_SPEAR.get());

        itemModelGenerator.generateTrimmableItem(ModItems.NUGGET_HELMET.get(), ModArmorMaterials.NUGGET_EQUIPMENT_ASSET, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerator.generateTrimmableItem(ModItems.NUGGET_CHESTPLATE.get(), ModArmorMaterials.NUGGET_EQUIPMENT_ASSET, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerator.generateTrimmableItem(ModItems.NUGGET_LEGGINGS.get(), ModArmorMaterials.NUGGET_EQUIPMENT_ASSET, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerator.generateTrimmableItem(ModItems.NUGGET_BOOTS.get(), ModArmorMaterials.NUGGET_EQUIPMENT_ASSET, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModelGenerator.generateFlatItem(ModItems.NUGGET_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.NUGGET_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.NUGGET_MUSIC_DISC.get(), ModelTemplates.MUSIC_DISC);

    }
}

