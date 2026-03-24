package dev.sillyangel.nuggetmod.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.trim.ModTrimPatterns;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.Identifier;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        return new RecipeProvider(wrapperLookup, recipeExporter) {
            @Override
            public void buildRecipes() {
                List<ItemLike> NUGGET_SMELTABLES = List.of(ModItems.RAW_NUGGET.get(), ModBlocks.NUGGET_ORE.get(),
                        ModBlocks.NUGGET_DEEPSLATE_ORE.get());

                oreSmelting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 200, "nugget");
                oreBlasting(NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.NUGGET.get(), 0.25f, 100, "nugget");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.NUGGET.get(), RecipeCategory.DECORATIONS, ModBlocks.NUGGET_BLOCK.get());

                // RAW_NUGGET_BLOCK
                shaped(RecipeCategory.MISC, ModBlocks.RAW_NUGGET_BLOCK.get())
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_NUGGET.get())
                        .unlockedBy(getHasName(ModItems.RAW_NUGGET.get()), has(ModItems.RAW_NUGGET.get()))
                        .save(recipeExporter);

                shapeless(RecipeCategory.MISC, ModItems.RAW_NUGGET.get(), 9)
                        .requires(ModBlocks.RAW_NUGGET_BLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.RAW_NUGGET_BLOCK.get()), has(ModBlocks.RAW_NUGGET_BLOCK.get()))
                        .save(recipeExporter);

                // cake is a lie
                shaped(RecipeCategory.FOOD, ModItems.NUGGET_CAKE.get())
                        .pattern("MMM")
                        .pattern("SES")
                        .pattern("WWW")
                        .define('M', Items.NUGGET_BLOCK)
                        .define('S', Items.SUGAR)
                        .define('E', Items.RAW_NUGGET)
                        .define('W', ModItems.NUGGET)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(output);

                // TOOLS
                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_SWORD.get())
                        .pattern(" N ")
                        .pattern(" N ")
                        .pattern(" S ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.TOOLS, ModItems.NUGGET_PICKAXE.get())
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.TOOLS, ModItems.NUGGET_AXE.get())
                        .pattern(" NN")
                        .pattern(" SN")
                        .pattern(" S ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.TOOLS, ModItems.NUGGET_SHOVEL.get())
                        .pattern(" N ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.TOOLS, ModItems.NUGGET_HOE.get())
                        .pattern(" NN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_SPEAR.get())
                        .pattern("  N")
                        .pattern(" S ")
                        .pattern("S  ")
                        .define('N', ModItems.NUGGET.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                // ARMOR
                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_HELMET.get())
                        .pattern("NNN")
                        .pattern("N N")
                        .define('N', ModItems.NUGGET.get())
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_CHESTPLATE.get())
                        .pattern("N N")
                        .pattern("NNN")
                        .pattern("NNN")
                        .define('N', ModItems.NUGGET.get())
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_LEGGINGS.get())
                        .pattern("NNN")
                        .pattern("N N")
                        .pattern("N N")
                        .define('N', ModItems.NUGGET.get())
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                shaped(RecipeCategory.COMBAT, ModItems.NUGGET_BOOTS.get())
                        .pattern("N N")
                        .pattern("N N")
                        .define('N', ModItems.NUGGET.get())
                        .unlockedBy(getHasName(ModItems.NUGGET.get()), has(ModItems.NUGGET.get()))
                        .save(recipeExporter);

                trimSmithing(ModItems.NUGGET_SMITHING_TEMPLATE.get(), ModTrimPatterns.NUGGET,
                        ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_smithing_template")));
            }
        };
    }

    @Override
    public String getName() {
        return "Nugget Mod Recipes";
    }
}