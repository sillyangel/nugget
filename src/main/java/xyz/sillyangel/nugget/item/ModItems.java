package xyz.sillyangel.nugget.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.ArmorType;
import xyz.sillyangel.nugget.NuggetMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.*;
import xyz.sillyangel.nugget.sound.ModSounds;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NuggetMod.MOD_ID);

    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget")))
                    .food(ModFoodProperties.Nugget)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponent, TooltipFlag pTooltipFlag) {
                    pTooltipComponent.add(Component.translatable("item.nuggetmod.nugget.tooltip"));
                    super.appendHoverText(pStack, pContext, pTooltipComponent, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> RAW_NUGGET = ITEMS.register("raw_nugget",
            () -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "raw_nugget")))));

    public static final RegistryObject<Item> NUGGET_SWORD = ITEMS.register("nugget_sword",
            () -> new SwordItem(ModToolTiers.NUGGET, 3, -2.4f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_sword")))));

    public static final RegistryObject<Item> NUGGET_PICKAXE = ITEMS.register("nugget_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NUGGET, 1, -2.8f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_pickaxe")))));

    public static final RegistryObject<Item> NUGGET_SHOVEL = ITEMS.register("nugget_shovel",
            () -> new ShovelItem(ModToolTiers.NUGGET, 1.5f, -3.0f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_shovel")))));

    public static final RegistryObject<Item> NUGGET_AXE = ITEMS.register("nugget_axe",
            () -> new AxeItem(ModToolTiers.NUGGET, 6, -3.2f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_axe")))));

    public static final RegistryObject<Item> NUGGET_HOE = ITEMS.register("nugget_hoe",
            () -> new HoeItem(ModToolTiers.NUGGET, 0, -3.0f, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_hoe")))));

    // armor things

    public static final RegistryObject<Item> NUGGET_HELMET = ITEMS.register("nugget_helmet",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.HELMET,
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_helmet")))));

    public static final RegistryObject<Item> NUGGET_CHESTPLATE = ITEMS.register("nugget_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.CHESTPLATE,
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_chestplate")))));

    public static final RegistryObject<Item> NUGGET_LEGGINGS = ITEMS.register("nugget_leggings",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.LEGGINGS,
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_leggings")))));

    public static final RegistryObject<Item> NUGGET_BOOTS = ITEMS.register("nugget_boots",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorType.BOOTS,
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_boots")))));

    // horse armor
    public static final RegistryObject<Item> NUGGET_HORSE_ARMOR = ITEMS.register("nugget_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_horse_armor")))
                    .stacksTo(1)));
    // smithing temp
    public static final RegistryObject<Item> NUGGET_SMITHING_TEMPLATE = ITEMS.register("nugget_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_armor_trim_smithing_template")))));

    public static final RegistryObject<Item> NUGGET_MUSIC_DISC = ITEMS.register("nugget_music_disc",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_music_disc")))
                    .jukeboxPlayable(ModSounds.NUGGET_THEME_KEY).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
