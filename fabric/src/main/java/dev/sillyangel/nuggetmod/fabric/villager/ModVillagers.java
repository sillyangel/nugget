package dev.sillyangel.nuggetmod.fabric.villager;

import com.google.common.collect.ImmutableSet;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;

public class ModVillagers {
    public static final ResourceKey<PoiType> NUGGETER_POI_KEY = registerPoiKey("nuggeter_poi");
    public static final PoiType NUGGETER_POI = registerPOI("nuggeter_poi", ModBlocks.NUGGET_BLOCK.get());

    public static final ResourceKey<VillagerProfession> NUGGETER_KEY =
            ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter"));
    public static final VillagerProfession NUGGETER = registerProfession("nuggeter", NUGGETER_POI_KEY);


    private static VillagerProfession registerProfession(String name, ResourceKey<PoiType> type) {
        return new VillagerProfession(
                Component.translatable("entity.nuggetmod.villager.nuggeter"),
                entry -> entry.is(type),
                entry -> entry.is(type),
                ImmutableSet.of(),
                ImmutableSet.of(),
                SoundEvents.VILLAGER_WORK_LIBRARIAN
        );
    }


    private static PoiType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name),
                1, 1, block);
    }

    private static ResourceKey<PoiType> registerPoiKey(String name) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        NuggetMod.LOGGER.info("Registering Villagers for " + NuggetMod.MOD_ID);
    }
}