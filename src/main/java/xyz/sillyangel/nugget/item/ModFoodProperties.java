package xyz.sillyangel.nugget.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties Nugget = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f)
            .build();
}
