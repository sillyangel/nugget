package xyz.sillyangel.nugget.datagen;

import net.minecraft.world.item.Items;
import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.block.ModBlocks;
import xyz.sillyangel.nugget.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
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

        // RAW NUGGET

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_NUGGET.get())
                .unlockedBy(getHasName(ModItems.RAW_NUGGET.get()), has(ModItems.RAW_NUGGET.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_NUGGET.get(), 9)
                .requires(ModBlocks.RAW_NUGGET_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_NUGGET_BLOCK.get()), has(ModBlocks.RAW_NUGGET_BLOCK.get())).save(pRecipeOutput);
        // TOOLS

        //SWORD
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NUGGET_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //PICAXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NUGGET_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //AXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NUGGET_AXE.get())
                .pattern(" AA")
                .pattern(" BA")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //SHOVEL
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NUGGET_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //HOE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NUGGET_HOE.get())
                .pattern(" AA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);

        // END OF TOOLS

        // start of armor
        // head!?!
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NUGGET_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //shirt
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NUGGET_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //pants?
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NUGGET_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);
        //socks
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NUGGET_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(pRecipeOutput);

        trimSmithing(pRecipeOutput, ModItems.NUGGET_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_trim_mat"));

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