package com.zigythebird.emotetweaks;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

import java.nio.file.Path;

public class PlatformUtil {
    @ExpectPlatform
    public static Path getGamePath() {
        throw new NotImplementedException();
    }
}
