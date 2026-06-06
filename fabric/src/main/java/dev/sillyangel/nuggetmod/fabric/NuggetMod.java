package dev.sillyangel.nuggetmod.fabric;

import net.fabricmc.api.ModInitializer;
import dev.sillyangel.nuggetmod.fabric.world.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuggetMod implements ModInitializer {
	public static final String MOD_ID = "nuggetmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Nugget (Fabric)");

		// Initialize common mod
		dev.sillyangel.nuggetmod.NuggetMod.init();

		ModWorldGeneration.generateModWorldGen();
	}
}

