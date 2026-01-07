package dev.sillyangel.nuggetmod.neoforge.particle;

import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType NUGGET_PARTICLE =
            registerParticle("nugget_particle", new SimpleParticleType(false));

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(NuggetMod.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
    }
}

