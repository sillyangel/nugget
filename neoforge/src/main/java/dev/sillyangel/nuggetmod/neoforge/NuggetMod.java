package dev.sillyangel.nuggetmod.neoforge;

import dev.sillyangel.nuggetmod.neoforge.blocks.entities.ModBlockEntityTypesNeoForge;
import net.neoforged.fml.common.Mod;

@Mod(dev.sillyangel.nuggetmod.NuggetMod.MOD_ID)
public final class NuggetMod {
    public NuggetMod() {
        dev.sillyangel.nuggetmod.NuggetMod.init();
        ModBlockEntityTypesNeoForge.initBlockEntityTypes();
    }
}
