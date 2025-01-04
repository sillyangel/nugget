package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.trim.ModTrimMaterials;
import xyz.sillyangel.nugget.trim.ModTrimPatterns;
import xyz.sillyangel.nugget.worldgen.ModBiomeModifiers;
import xyz.sillyangel.nugget.worldgen.ModConfiguredFeatures;
import xyz.sillyangel.nugget.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(NuggetMod.MOD_ID));
    }
}