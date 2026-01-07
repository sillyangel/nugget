package dev.sillyangel.nuggetmod.fabric.item;

import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import dev.sillyangel.nuggetmod.fabric.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> NUGGET_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(NuggetMod.MOD_ID, "nugget"));

    public static final ArmorMaterial NUGGET_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 3);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 19);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, ModTags.Items.REPAIRS_NUGGET_ARMOR, NUGGET_KEY);
}