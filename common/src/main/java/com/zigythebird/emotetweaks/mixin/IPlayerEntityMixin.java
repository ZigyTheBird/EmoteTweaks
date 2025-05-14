package com.zigythebird.emotetweaks.mixin;

import io.github.kosmx.emotes.main.emotePlay.EmotePlayer;
import io.github.kosmx.emotes.main.mixinFunctions.IPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = IPlayerEntity.class, remap = false)
public interface IPlayerEntityMixin {
    @Shadow @Nullable EmotePlayer emotecraft$getEmote();

    @Inject(method = "emotecraft$playerEntersInvalidPose", at = @At(value = "INVOKE", target = "Lio/github/kosmx/emotes/main/network/ClientEmotePlay;clientStopLocalEmote(Ldev/kosmx/playerAnim/core/data/KeyframeAnimation;)Z"), cancellable = true)
    private void checkInvalid(CallbackInfo ci) {
        EmotePlayer player = this.emotecraft$getEmote();
        if (player.getData() != null) {
            boolean b = player.getData().extraData.containsKey("crouchCancel") && (boolean) player.getData().extraData.get("crouchCancel");
            if (!b) {
                ci.cancel();
            }
        }
    }
}
