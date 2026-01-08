package dev.sillyangel.nuggetmod.neoforge.villager;

import com.google.common.collect.ImmutableSet;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModVillagers {
    public static final DeferredRegister<PointOfInterestType> POI_TYPES =
            DeferredRegister.create(RegistryKeys.POINT_OF_INTEREST_TYPE, NuggetMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(RegistryKeys.VILLAGER_PROFESSION, NuggetMod.MOD_ID);

    public static final RegistryKey<VillagerProfession> NUGGETER_KEY =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(NuggetMod.MOD_ID, "nuggeter"));

    public static final Supplier<PointOfInterestType> NUGGETER_POI = POI_TYPES.register("nuggeter_poi",
            () -> new PointOfInterestType(ImmutableSet.copyOf(ModBlocks.NUGGET_BLOCK.get().getStateManager().getStates()), 1, 1));

    public static final Supplier<VillagerProfession> NUGGETER = VILLAGER_PROFESSIONS.register("nuggeter",
            () -> new VillagerProfession(Text.literal("Nuggeter"),
                    holder -> holder.value() == NUGGETER_POI.get(),
                    poiTypeHolder -> poiTypeHolder.value() == NUGGETER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));

    public static void registerVillagers(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}

