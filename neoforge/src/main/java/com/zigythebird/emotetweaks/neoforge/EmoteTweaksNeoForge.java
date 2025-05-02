package com.zigythebird.emotetweaks.neoforge;

import com.zigythebird.emotetweaks.EmoteTweaks;
import com.zigythebird.emotetweaks.client.EmoteTweaksClient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(EmoteTweaks.MOD_ID)
public final class EmoteTweaksNeoForge {
    public EmoteTweaksNeoForge(IEventBus eventBus) {
        eventBus.addListener(this::clientInit);
        EmoteTweaks.onInitialize();
    }

    public void clientInit(FMLClientSetupEvent event) {
        EmoteTweaksClient.onInitializeClient();
    }
}
