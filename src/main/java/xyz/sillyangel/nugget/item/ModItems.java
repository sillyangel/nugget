package xyz.sillyangel.nugget.item;

import xyz.sillyangel.nugget.NuggetMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.RegistryObject;

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



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
