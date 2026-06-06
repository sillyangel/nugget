package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.NUGGET_SWORD.get());
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.NUGGET_PICKAXE.get());
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.NUGGET_SHOVEL.get());
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.NUGGET_AXE.get());
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.NUGGET_HOE.get());
        valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.NUGGET_SPEAR.get());
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NUGGET_HELMET.get())
                .add(ModItems.NUGGET_CHESTPLATE.get())
                .add(ModItems.NUGGET_LEGGINGS.get())
                .add(ModItems.NUGGET_BOOTS.get());
        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NUGGET.get());
    }
}

