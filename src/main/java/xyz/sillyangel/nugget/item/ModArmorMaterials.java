package xyz.sillyangel.nugget.item;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.util.ModTags;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import java.util.EnumMap;

public class ModArmorMaterials {
    public static final ArmorMaterial NUGGET_ARMOR_MATERIAL = new ArmorMaterial(1200, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 5);
                attribute.put(ArmorType.LEGGINGS, 7);
                attribute.put(ArmorType.CHESTPLATE, 9);
                attribute.put(ArmorType.HELMET, 5);
                attribute.put(ArmorType.BODY, 11);
            }), 20, SoundEvents.ARMOR_EQUIP_NETHERITE,
            4f, 0.1f, ModTags.Items.NUGGET_REPAIRS, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget"));
}