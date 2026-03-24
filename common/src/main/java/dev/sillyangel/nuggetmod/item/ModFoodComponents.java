package dev.sillyangel.nuggetmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties NUGGET = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .build();
    public static final FoodProperties NUGGET_CAKE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.7f)
            .build();
}