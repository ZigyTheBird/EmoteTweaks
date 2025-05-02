package com.zigythebird.emotetweaks;

import dev.kosmx.playerAnim.core.data.AnimationBinary;
import io.github.kosmx.emotes.common.network.objects.AbstractNetworkPacket;
import io.github.kosmx.emotes.common.network.objects.NetData;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class SoundDataPacket extends AbstractNetworkPacket {
    public void write(ByteBuffer buf, NetData config) {
        List<SoundFrame> frames = (ArrayList) config.emoteData.extraData.get("sound_effects");
        buf.putInt(frames.size());

        for (SoundFrame frame : frames) {
            buf.putInt(frame.tick);
            AnimationBinary.putString(buf, frame.value);
        }

    }

    public boolean read(ByteBuffer buf, NetData config, int version) {
        int size = buf.getInt();
        if (size <= 0) {
            return false;
        } else {
            List<SoundFrame> soundFrames = new ArrayList<>();

            for (int i = 0; i < size; ++i) {
                soundFrames.add(new SoundFrame(buf.getInt(), AnimationBinary.getString(buf)));
            }

            if (config.emoteData != null) {
                config.emoteData.extraData.put("sound_effects", soundFrames);
            }

            return true;
        }
    }

    public boolean doWrite(NetData config) {
        return config.emoteData != null;
    }

    public byte getID() {
        return 69;
    }

    public byte getVer() {
        return 2;
    }

    public int calculateSize(NetData config) {
        int size = 4;
        if (config.emoteData != null) {
            List<SoundFrame> soundFrames = (List<SoundFrame>) config.emoteData.extraData.get("sound_effects");
            if (soundFrames != null) {
                for (SoundFrame frame : soundFrames) {
                    size += frame.calculateSize();
                }
            }
        }
        return size;
    }
}
