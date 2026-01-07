package dev.sillyangel.nuggetmod.neoforge.item;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> NUGGET_BLOCKS_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(NuggetMod.MOD_ID, "nugget_blocks"));

    public static final ItemGroup NUGGET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            NUGGET_BLOCKS_GROUP_KEY,
            ItemGroup.create(ItemGroup.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .displayName(Text.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.NUGGET_BLOCK.get());
                        entries.add(ModBlocks.RAW_NUGGET_BLOCK.get());
                        entries.add(ModBlocks.NUGGET_ORE.get());
                        entries.add(ModBlocks.NUGGET_DEEPSLATE_ORE.get());
                    }).build());

    public static final RegistryKey<ItemGroup> NUGGET_ITEMS_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(NuggetMod.MOD_ID, "nugget_items"));

    public static final ItemGroup NUGGET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            NUGGET_ITEMS_GROUP_KEY,
            ItemGroup.create(ItemGroup.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .displayName(Text.translatable("creativetab.nuggetmod.nugget_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.NUGGET.get());
                        entries.add(ModItems.RAW_NUGGET.get());

                        entries.add(ModItems.NUGGET_SWORD.get());
                        entries.add(ModItems.NUGGET_PICKAXE.get());
                        entries.add(ModItems.NUGGET_AXE.get());
                        entries.add(ModItems.NUGGET_SHOVEL.get());
                        entries.add(ModItems.NUGGET_HOE.get());
                        entries.add(ModItems.NUGGET_SPEAR.get());

                        entries.add(ModItems.NUGGET_HELMET.get());
                        entries.add(ModItems.NUGGET_CHESTPLATE.get());
                        entries.add(ModItems.NUGGET_LEGGINGS.get());
                        entries.add(ModItems.NUGGET_BOOTS.get());

                        entries.add(ModItems.NUGGET_HORSE_ARMOR.get());
                        entries.add(ModItems.NUGGET_SMITHING_TEMPLATE.get());
                        entries.add(ModItems.NUGGET_MUSIC_DISC.get());
                    }).build());

    public static void registerItemGroups() {
    }
}

