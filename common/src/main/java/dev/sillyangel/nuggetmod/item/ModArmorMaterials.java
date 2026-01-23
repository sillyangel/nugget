package dev.sillyangel.nuggetmod.item;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.util.ModTags;
import net.minecraft.util.Util;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ResourceKey<EquipmentAsset> NUGGET_EQUIPMENT_ASSET =
            ResourceKey.create(ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset")),
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget"));

    public static final ArmorMaterial NUGGET_ARMOR_MATERIAL = new ArmorMaterial(1200, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 5);
                attribute.put(ArmorType.LEGGINGS, 7);
                attribute.put(ArmorType.CHESTPLATE, 9);
                attribute.put(ArmorType.HELMET, 5);
                attribute.put(ArmorType.BODY, 11);
            }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE,
            4f, 0.1f, ModTags.Items.REPAIRS_NUGGET_ARMOR, NUGGET_EQUIPMENT_ASSET);
}

