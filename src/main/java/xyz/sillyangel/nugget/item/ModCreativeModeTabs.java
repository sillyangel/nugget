package xyz.sillyangel.nugget.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import xyz.sillyangel.nugget.NuggetMod;
import xyz.sillyangel.nugget.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NuggetMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NUGGET_ITEMS_TAB = CREATIVE_MODE_TABS.register("nuggetmod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.NUGGET.get()))
                    .title(Component.translatable("creativetab.nuggetmod.nugget_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.NUGGET.get());
                      output.accept(ModItems.RAW_NUGGET.get());

                        output.accept(ModItems.NUGGET_SWORD.get());
                        output.accept(ModItems.NUGGET_PICKAXE.get());
                        output.accept(ModItems.NUGGET_SHOVEL.get());
                        output.accept(ModItems.NUGGET_AXE.get());
                        output.accept(ModItems.NUGGET_HOE.get());

                        output.accept(ModItems.NUGGET_HELMET.get());
                        output.accept(ModItems.NUGGET_CHESTPLATE.get());
                        output.accept(ModItems.NUGGET_LEGGINGS.get());
                        output.accept(ModItems.NUGGET_BOOTS.get());

                        output.accept(ModItems.NUGGET_HORSE_ARMOR.get());
                        output.accept(ModItems.NUGGET_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.NUGGET_MUSIC_DISC.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> NUGGET_BLOCKS_TAB = CREATIVE_MODE_TABS.register("nuggetmod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.NUGGET_BLOCK.get()))
                    .withTabsBefore(NUGGET_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.nuggetmod.nugget_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.NUGGET_BLOCK.get());
                        output.accept(ModBlocks.RAW_NUGGET_BLOCK.get());
                        output.accept(ModBlocks.NUGGET_ORE.get());
                        output.accept(ModBlocks.NUGGET_DEEPSLATE_ORE.get()); 
                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
