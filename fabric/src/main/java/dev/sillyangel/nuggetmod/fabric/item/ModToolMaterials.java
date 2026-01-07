package dev.sillyangel.nuggetmod.fabric.item;

import dev.sillyangel.nuggetmod.fabric.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial NUGGET = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_NUGGET_TOOL,
            1500,
            8.0F,
            3.5F,
            22,
            ModTags.Items.NUGGET_TOOL_MATERIALS
    );
}