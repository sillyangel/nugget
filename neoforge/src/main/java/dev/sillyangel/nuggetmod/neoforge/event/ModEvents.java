package dev.sillyangel.nuggetmod.neoforge.event;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.neoforge.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = NuggetMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        // Add trades to vanilla FARMER profession
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 3),
                    new ItemStack(ModItems.NUGGET.get(), 8), 7, 2, 0.04f));
        }

        // Add trades to custom NUGGETER profession
        if(event.getType().equals(ModVillagers.NUGGETER_KEY)) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1 trades
            trades.get(1).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(ModItems.NUGGET.get(), 20), 4, 7, 0.04f));

            trades.get(1).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 2),
                    new ItemStack(ModItems.RAW_NUGGET.get(), 12), 6, 5, 0.05f));

            // Level 2 trades
            trades.get(2).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.GOLD_INGOT, 8),
                    new ItemStack(ModItems.NUGGET_SWORD.get(), 1), 3, 10, 0.05f));

            trades.get(2).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 10),
                    new ItemStack(ModItems.NUGGET_PICKAXE.get(), 1), 3, 10, 0.05f));

            // Level 3 trades
            trades.get(3).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 15),
                    new ItemStack(ModItems.NUGGET_HELMET.get(), 1), 2, 15, 0.05f));

            trades.get(3).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 20),
                    new ItemStack(ModItems.NUGGET_CHESTPLATE.get(), 1), 2, 15, 0.05f));

            // Level 4 trades
            trades.get(4).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 5),
                    new ItemStack(ModItems.NUGGET_LEGGINGS.get(), 1), 2, 20, 0.05f));

            trades.get(4).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(ModItems.NUGGET_BOOTS.get(), 1), 2, 20, 0.05f));

            // Level 5 trades (Master)
            trades.get(5).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 30),
                    new ItemStack(ModItems.NUGGET_HORSE_ARMOR.get(), 1), 1, 30, 0.1f));

            trades.get(5).add((level, entity, random) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 10),
                    new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 1, 30, 0.1f));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        // Add generic wandering trader trades
        genericTrades.add((level, entity, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 12),
                new ItemStack(ModItems.NUGGET.get(), 3), 2, 8, 0.2f));

        // Add rare wandering trader trades
        rareTrades.add((level, entity, random) -> new MerchantOffer(
                new ItemCost(Items.DIAMOND, 8),
                new ItemStack(ModItems.NUGGET_MUSIC_DISC.get(), 1), 1, 12, 0.2f));

        rareTrades.add((level, entity, random) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 25),
                new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 1, 12, 0.2f));
    }
}

