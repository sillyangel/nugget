package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.fabric.block.ModBlocks;
import dev.sillyangel.nuggetmod.fabric.item.ModItems;
import dev.sillyangel.nuggetmod.fabric.trim.ModTrimPatterns;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET, ModBlocks.NUGGET_ORE,
                        ModBlocks.NUGGET_DEEPSLATE_ORE);

                offerSmelting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET, 0.25f, 200, "nugget");
                offerBlasting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET, 0.25f, 100, "nugget");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.NUGGET, RecipeCategory.DECORATIONS, ModBlocks.NUGGET_BLOCK);

                // RAW_NUGGET_BLOCK
                createShaped(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_NUGGET)
                        .criterion(hasItem(ModItems.RAW_NUGGET), conditionsFromItem(ModItems.RAW_NUGGET))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_NUGGET, 9)
                        .input(ModBlocks.RAW_NUGGET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_NUGGET_BLOCK), conditionsFromItem(ModBlocks.RAW_NUGGET_BLOCK))
                        .offerTo(exporter);

                // TOOLS
                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_SWORD)
                        .pattern(" N ")
                        .pattern(" N ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_PICKAXE)
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_AXE)
                        .pattern(" NN")
                        .pattern(" SN")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_SHOVEL)
                        .pattern(" N ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_HOE)
                        .pattern(" NN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_SPEAR)
                        .pattern("  N")
                        .pattern(" S ")
                        .pattern("S  ")
                        .input('N', ModItems.NUGGET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                // ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_HELMET)
                        .pattern("NNN")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_CHESTPLATE)
                        .pattern("N N")
                        .pattern("NNN")
                        .pattern("NNN")
                        .input('N', ModItems.NUGGET)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_LEGGINGS)
                        .pattern("NNN")
                        .pattern("N N")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_BOOTS)
                        .pattern("N N")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET)
                        .criterion(hasItem(ModItems.NUGGET), conditionsFromItem(ModItems.NUGGET))
                        .offerTo(exporter);

                offerSmithingTrimRecipe(ModItems.NUGGET_SMITHING_TEMPLATE, ModTrimPatterns.NUGGET,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(NuggetMod.MOD_ID, "nugget_smithing_template")));
            }
        };
    }

    @Override
    public String getName() {
        return "Nugget Mod Recipes";
    }
}