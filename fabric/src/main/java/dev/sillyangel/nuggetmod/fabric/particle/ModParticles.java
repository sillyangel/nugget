package dev.sillyangel.nuggetmod.fabric.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModParticles {
    public static final SimpleParticleType NUGGET_PARTICLE =
            registerParticle("nugget_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        NuggetMod.LOGGER.info("Registering Particles for " + NuggetMod.MOD_ID);
    }
}