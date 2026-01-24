package dev.sillyangel.nuggetmod;

import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItemGroups;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NuggetMod {
    public static final String MOD_ID = "nuggetmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Initializing Nugget Mod");

        // Initialize registries - order matters!
        ModSounds.init();
        ModItems.init();
        ModBlocks.init();
        ModItemGroups.init();

        LOGGER.info("Nugget Mod initialized");
    }
}

