package xyz.sillyangel.nugget.datagen;

import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NuggetMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.NUGGET.get());
        basicItem(ModItems.RAW_NUGGET.get());
    }
}