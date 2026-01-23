package dev.sillyangel.nuggetmod.neoforge.particle;

import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, NuggetMod.MOD_ID);

    public static final Supplier<SimpleParticleType> NUGGET_PARTICLE =
            PARTICLE_TYPES.register("nugget_particle", () -> new SimpleParticleType(false));

    public static void registerParticles(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}

