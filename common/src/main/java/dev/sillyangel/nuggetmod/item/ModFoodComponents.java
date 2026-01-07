package dev.sillyangel.nuggetmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent NUGGET = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .build();
}

