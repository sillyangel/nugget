package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.block.ModBlocks;
import xyz.sillyangel.nugget.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET.get(),
                ModBlocks.NUGGET_ORE.get(), ModBlocks.NUGGET_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NUGGET_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NUGGET.get(), 9)
                .requires(ModBlocks.NUGGET_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NUGGET_BLOCK.get()), has(ModBlocks.NUGGET_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 200, "nugget");
        oreBlasting(pRecipeOutput, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 100, "nugget");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NuggetMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}