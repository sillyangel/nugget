package dev.sillyangel.nuggetmod.neoforge.item;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuggetMod.MOD_ID);

    public static final Supplier<CreativeModeTab> NUGGET_BLOCKS_GROUP = CREATIVE_MODE_TABS.register("nugget_blocks",
            () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .title(Component.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.NUGGET_BLOCK.get());
                        entries.accept(ModBlocks.RAW_NUGGET_BLOCK.get());
                        entries.accept(ModBlocks.NUGGET_ORE.get());
                        entries.accept(ModBlocks.NUGGET_DEEPSLATE_ORE.get());
                    }).build());

    public static final Supplier<CreativeModeTab> NUGGET_ITEMS_GROUP = CREATIVE_MODE_TABS.register("nugget_items",
            () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .withTabsBefore(Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_blocks"))
                    .title(Component.translatable("creativetab.nuggetmod.nugget_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.NUGGET.get());
                        entries.accept(ModItems.RAW_NUGGET.get());

                        entries.accept(ModItems.NUGGET_SWORD.get());
                        entries.accept(ModItems.NUGGET_PICKAXE.get());
                        entries.accept(ModItems.NUGGET_AXE.get());
                        entries.accept(ModItems.NUGGET_SHOVEL.get());
                        entries.accept(ModItems.NUGGET_HOE.get());
                        entries.accept(ModItems.NUGGET_SPEAR.get());

                        entries.accept(ModItems.NUGGET_HELMET.get());
                        entries.accept(ModItems.NUGGET_CHESTPLATE.get());
                        entries.accept(ModItems.NUGGET_LEGGINGS.get());
                        entries.accept(ModItems.NUGGET_BOOTS.get());

                        entries.accept(ModItems.NUGGET_HORSE_ARMOR.get());
                        entries.accept(ModItems.NUGGET_SMITHING_TEMPLATE.get());
                        entries.accept(ModItems.NUGGET_MUSIC_DISC.get());

                        entries.accept(ModBlocks.NUGGET_CAKE.get());
                    }).build());

    public static void registerItemGroups(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

