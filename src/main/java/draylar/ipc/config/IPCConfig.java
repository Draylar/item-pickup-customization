package draylar.ipc.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "item-pickup-customization")
public class IPCConfig implements ConfigData {

    public boolean allowItemPickup = true;
    public boolean allowClickPickup = true;
}
