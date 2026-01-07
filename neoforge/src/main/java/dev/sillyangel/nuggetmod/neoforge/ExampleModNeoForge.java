package dev.sillyangel.nuggetmod.neoforge;

import net.neoforged.fml.common.Mod;

import dev.sillyangel.nuggetmod.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
