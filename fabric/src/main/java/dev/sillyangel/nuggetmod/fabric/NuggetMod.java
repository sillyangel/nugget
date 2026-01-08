package dev.sillyangel.nuggetmod.fabric;

import dev.sillyangel.nuggetmod.fabric.item.ModItemGroups;
import dev.sillyangel.nuggetmod.fabric.particle.ModParticles;
import dev.sillyangel.nuggetmod.fabric.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.fabric.world.ModWorldGeneration;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuggetMod implements ModInitializer {
	public static final String MOD_ID = "nuggetmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Nugget (Fabric)");

		// Initialize common mod
		dev.sillyangel.nuggetmod.NuggetMod.init();

		// Fabric-specific registrations
		ModItemGroups.registerItemGroups();
		ModWorldGeneration.generateModWorldGen();

		// IMPORTANT: Register villagers before trades
		ModVillagers.registerVillagers();

		ModParticles.registerParticles();

		// Register tooltip for nugget item using Fabric API
		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
			if (itemStack.isOf(ModItems.NUGGET.get())) {
				list.add(Text.translatable("item.nuggetmod.nugget.tooltip"));
			}
		});

		// Add items to vanilla creative tabs
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(ModItems.NUGGET.get());
			entries.add(ModItems.RAW_NUGGET.get());
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.add(ModBlocks.NUGGET_BLOCK.get());
			entries.add(ModBlocks.RAW_NUGGET_BLOCK.get());
		});

		// Register trades AFTER villager registration
		registerVillagerTrades();
	}

	private void registerVillagerTrades() {
		LOGGER.info("Registering villager trades...");

		// Villager trades - Vanilla Farmer
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModItems.NUGGET.get(), 8), 7, 2, 0.04f));
		});

		// Custom Nuggeter Villager Trades - Level 1 (Novice)
		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 5),
					new ItemStack(ModItems.NUGGET.get(), 20), 4, 7, 0.04f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 2),
					new ItemStack(ModItems.RAW_NUGGET.get(), 12), 6, 5, 0.05f));
		});

		// Custom Nuggeter Villager Trades - Level 2 (Apprentice)
		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 2, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.GOLD_INGOT, 8),
					new ItemStack(ModItems.NUGGET_SWORD.get(), 1), 3, 10, 0.05f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModItems.NUGGET_PICKAXE.get(), 1), 3, 10, 0.05f));
		});

		// Custom Nuggeter Villager Trades - Level 3 (Journeyman)
		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 3, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 15),
					new ItemStack(ModItems.NUGGET_HELMET.get(), 1), 2, 15, 0.05f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 20),
					new ItemStack(ModItems.NUGGET_CHESTPLATE.get(), 1), 2, 15, 0.05f));
		});

		// Custom Nuggeter Villager Trades - Level 4 (Expert)
		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 4, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 5),
					new ItemStack(ModItems.NUGGET_LEGGINGS.get(), 1), 2, 20, 0.05f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 12),
					new ItemStack(ModItems.NUGGET_BOOTS.get(), 1), 2, 20, 0.05f));
		});

		// Custom Nuggeter Villager Trades - Level 5 (Master)
		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 5, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 30),
					new ItemStack(ModItems.NUGGET_HORSE_ARMOR.get(), 1), 1, 30, 0.1f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 10),
					new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 1, 30, 0.1f));
		});

		// Wandering Trader Trades
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			// Generic trades
			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "emerald_for_nugget"), (world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 12),
					new ItemStack(ModItems.NUGGET.get(), 3), 2, 8, 0.2f));

			// Rare trades
			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "diamond_for_musicdisc"), (world, entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 8),
					new ItemStack(ModItems.NUGGET_MUSIC_DISC.get(), 1), 1, 12, 0.2f));

			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "emerald_for_smithingtemplate"), (world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 25),
					new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 1, 12, 0.2f));
		});
	}
}

