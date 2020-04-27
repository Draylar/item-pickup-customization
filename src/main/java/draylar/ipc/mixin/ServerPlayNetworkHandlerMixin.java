package draylar.ipc.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Inject(method = "onPlayerInteractEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;updateLastActionTime()V"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void go(PlayerInteractEntityC2SPacket rpacket, CallbackInfo ci, ServerWorld world, Entity entity) {
        if(entity instanceof ItemEntity && rpacket.getType() == PlayerInteractEntityC2SPacket.InteractionType.ATTACK) {
            ci.cancel();
        }
    }
}
