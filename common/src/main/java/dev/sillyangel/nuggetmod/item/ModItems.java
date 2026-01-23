package dev.sillyangel.nuggetmod.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(NuggetMod.MOD_ID, Registries.ITEM);

    // Basic Items
    public static final RegistrySupplier<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(createSettings("nugget").food(ModFoodComponents.NUGGET)));

    public static final RegistrySupplier<Item> RAW_NUGGET = ITEMS.register("raw_nugget",
            () -> new Item(createSettings("raw_nugget")));

    // Tools
    public static final RegistrySupplier<Item> NUGGET_SWORD = ITEMS.register("nugget_sword",
            () -> new Item(createSettings("nugget_sword").sword(ModToolMaterials.NUGGET, 3.0F, -2.4F)));

    public static final RegistrySupplier<Item> NUGGET_PICKAXE = ITEMS.register("nugget_pickaxe",
            () -> new Item(createSettings("nugget_pickaxe").pickaxe(ModToolMaterials.NUGGET, 1.0F, -2.8F)));

    public static final RegistrySupplier<Item> NUGGET_SHOVEL = ITEMS.register("nugget_shovel",
            () -> new ShovelItem(ModToolMaterials.NUGGET, 1.5F, -3.0F, createSettings("nugget_shovel")));

    public static final RegistrySupplier<Item> NUGGET_AXE = ITEMS.register("nugget_axe",
            () -> new AxeItem(ModToolMaterials.NUGGET, 6.0F, -3.2F, createSettings("nugget_axe")));

    public static final RegistrySupplier<Item> NUGGET_HOE = ITEMS.register("nugget_hoe",
            () -> new HoeItem(ModToolMaterials.NUGGET, -3.0F, 0.0F, createSettings("nugget_hoe")));

    public static final RegistrySupplier<Item> NUGGET_SPEAR = ITEMS.register("nugget_spear",
            () -> new Item(createSettings("nugget_spear").spear(ModToolMaterials.NUGGET, 1F, 1.08F, 0.2F, 3.5F, 5.5F, 6.5F, 5.1F, 10.0F, 4.6F)));

    // Armor
    public static final RegistrySupplier<Item> NUGGET_HELMET = ITEMS.register("nugget_helmet",
            () -> new Item(createSettings("nugget_helmet").humanoidArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final RegistrySupplier<Item> NUGGET_CHESTPLATE = ITEMS.register("nugget_chestplate",
            () -> new Item(createSettings("nugget_chestplate").humanoidArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));

    public static final RegistrySupplier<Item> NUGGET_LEGGINGS = ITEMS.register("nugget_leggings",
            () -> new Item(createSettings("nugget_leggings").humanoidArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.LEGGINGS)));

    public static final RegistrySupplier<Item> NUGGET_BOOTS = ITEMS.register("nugget_boots",
            () -> new Item(createSettings("nugget_boots").humanoidArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final RegistrySupplier<Item> NUGGET_HORSE_ARMOR = ITEMS.register("nugget_horse_armor",
            () -> new Item(createSettings("nugget_horse_armor").horseArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL)));

    // Special Items
    public static final RegistrySupplier<Item> NUGGET_SMITHING_TEMPLATE = ITEMS.register("nugget_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(createSettings("nugget_armor_trim_smithing_template").stacksTo(1)));

    public static final RegistrySupplier<Item> NUGGET_MUSIC_DISC = ITEMS.register("nugget_music_disc",
            () -> new Item(createSettings("nugget_music_disc").jukeboxPlayable(ModSounds.NUGGET_THEME_KEY)));

    private static Item.Properties createSettings(String name) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name)));
    }

    public static void init() {
        ITEMS.register();
        NuggetMod.LOGGER.info("Registering Mod Items for " + NuggetMod.MOD_ID);
    }
}

