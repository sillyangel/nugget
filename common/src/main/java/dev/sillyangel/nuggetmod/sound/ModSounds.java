package dev.sillyangel.nuggetmod.sound;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.sillyangel.nuggetmod.NuggetMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(NuggetMod.MOD_ID, RegistryKeys.SOUND_EVENT);

    public static final RegistrySupplier<SoundEvent> NUGGET_THEME = SOUND_EVENTS.register("nugget_theme",
            () -> SoundEvent.of(Identifier.of(NuggetMod.MOD_ID, "nugget_theme")));

    public static final RegistryKey<JukeboxSong> NUGGET_THEME_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(NuggetMod.MOD_ID, "nugget_theme"));

    public static void init() {
        SOUND_EVENTS.register();
        NuggetMod.LOGGER.info("Registering Mod Sounds for " + NuggetMod.MOD_ID);
    }
}

