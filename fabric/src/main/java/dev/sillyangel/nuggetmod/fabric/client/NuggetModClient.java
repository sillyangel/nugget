package dev.sillyangel.nuggetmod.fabric.client;

import dev.sillyangel.nuggetmod.particle.ModParticles;
import dev.sillyangel.nuggetmod.particle.NuggetParticle;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.api.ClientModInitializer;

public class NuggetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleProviderRegistry.getInstance().register(
                ModParticles.NUGGET_PARTICLE.get(),
                NuggetParticle.Factory::new)
        ;
    }
}
