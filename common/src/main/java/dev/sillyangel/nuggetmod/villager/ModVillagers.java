package dev.sillyangel.nuggetmod.villager;

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
import net.minecraft.world.item.trading.TradeSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;



public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create( NuggetMod.MOD_ID, Registries.POINT_OF_INTEREST_TYPE);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(NuggetMod.MOD_ID, Registries.VILLAGER_PROFESSION);

    public static final ResourceKey<VillagerProfession> NUGGETER_KEY =
            ResourceKey.create(Registries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter"));

    public static final RegistrySupplier<PoiType> NUGGETER_POI = POI_TYPES.register("nuggeter_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.NUGGET_BLOCK.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final ResourceKey<TradeSet> NUGGETER_LEVEL_1 =
            ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter/level_1"));

    public static final ResourceKey<TradeSet> NUGGETER_LEVEL_2 =
            ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter/level_2"));

    public static final ResourceKey<TradeSet> NUGGETER_LEVEL_3 =
            ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter/level_3"));

    public static final ResourceKey<TradeSet> NUGGETER_LEVEL_4 =
            ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter/level_4"));

    public static final ResourceKey<TradeSet> NUGGETER_LEVEL_5 =
            ResourceKey.create(Registries.TRADE_SET,
                    Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nuggeter/level_5"));

    public static final RegistrySupplier<VillagerProfession> NUGGETER = VILLAGER_PROFESSIONS.register("nuggeter",
            () -> new VillagerProfession(Component.literal("Nuggeter"),
                    holder -> holder.value() == NUGGETER_POI.get(),
                    poiTypeHolder -> poiTypeHolder.value() == NUGGETER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN,
                    Int2ObjectMap.ofEntries(
                            Int2ObjectMap.entry(1, NUGGETER_LEVEL_1),
                            Int2ObjectMap.entry(2, NUGGETER_LEVEL_2),
                            Int2ObjectMap.entry(3, NUGGETER_LEVEL_3),
                            Int2ObjectMap.entry(4, NUGGETER_LEVEL_4),
                            Int2ObjectMap.entry(5, NUGGETER_LEVEL_5)
                    )));

    public static void init() {
        POI_TYPES.register();
        VILLAGER_PROFESSIONS.register();
    }
}

