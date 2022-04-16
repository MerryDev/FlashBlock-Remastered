/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock;

import de.digitaldevs.gameapi.GameAPI;
import de.digitaldevs.gameapi.GameAPIPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class FlashBlockPlugin extends JavaPlugin {

    private GameAPI gameAPI;

    @Override
    public void onEnable() {
        if (!this.canLoadGameAPI()) {
            Bukkit.getLogger().severe(() -> "Could not load GameAPI! Please make sure you are using it.");
            return;
        }

        this.gameAPI = GameAPIPlugin.getApi();

        Bukkit.getLogger().info(() -> "Plugin was successfully enabled!");
    }

    private boolean canLoadGameAPI() {
        return Bukkit.getPluginManager().isPluginEnabled("GameAPI");
    }

}
