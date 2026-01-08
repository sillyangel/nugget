package dev.sillyangel.nuggetmod.neoforge.item;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final DeferredRegister<ItemGroup> CREATIVE_MODE_TABS =
            DeferredRegister.create(RegistryKeys.ITEM_GROUP, NuggetMod.MOD_ID);

    public static final Supplier<ItemGroup> NUGGET_BLOCKS_GROUP = CREATIVE_MODE_TABS.register("nugget_blocks",
            () -> ItemGroup.create(ItemGroup.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .displayName(Text.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.NUGGET_BLOCK.get());
                        entries.add(ModBlocks.RAW_NUGGET_BLOCK.get());
                        entries.add(ModBlocks.NUGGET_ORE.get());
                        entries.add(ModBlocks.NUGGET_DEEPSLATE_ORE.get());
                    }).build());

    public static final Supplier<ItemGroup> NUGGET_ITEMS_GROUP = CREATIVE_MODE_TABS.register("nugget_items",
            () -> ItemGroup.create(ItemGroup.Row.TOP, -1)
                    .icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .withTabsBefore(Identifier.of(NuggetMod.MOD_ID, "nugget_blocks"))
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

    public static void registerItemGroups(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

