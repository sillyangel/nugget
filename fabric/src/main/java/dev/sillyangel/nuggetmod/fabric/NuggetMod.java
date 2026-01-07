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

		// Villager trades
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModItems.NUGGET.get(), 8), 7, 2, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 5),
					new ItemStack(ModItems.NUGGET.get(), 20), 4, 7, 0.04f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET.get(), 16),
					new ItemStack(ModItems.NUGGET_HORSE_ARMOR.get(), 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 2, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET.get(), 10),
					new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 4, 7, 0.04f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET.get(), 10),
					new ItemStack(ModItems.NUGGET_MUSIC_DISC.get(), 1), 3, 12, 0.09f));
		});

		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "emerald_for_nuggetsmithing"), (world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 25),
					new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE.get(), 1), 4, 7, 0.04f));

			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "nuggets_to_musicdisc"), (world, entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET.get(), 15),
					new ItemStack(ModItems.NUGGET_MUSIC_DISC.get(), 1), 3, 12, 0.09f));
		});
	}
}

