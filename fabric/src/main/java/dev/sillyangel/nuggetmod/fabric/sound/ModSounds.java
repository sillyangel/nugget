package dev.sillyangel.nuggetmod.fabric.sound;

import dev.sillyangel.nuggetmod.fabric.NuggetMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent NUGGET_THEME = registerSoundEvent("nugget_theme");
    public static final RegistryKey<JukeboxSong> NUGGET_THEME_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(NuggetMod.MOD_ID, "nugget_theme"));

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(NuggetMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        NuggetMod.LOGGER.info("Registering Mod Sounds for " + NuggetMod.MOD_ID);
    }
}