package dev.sillyangel.nuggetmod.neoforge;

import dev.sillyangel.nuggetmod.neoforge.item.ModItemGroups;
import dev.sillyangel.nuggetmod.neoforge.particle.ModParticles;
import dev.sillyangel.nuggetmod.neoforge.villager.ModVillagers;
import net.neoforged.fml.common.Mod;

@Mod(dev.sillyangel.nuggetmod.NuggetMod.MOD_ID)
public final class NuggetMod {
    public NuggetMod() {
        // Run our common setup.
        dev.sillyangel.nuggetmod.NuggetMod.init();

        // Register NeoForge-specific features
        ModParticles.registerParticles();
        ModVillagers.registerVillagers();
        ModItemGroups.registerItemGroups();
    }
}
