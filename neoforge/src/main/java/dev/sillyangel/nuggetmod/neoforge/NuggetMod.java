package dev.sillyangel.nuggetmod.neoforge;

import dev.sillyangel.nuggetmod.neoforge.item.ModItemGroups;
import dev.sillyangel.nuggetmod.neoforge.particle.ModParticles;
import dev.sillyangel.nuggetmod.neoforge.villager.ModVillagers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(dev.sillyangel.nuggetmod.NuggetMod.MOD_ID)
public final class NuggetMod {
    public NuggetMod(IEventBus modEventBus) {
        // Run our common setup.
        dev.sillyangel.nuggetmod.NuggetMod.init();

        // Register NeoForge-specific features
        ModParticles.registerParticles(modEventBus);
        ModVillagers.registerVillagers(modEventBus);
        ModItemGroups.registerItemGroups(modEventBus);
    }
}
