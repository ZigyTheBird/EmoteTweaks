package com.zigythebird.emotetweaks.voicefx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.UnsupportedAudioFileException;

import com.zigythebird.emotetweaks.EmoteTweaks;
import de.maxhenkel.voicechat.api.ForgeVoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatServerApi;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoicechatServerStartedEvent;

@ForgeVoicechatPlugin
public class SoundPlugin implements VoicechatPlugin {

    public static VoicechatApi voicechatApi;
    public static VoicechatServerApi voicechatServerApi;

    private static final List<SFXThread> runningThreads = new ArrayList<>();

    @Override
    public String getPluginId() {
        return "emotetweaks";
    }

    @Override
    public void initialize(VoicechatApi api) {
        voicechatApi = api;
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(VoicechatServerStartedEvent.class, this::onServerStarted);
    }

    public void onServerStarted(VoicechatServerStartedEvent event) {
        voicechatServerApi = event.getVoicechat();
    }

    public static void playSound(short[] data) {
        try {
            SFXThread thread = SFXThread.playSFX(data);
            runningThreads.add(thread);
            thread.startPlaying();
        } catch (UnsupportedAudioFileException | IOException e) {
            EmoteTweaks.LOGGER.error(e.toString());
        }
    }

    public static void stopSounds() {
        for(SFXThread thread : runningThreads) {
            thread.interrupt();
        }
        runningThreads.clear();
    }

}
