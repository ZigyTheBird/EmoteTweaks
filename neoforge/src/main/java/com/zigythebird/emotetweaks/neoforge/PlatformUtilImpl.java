package com.zigythebird.emotetweaks.neoforge;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class PlatformUtilImpl {
    public static Path getGamePath() {
        return FMLPaths.GAMEDIR.get();
    }
}
