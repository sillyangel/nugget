package dev.sillyangel.nuggetmod.particle;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(NuggetMod.MOD_ID, Registries.PARTICLE_TYPE);

    public static final RegistrySupplier<SimpleParticleType> NUGGET_PARTICLE =
            PARTICLE_TYPES.register("nugget_particle",
                    () -> new NuggetParticleType(false));

    public static void init() {
        PARTICLE_TYPES.register();
    }
}