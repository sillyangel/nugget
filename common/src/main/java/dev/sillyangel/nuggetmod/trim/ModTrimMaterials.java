package dev.sillyangel.nuggetmod.trim;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.item.ModArmorMaterials;
import net.minecraft.util.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {

    public static final ResourceKey<TrimMaterial> NUGGET =
            ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, NUGGET, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget"), Style.EMPTY.withColor(TextColor.parseColor("#f9b042").getOrThrow()));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey,
                                 Identifier assetId, Style style) {
        MaterialAssetGroup.AssetInfo assetInfo = new MaterialAssetGroup.AssetInfo(assetId.getPath());
        TrimMaterial trimmaterial = new TrimMaterial(
                new MaterialAssetGroup(assetInfo, Map.of(ModArmorMaterials.NUGGET_EQUIPMENT_ASSET, assetInfo)),
                Component.translatable(Util.makeDescriptionId("trim_material", assetId)).withStyle(style));
        context.register(trimKey, trimmaterial);
    }
}