package xyz.sillyangel.nugget.item;

import xyz.sillyangel.nugget.NuggetMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.chat.Component;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
