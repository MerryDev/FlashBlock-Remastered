/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FlashBlockPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin was successfully enabled!");
    }
}
