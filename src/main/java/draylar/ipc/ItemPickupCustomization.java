package draylar.ipc;

import draylar.ipc.config.IPCConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ItemPickupCustomization implements ModInitializer {

    public static final IPCConfig CONFIG = AutoConfig.register(IPCConfig.class, GsonConfigSerializer::new).getConfig();

    @Override
    public void onInitialize() {

    }
}
