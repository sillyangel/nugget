package dev.sillyangel.nuggetmod.fabric.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;

public class ModItemGroups {

    public static final CreativeModeTabs NUGGET_BLOCKS_GROUP = Registry.register(Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .title(Component.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.NUGGET_BLOCK.get());
                        entries.accept(ModBlocks.RAW_NUGGET_BLOCK.get());
                        entries.accept(ModBlocks.NUGGET_ORE.get());
                        entries.accept(ModBlocks.NUGGET_DEEPSLATE_ORE.get());
                    }).build());

    public static final CreativeModeTab NUGGET_ITEMS_GROUP = Registry.register(Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .title(Component.translatable("creativetab.nuggetmod.nugget_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.NUGGET.get());
                        entries.accept(ModItems.RAW_NUGGET.get());

                        // Tool Set
                        entries.accept(ModItems.NUGGET_SWORD.get());
                        entries.accept(ModItems.NUGGET_PICKAXE.get());
                        entries.accept(ModItems.NUGGET_AXE.get());
                        entries.accept(ModItems.NUGGET_SHOVEL.get());
                        entries.accept(ModItems.NUGGET_HOE.get());
                        entries.accept(ModItems.NUGGET_SPEAR.get());

                        // Armor
                        entries.accept(ModItems.NUGGET_HELMET.get());
                        entries.accept(ModItems.NUGGET_CHESTPLATE.get());
                        entries.accept(ModItems.NUGGET_LEGGINGS.get());
                        entries.accept(ModItems.NUGGET_BOOTS.get());

                        entries.accept(ModItems.NUGGET_HORSE_ARMOR.get());

                        entries.accept(ModItems.NUGGET_SMITHING_TEMPLATE.get());

                        entries.accept(ModItems.NUGGET_MUSIC_DISC.get());
                    }).build());

    public static void registerItemGroups() {
        NuggetMod.LOGGER.info("Registering Item Groups for " + NuggetMod.MOD_ID);
    }
}
