package dev.sillyangel.nuggetmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties NUGGET = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .build();
}

