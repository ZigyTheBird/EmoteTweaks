package com.zigythebird.emotetweaks.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class PlatformUtilImpl {
    public static Path getGamePath() {
        return FabricLoader.getInstance().getGameDir();
    }
}
