package dev.sillyangel.nuggetmod.fabric.datagen;

import dev.sillyangel.nuggetmod.item.ModArmorMaterials;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.client.data.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    // Blocks are generated here
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_BLOCK.get());
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_NUGGET_BLOCK.get());
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_ORE.get());
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NUGGET_DEEPSLATE_ORE.get());
    }
    // Items are generated here
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NUGGET.get(), Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_NUGGET.get(), Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SWORD.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_PICKAXE.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_SHOVEL.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_AXE.get(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.NUGGET_HOE.get(), Models.HANDHELD);

        itemModelGenerator.register(ModItems.NUGGET_SPEAR.get(), Models.SPEAR_IN_HAND);

        itemModelGenerator.registerArmor(ModItems.NUGGET_HELMET.get(), ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_CHESTPLATE.get(), ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_LEGGINGS.get(), ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.NUGGET_BOOTS.get(), ModArmorMaterials.NUGGET_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.NUGGET_HORSE_ARMOR.get(), Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_SMITHING_TEMPLATE.get(), Models.GENERATED);

        itemModelGenerator.register(ModItems.NUGGET_MUSIC_DISC.get(), Models.GENERATED);

    }
}

