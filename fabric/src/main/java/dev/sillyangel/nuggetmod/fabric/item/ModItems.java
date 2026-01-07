package dev.sillyangel.nuggetmod.fabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.fabric.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item NUGGET = registerItem("nugget", setting -> new Item(setting
            .food(ModFoodComponents.NUGGET)));

    public static final Item RAW_NUGGET = registerItem("raw_nugget", Item::new);

    // Tools
    public static final Item NUGGET_SWORD = registerItem("nugget_sword",
            setting -> new Item(setting.sword(ModToolMaterials.NUGGET, 3.0F, -2.4F)));

    public static final Item NUGGET_PICKAXE = registerItem("nugget_pickaxe",
            setting -> new Item(setting.pickaxe(ModToolMaterials.NUGGET, 1.0F, -2.8F)));

    public static final Item NUGGET_SHOVEL = registerItem("nugget_shovel",
            settings -> new ShovelItem(ModToolMaterials.NUGGET, 1.5F, -3.0F, settings));

    public static final Item NUGGET_AXE = registerItem("nugget_axe",
            settings -> new AxeItem(ModToolMaterials.NUGGET, 6.0F, -3.2F, settings));

    public static final Item NUGGET_HOE = registerItem("nugget_hoe",
            settings -> new HoeItem(ModToolMaterials.NUGGET, -3.0F, 0.0F, settings));

    public static final Item NUGGET_SPEAR = registerItem("nugget_spear",
            settings -> new Item(settings.spear(ModToolMaterials.NUGGET, 1F, 1.08F, 0.2F, 3.5F, 5.5F, 6.5F, 5.1F, 10.0F, 4.6F)));

    // unreleased items
    // bow, crossbow, trident,  shield , shears, flint and steel, fishing rod

    // Armor
    public static final Item NUGGET_HELMET = registerItem("nugget_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, EquipmentType.HELMET)));

    public static final Item NUGGET_CHESTPLATE = registerItem("nugget_chestplate",
            setting -> new Item(setting.armor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));

    public static final Item NUGGET_LEGGINGS = registerItem("nugget_leggings",
            setting -> new Item(setting.armor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));

    public static final Item NUGGET_BOOTS = registerItem("nugget_boots",
            setting -> new Item(setting.armor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static final Item NUGGET_HORSE_ARMOR = registerItem("nugget_horse_armor",
            setting -> new Item(setting.horseArmor(ModArmorMaterials.NUGGET_ARMOR_MATERIAL)));

    public static final Item NUGGET_SMITHING_TEMPLATE = registerItem("nugget_armor_trim_smithing_template",
            SmithingTemplateItem::of);

    public static final Item NUGGET_MUSIC_DISC = registerItem("nugget_music_disc",
            setting -> new Item(setting.jukeboxPlayable(ModSounds.NUGGET_THEME_KEY).maxCount(1)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(NuggetMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NuggetMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        NuggetMod.LOGGER.info("Registering Mod Items for " + NuggetMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(NUGGET);
            entries.add(RAW_NUGGET);
        });
    }

}