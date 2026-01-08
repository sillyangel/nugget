package dev.sillyangel.nuggetmod.neoforge.particle;

import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.registry.RegistryKeys;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<net.minecraft.particle.ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(RegistryKeys.PARTICLE_TYPE, NuggetMod.MOD_ID);

    public static final Supplier<net.minecraft.particle.SimpleParticleType> NUGGET_PARTICLE =
            PARTICLE_TYPES.register("nugget_particle", () -> new net.minecraft.particle.SimpleParticleType(false));

    public static void registerParticles(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}

