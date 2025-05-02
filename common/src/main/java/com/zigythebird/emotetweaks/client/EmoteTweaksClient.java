package com.zigythebird.emotetweaks.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import com.zigythebird.emotetweaks.voicefx.SoundPlugin;
import io.github.kosmx.emotes.api.events.client.ClientEmoteEvents;

@Environment(EnvType.CLIENT)
public class EmoteTweaksClient {
    public static void onInitializeClient() {
        ClientEmoteEvents.EMOTE_PLAY.register((emoteData, userID) -> {
            if(userID == Minecraft.getInstance().player.getUUID()) {
                SoundPlugin.stopSounds();
            }
        });
    }
}
