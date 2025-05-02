package com.zigythebird.emotetweaks.fabric.client;

import com.zigythebird.emotetweaks.client.EmoteTweaksClient;
import net.fabricmc.api.ClientModInitializer;

public final class EmoteTweaksFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EmoteTweaksClient.onInitializeClient();
    }
}
