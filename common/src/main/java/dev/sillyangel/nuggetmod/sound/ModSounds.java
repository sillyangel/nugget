package dev.sillyangel.nuggetmod.sound;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.Identifier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(NuggetMod.MOD_ID, Registries.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> NUGGET_THEME = SOUND_EVENTS.register("nugget_theme",
            () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_theme")));

    public static final ResourceKey<JukeboxSong> NUGGET_THEME_KEY =
            ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_theme"));

    public static void init() {
        SOUND_EVENTS.register();
        NuggetMod.LOGGER.info("Registering Mod Sounds for " + NuggetMod.MOD_ID);
    }
}

