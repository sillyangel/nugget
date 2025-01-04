package xyz.sillyangel.nugget.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;
import xyz.sillyangel.nugget.NuggetMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NuggetMod.MOD_ID);


    public static final RegistryObject<SoundEvent> NUGGET_THEME = registerSoundEvent("nugget_theme");
    public static final ResourceKey<JukeboxSong> NUGGET_THEME_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, "nugget_theme"));



    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(NuggetMod.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
