/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock;

import de.digitaldevs.flashblock.countdown.LobbyCountdown;
import de.digitaldevs.flashblock.gamestate.EndingState;
import de.digitaldevs.flashblock.gamestate.IngameFightingState;
import de.digitaldevs.flashblock.gamestate.IngameRespawnState;
import de.digitaldevs.flashblock.gamestate.LobbyState;
import de.digitaldevs.gameapi.GameAPI;
import de.digitaldevs.gameapi.GameAPIPlugin;
import de.digitaldevs.gameapi.gamestate.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FlashBlockPlugin extends JavaPlugin {

    //hs

    private GameAPI gameAPI;

    @Override
    public void onEnable() {
        if (!this.canLoadGameAPI()) {
            Bukkit.getLogger().severe(() -> "Could not load GameAPI! Please make sure you are using it.");
            return;
        }

        this.gameAPI = GameAPIPlugin.getApi();
        this.registerGameStates();

        this.registerListener();
        this.registerCommands();

        Bukkit.getLogger().info(() -> "Plugin was successfully enabled!");
    }

    private boolean canLoadGameAPI() {
        return Bukkit.getPluginManager().isPluginEnabled("GameAPI");
    }

    private void registerGameStates() {
        final GameStateManager gameStateManager = this.gameAPI.getGameStateManager();
        gameStateManager.registerNewGameState(new LobbyState(this, new LobbyCountdown(this, 60)));
        gameStateManager.registerNewGameState(new IngameRespawnState(this));
        gameStateManager.registerNewGameState(new IngameFightingState(this));
        gameStateManager.registerNewGameState(new EndingState(this));
    }

    private void registerCommands() {

    }

    private void registerListener() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
    }

}
