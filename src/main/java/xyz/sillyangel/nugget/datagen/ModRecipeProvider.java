package xyz.sillyangel.nugget.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
    public ModRecipeProvider(HolderLookup.Provider lookup, RecipeOutput recipeOutput) {
        super(lookup, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
            super(output, providerCompletableFuture);
        }


        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        List<ItemLike> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET.get(),
                ModBlocks.NUGGET_ORE.get(), ModBlocks.NUGGET_DEEPSLATE_ORE.get());

        shaped(RecipeCategory.MISC, ModBlocks.NUGGET_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.NUGGET.get(), 9)
                .requires(ModBlocks.NUGGET_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NUGGET_BLOCK.get()), has(ModBlocks.NUGGET_BLOCK.get())).save(this.output);

        // RAW NUGGET

        shaped(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_NUGGET.get())
                .unlockedBy(getHasName(ModItems.RAW_NUGGET.get()), has(ModItems.RAW_NUGGET.get())).save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_NUGGET.get(), 9)
                .requires(ModBlocks.RAW_NUGGET_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_NUGGET_BLOCK.get()), has(ModBlocks.RAW_NUGGET_BLOCK.get())).save(this.output);
        // TOOLS

        //SWORD
        shaped(RecipeCategory.COMBAT, ModItems.NUGGET_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //PICAXE
        shaped(RecipeCategory.TOOLS, ModItems.NUGGET_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //AXE
        shaped(RecipeCategory.TOOLS, ModItems.NUGGET_AXE.get())
                .pattern(" AA")
                .pattern(" BA")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //SHOVEL
        shaped(RecipeCategory.TOOLS, ModItems.NUGGET_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //HOE
        shaped(RecipeCategory.TOOLS, ModItems.NUGGET_HOE.get())
                .pattern(" AA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.NUGGET.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);

        // END OF TOOLS

        // start of armor
        // head!?!
        shaped(RecipeCategory.COMBAT, ModItems.NUGGET_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //shirt
        shaped(RecipeCategory.COMBAT, ModItems.NUGGET_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //pants?
        shaped(RecipeCategory.COMBAT, ModItems.NUGGET_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);
        //socks
        shaped(RecipeCategory.COMBAT, ModItems.NUGGET_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.NUGGET.get())
                .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get())).save(this.output);

        trimSmithing(ModItems.NUGGET_SMITHING_TEMPLATE.get(), ResourceKey.create(Registries.RECIPE,
                ResourceLocation.parse(getItemName(ModItems.NUGGET_SMITHING_TEMPLATE.get()) + "_smithing_trim")));

        oreSmelting(this.output, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 200, "nugget");
        oreBlasting(this.output, NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 100, "nugget");


    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, NuggetMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}