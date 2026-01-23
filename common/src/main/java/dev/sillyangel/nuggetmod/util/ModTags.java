package dev.sillyangel.nuggetmod.util;

import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NUGGET_TOOL = createTag("needs_nugget_tool");
        public static final TagKey<Block> INCORRECT_FOR_NUGGET_TOOL = createTag("incorrect_for_nugget_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> NUGGET_TOOL_MATERIALS = createTag("nugget_tool_materials");
        public static final TagKey<Item> REPAIRS_NUGGET_ARMOR = createTag("repairs_nugget_armor");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name));
        }
    }
}

