/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock.countdown;

import de.digitaldevs.flashblock.FlashBlockPlugin;
import de.digitaldevs.flashblock.util.Var;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class LobbyCountdown extends Countdown {

    private static final int MAX_SECONDS = 60;

    private final FlashBlockPlugin plugin;
    @Setter
    private int seconds;
    private int taskID;
    @Setter
    private boolean isRunning;
    @Setter
    private boolean isIdling;

    public LobbyCountdown(FlashBlockPlugin plugin, int seconds) {
        this.plugin = plugin;
        this.seconds = seconds;
        this.isRunning = false;
        this.isIdling = false;
    }

    @Override
    void start() {
        if (!this.isRunning) {
            if (Bukkit.getOnlinePlayers().size() >= Var.MIN_PLAYERS) {
                this.setRunning(true);
                this.taskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this.plugin, () -> {
                    switch (this.seconds) {
                        case 60: case 30: case 20: case 10: case 5: case 4: case 3: case 2: {
                            Bukkit.broadcastMessage(Var.PREFIX + "§7Das Spiel startet in §e" + this.seconds + " Sekunden§7.");
                            this.playEffects();
                            break;
                        }
                        case 1: {
                            Bukkit.broadcastMessage(Var.PREFIX + "§7Das Spiel startet in §eeiner Sekunde§7.");
                            this.playEffects();
                            break;
                        }
                        case 0: {
                            Bukkit.broadcastMessage(Var.PREFIX + "§7Das Spiel startet...");
                            Bukkit.broadcastMessage(Var.PREFIX + "§7Alle Spieler werden teleportiert...");
                            this.playEndEffect();
                            break;
                        }
                    }

                    this.seconds--;
                }, 0L, 20L);
            } else {
                setIdling(true);
            }
        }
    }

    @Override
    void stop() {
        if (this.isRunning) {
            Bukkit.getScheduler().cancelTask(this.taskID);
            this.setRunning(false);
            this.setIdling(true);
            this.setSeconds(MAX_SECONDS);
        }
    }

    private void playEffects() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 2.5F, 1.0F);
            player.setLevel(this.seconds);
        });
    }

    private void playEndEffect() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.setLevel(0);
            player.setExp(0F);
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 2.5F, 1.0F);
        });
    }

    public int getSeconds() {
        return this.seconds;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public boolean isIdling() {
        return this.isIdling;
    }
}
