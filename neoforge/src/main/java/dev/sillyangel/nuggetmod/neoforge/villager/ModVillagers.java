package dev.sillyangel.nuggetmod.neoforge.villager;

import com.google.common.collect.ImmutableSet;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> NUGGETER_POI_KEY = registerPoiKey("nuggeter_poi");

    public static final RegistryKey<VillagerProfession> NUGGETER_KEY =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(NuggetMod.MOD_ID, "nuggeter"));

    public static final VillagerProfession NUGGETER = registerProfession("nuggeter", NUGGETER_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(NuggetMod.MOD_ID, name),
                new VillagerProfession(Text.literal("Nuggeter"), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(NuggetMod.MOD_ID, name));
    }

    public static void registerVillagers() {
    }
}

