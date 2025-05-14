package com.zigythebird.emotetweaks;

import io.github.kosmx.emotes.common.network.CommonNetwork;

public class SoundFrame {
    public final int tick;
    public final String value;

    public SoundFrame(int tick, String value) {
        this.tick = tick;
        this.value = value;
    }

    public int calculateSize() {
        return 4 + CommonNetwork.stringSize(value);
    }

    @Override
    public String toString() {
        return "SoundFrame{" + "tick=" + tick + ", value=" + value + "}";
    }
}
