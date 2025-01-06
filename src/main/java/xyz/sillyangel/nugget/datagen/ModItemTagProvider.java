package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.item.ModItems;
import xyz.sillyangel.nugget.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, NuggetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.NUGGET.get())
                .add(ModItems.RAW_NUGGET.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NUGGET_HELMET.get())
                .add(ModItems.NUGGET_CHESTPLATE.get())
                .add(ModItems.NUGGET_LEGGINGS.get())
                .add(ModItems.NUGGET_BOOTS.get());
        tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.NUGGET.get());
        tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.NUGGET_SMITHING_TEMPLATE.get());
        tag(ModTags.Items.NUGGET_REPAIRS)
                .add(ModItems.NUGGET.get());
    }
}