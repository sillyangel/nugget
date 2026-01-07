package dev.sillyangel.nuggetmod.neoforge.client;

import dev.sillyangel.nuggetmod.NuggetMod;
import dev.sillyangel.nuggetmod.neoforge.particle.ModParticles;
import dev.sillyangel.nuggetmod.neoforge.particle.NuggetParticle;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = NuggetMod.MOD_ID, value = Dist.CLIENT)
public class NuggetModClient {

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.NUGGET_PARTICLE, NuggetParticle.Factory::new);
    }
}

