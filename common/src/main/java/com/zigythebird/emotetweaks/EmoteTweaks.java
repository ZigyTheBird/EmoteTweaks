package com.zigythebird.emotetweaks;

import com.zigythebird.emotetweaks.voicefx.SFXPacket;
import com.zigythebird.multiloaderutils.utils.NetworkManager;
import net.minecraft.server.level.ServerPlayer;

public class EmoteTweaks {
    public static final String MOD_ID = "emotetweaks";

    public static void onInitialize() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, SFXPacket.PACKET_ID, ((friendlyByteBuf, packetContext) -> SFXPacket.receiveMessage((ServerPlayer) packetContext.getPlayer().get(), friendlyByteBuf)));
    }
}
