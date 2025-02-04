package xyz.sillyangel.nugget.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NuggetMod.MOD_ID);

    public static final RegistryObject<Block> NUGGET_BLOCK = registerBlock("nugget_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_block")))
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_NUGGET_BLOCK = registerBlock("raw_nugget_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "raw_nugget_block")))
                    .strength(3f).requiresCorrectToolForDrops()));
    // ores
    public static final RegistryObject<Block> NUGGET_ORE = registerBlock("nugget_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_ore")))
                    .strength(4f).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> NUGGET_DEEPSLATE_ORE = registerBlock("nugget_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_deepslate_ore")))
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}