package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import dev.sillyangel.nuggetmod.fabric.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
//        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(ModItems.NUGGET)
//                .add(ModItems.RAW_NUGGET)
//                .add(Items.COAL)
//                .add(Items.STICK)
//                .add(Items.APPLE);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.NUGGET_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.NUGGET_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.NUGGET_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.NUGGET_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.NUGGET_HOE);
        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.NUGGET_SPEAR);
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NUGGET_HELMET)
                .add(ModItems.NUGGET_CHESTPLATE)
                .add(ModItems.NUGGET_LEGGINGS)
                .add(ModItems.NUGGET_BOOTS);
        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NUGGET);
    }
}