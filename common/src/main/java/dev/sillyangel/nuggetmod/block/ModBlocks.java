package dev.sillyangel.nuggetmod.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.custom.NuggetCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.resources.Identifier;
import net.minecraft.util.valueproviders.UniformInt;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(NuggetMod.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(NuggetMod.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Block> NUGGET_CAKE = registerBlockWithItem("nugget_cake",
            () -> new NuggetCakeBlock(createBlockSettings("nugget_cake")
                    .strength(0.5f)
                    .forceSolidOn()
                    .sound(SoundType.WOOL)));

    public static final RegistrySupplier<Block> NUGGET_BLOCK = registerBlockWithItem("nugget_block",
            () -> new Block(createBlockSettings("nugget_block")
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final RegistrySupplier<Block> RAW_NUGGET_BLOCK = registerBlockWithItem("raw_nugget_block",
            () -> new Block(createBlockSettings("raw_nugget_block")
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> NUGGET_ORE = registerBlockWithItem("nugget_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    createBlockSettings("nugget_ore")
                            .strength(3f)
                            .requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> NUGGET_DEEPSLATE_ORE = registerBlockWithItem("nugget_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    createBlockSettings("nugget_deepslate_ore")
                            .strength(4f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)));

    private static <T extends Block> RegistrySupplier<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = BLOCKS.register(name, block);
        BLOCK_ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties()
                        .useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name)))));
        return toReturn;
    }

    private static BlockBehaviour.Properties createBlockSettings(String name) {
        return BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name)));
    }

    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
        NuggetMod.LOGGER.info("Registering Mod Blocks for " + NuggetMod.MOD_ID);
    }
}

