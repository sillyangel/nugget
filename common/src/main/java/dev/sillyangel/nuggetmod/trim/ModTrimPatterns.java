package dev.sillyangel.nuggetmod.trim;

import net.minecraft.world.item.equipment.trim.TrimPattern;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.util.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class ModTrimPatterns {
    private static final Identifier NUGGET_LOCATION = Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget");

    public static final ResourceKey<TrimPattern> NUGGET = ResourceKey.create(Registries.TRIM_PATTERN, NUGGET_LOCATION);

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.NUGGET_SMITHING_TEMPLATE.get(), NUGGET, NUGGET_LOCATION);
    }

    private static void register(BootstrapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key, Identifier assetId) {
        TrimPattern trimPattern = new TrimPattern(assetId,
                Component.translatable(Util.makeDescriptionId("trim_pattern", assetId)), false);
        context.register(key, trimPattern);
    }
}