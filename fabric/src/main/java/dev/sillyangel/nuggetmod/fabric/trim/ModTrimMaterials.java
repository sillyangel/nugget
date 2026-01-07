package dev.sillyangel.nuggetmod.fabric.trim;

import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.fabric.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimAssets;
import net.minecraft.item.equipment.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;


public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> NUGGET = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(NuggetMod.MOD_ID, "nugget"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, NUGGET, Registries.ITEM.getEntry(ModItems.NUGGET),
                Style.EMPTY.withColor(TextColor.parse("#f9b042").getOrThrow()));

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ArmorTrimAssets.of("nugget"),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}