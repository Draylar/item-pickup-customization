package draylar.ipc.mixin;

import draylar.ipc.ItemPickupCustomization;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow public abstract ItemStack getStack();

    @Shadow private int pickupDelay;

    @Shadow private UUID owner;

    private ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "onPlayerCollision", at = @At("HEAD"), cancellable = true)
    private void onPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        // cancel if collision pickup is disabled
        if(!ItemPickupCustomization.CONFIG.allowCollisionPickup) {
            ci.cancel();
        }

        // cancel if collision requires shifting but the player isn't
        if(ItemPickupCustomization.CONFIG.collisionRequiresShift && !player.isSneaking()) {
            ci.cancel();
        }
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (!this.world.isClient && ItemPickupCustomization.CONFIG.allowClickPickup && (!ItemPickupCustomization.CONFIG.clickRequiresShift || player.isSneaking())) {
            ItemStack itemStack = this.getStack();
            Item item = itemStack.getItem();
            int i = itemStack.getCount();

            if (this.pickupDelay == 0 && (this.owner == null || this.owner.equals(player.getUuid())) && player.inventory.insertStack(itemStack)) {
                player.sendPickup(this, i);

                if (itemStack.isEmpty()) {
                    this.remove();
                    itemStack.setCount(i);
                }

                player.increaseStat(Stats.PICKED_UP.getOrCreateStat(item), i);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public boolean collides() {
        return true;
    }
}
