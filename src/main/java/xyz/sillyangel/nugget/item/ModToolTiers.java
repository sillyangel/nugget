package xyz.sillyangel.nugget.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import xyz.sillyangel.nugget.util.ModTags;

public class ModToolTiers {
    public static final Tier NUGGET =  new ForgeTier(1500, 4.5f, 3.5f, 22,
            ModTags.Blocks.NEEDS_NUGGET_TOOL, () -> Ingredient.of(ModItems.NUGGET.get()),
            ModTags.Blocks.INCORRECT_FOR_NUGGET_TOOL);
}
