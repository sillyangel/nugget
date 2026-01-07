package dev.sillyangel.nuggetmod.fabric.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType NUGGET_PARTICLE =
            registerParticle("nugget_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NuggetMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        NuggetMod.LOGGER.info("Registering Particles for " + NuggetMod.MOD_ID);
    }
}