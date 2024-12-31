package xyz.sillyangel.nugget.item;

import xyz.sillyangel.nugget.NuggetMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.*;
import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NuggetMod.MOD_ID);

    public static final RegistryObject<Item> NUGGET = ITEMS.register("nugget",
            () -> new Item(new Item.Properties().food(ModFoodProperties.Nugget)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponent, TooltipFlag pTooltipFlag) {
                    pTooltipComponent.add(Component.translatable("item.nuggetmod.nugget.tooltip"));
                    super.appendHoverText(pStack, pContext, pTooltipComponent, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> RAW_NUGGET = ITEMS.register("raw_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NUGGET_SWORD = ITEMS.register("nugget_sword",
            () -> new SwordItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NUGGET, 3, -2.4f))));
    public static final RegistryObject<Item> NUGGET_PICKAXE = ITEMS.register("nugget_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NUGGET, 1, -2.8f))));
    public static final RegistryObject<Item> NUGGET_SHOVEL = ITEMS.register("nugget_shovel",
            () -> new ShovelItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NUGGET, 1.5f, -3.0f))));
    public static final RegistryObject<Item> NUGGET_AXE = ITEMS.register("nugget_axe",
            () -> new AxeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.NUGGET, 6, -3.2f))));
    public static final RegistryObject<Item> NUGGET_HOE = ITEMS.register("nugget_hoe",
            () -> new HoeItem(ModToolTiers.NUGGET, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.NUGGET, 0, -3.0f))));

    // armor things

    public static final RegistryObject<Item> NUGGET_HELMET = ITEMS.register("nugget_helmet",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(25))));
    public static final RegistryObject<Item> NUGGET_CHESTPLATE = ITEMS.register("nugget_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));
    public static final RegistryObject<Item> NUGGET_LEGGINGS = ITEMS.register("nugget_leggings",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(25))));
    public static final RegistryObject<Item> NUGGET_BOOTS = ITEMS.register("nugget_boots",
            () -> new ArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))));
    // horse armor
    public static final RegistryObject<Item> NUGGET_HORSE_ARMOR = ITEMS.register("nugget_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.NUGGET_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
            false, new Item.Properties().stacksTo(1)));
    // smithing temp
    public static final RegistryObject<Item> NUGGET_SMITHING_TEMPLATE = ITEMS.register("nugget_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_trim_mat")));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
