package com.zigythebird.emotetweaks.fabric;

import com.zigythebird.emotetweaks.EmoteTweaks;
import net.fabricmc.api.ModInitializer;

public final class EmoteTweaksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        EmoteTweaks.onInitialize();
    }
}
