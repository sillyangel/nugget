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
        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(ModItems.NUGGET_SWORD.get()));
        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(ModItems.NUGGET_PICKAXE.get()));
        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(ModItems.NUGGET_SHOVEL.get()));
        tag(ItemTags.AXES)
                .add(ModItems.getRK(ModItems.NUGGET_AXE.get()));
        tag(ItemTags.HOES)
                .add(ModItems.getRK(ModItems.NUGGET_HOE.get()));
        tag(ItemTags.SPEARS)
                .add(ModItems.getRK(ModItems.NUGGET_SPEAR.get()));
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.getRK(ModItems.NUGGET_HELMET.get()))
                .add(ModItems.getRK(ModItems.NUGGET_CHESTPLATE.get()))
                .add(ModItems.getRK(ModItems.NUGGET_LEGGINGS.get()))
                .add(ModItems.getRK(ModItems.NUGGET_BOOTS.get()));
        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.getRK(ModItems.NUGGET.get()));
    }
}

