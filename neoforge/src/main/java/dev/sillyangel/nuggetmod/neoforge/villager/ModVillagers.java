package dev.sillyangel.nuggetmod.neoforge.villager;

import com.google.common.collect.ImmutableSet;
import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, NuggetMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, NuggetMod.MOD_ID);

    public static final ResourceKey<VillagerProfession> NUGGETER_KEY =
            ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter"));

    public static final Supplier<PoiType> NUGGETER_POI = POI_TYPES.register("nuggeter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.NUGGET_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final Supplier<VillagerProfession> NUGGETER = VILLAGER_PROFESSIONS.register("nuggeter",
            () -> new VillagerProfession(Component.literal("Nuggeter"),
                    holder -> holder.value() == NUGGETER_POI.get(),
                    poiTypeHolder -> poiTypeHolder.value() == NUGGETER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void registerVillagers(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}

