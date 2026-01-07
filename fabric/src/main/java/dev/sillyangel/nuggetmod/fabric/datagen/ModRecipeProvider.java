package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.trim.ModTrimPatterns;
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
                List<ItemConvertible> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET.get(), ModBlocks.NUGGET_ORE.get(),
                        ModBlocks.NUGGET_DEEPSLATE_ORE.get());

                offerSmelting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 200, "nugget");
                offerBlasting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 100, "nugget");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.NUGGET.get(), RecipeCategory.DECORATIONS, ModBlocks.NUGGET_BLOCK.get());

                // RAW_NUGGET_BLOCK
                createShaped(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK.get())
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_NUGGET.get())
                        .criterion(hasItem(ModItems.RAW_NUGGET.get()), conditionsFromItem(ModItems.RAW_NUGGET.get()))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_NUGGET.get(), 9)
                        .input(ModBlocks.RAW_NUGGET_BLOCK.get())
                        .criterion(hasItem(ModBlocks.RAW_NUGGET_BLOCK.get()), conditionsFromItem(ModBlocks.RAW_NUGGET_BLOCK.get()))
                        .offerTo(exporter);

                // TOOLS
                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_SWORD.get())
                        .pattern(" N ")
                        .pattern(" N ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_PICKAXE.get())
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_AXE.get())
                        .pattern(" NN")
                        .pattern(" SN")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_SHOVEL.get())
                        .pattern(" N ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NUGGET_HOE.get())
                        .pattern(" NN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_SPEAR.get())
                        .pattern("  N")
                        .pattern(" S ")
                        .pattern("S  ")
                        .input('N', ModItems.NUGGET.get())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                // ARMOR
                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_HELMET.get())
                        .pattern("NNN")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET.get())
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_CHESTPLATE.get())
                        .pattern("N N")
                        .pattern("NNN")
                        .pattern("NNN")
                        .input('N', ModItems.NUGGET.get())
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_LEGGINGS.get())
                        .pattern("NNN")
                        .pattern("N N")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET.get())
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.NUGGET_BOOTS.get())
                        .pattern("N N")
                        .pattern("N N")
                        .input('N', ModItems.NUGGET.get())
                        .criterion(hasItem(ModItems.NUGGET.get()), conditionsFromItem(ModItems.NUGGET.get()))
                        .offerTo(exporter);

                offerSmithingTrimRecipe(ModItems.NUGGET_SMITHING_TEMPLATE.get(), ModTrimPatterns.NUGGET,
                        RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(NuggetMod.MOD_ID, "nugget_smithing_template")));
            }
        };
    }

    @Override
    public String getName() {
        return "Nugget Mod Recipes";
    }
}