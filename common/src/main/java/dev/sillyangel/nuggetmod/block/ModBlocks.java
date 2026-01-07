package dev.sillyangel.nuggetmod.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(NuggetMod.MOD_ID, RegistryKeys.BLOCK);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(NuggetMod.MOD_ID, RegistryKeys.ITEM);

    public static final RegistrySupplier<Block> NUGGET_BLOCK = registerBlockWithItem("nugget_block",
            () -> new Block(createBlockSettings("nugget_block")
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final RegistrySupplier<Block> RAW_NUGGET_BLOCK = registerBlockWithItem("raw_nugget_block",
            () -> new Block(createBlockSettings("raw_nugget_block")
                    .strength(4f)
                    .requiresTool()));

    public static final RegistrySupplier<Block> NUGGET_ORE = registerBlockWithItem("nugget_ore",
            () -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    createBlockSettings("nugget_ore")
                            .strength(3f)
                            .requiresTool()));

    public static final RegistrySupplier<Block> NUGGET_DEEPSLATE_ORE = registerBlockWithItem("nugget_deepslate_ore",
            () -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    createBlockSettings("nugget_deepslate_ore")
                            .strength(4f)
                            .requiresTool()
                            .sounds(BlockSoundGroup.DEEPSLATE)));

    private static <T extends Block> RegistrySupplier<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        BLOCK_ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Settings()
                        .useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NuggetMod.MOD_ID, name)))));
        return toReturn;
    }

    private static AbstractBlock.Settings createBlockSettings(String name) {
        return AbstractBlock.Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NuggetMod.MOD_ID, name)));
    }

    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
        NuggetMod.LOGGER.info("Registering Mod Blocks for " + NuggetMod.MOD_ID);
    }
}

