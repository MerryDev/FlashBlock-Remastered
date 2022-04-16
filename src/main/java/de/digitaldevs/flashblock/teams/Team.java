/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock.teams;

import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;

@AllArgsConstructor
public enum Team {

    BLUE(ChatColor.BLUE, "Blau"),
    RED(ChatColor.RED, "Rot"),
    GREEN(ChatColor.GREEN, "Grün"),
    PURPLE(ChatColor.DARK_PURPLE, "Lila"),
    ORANGE(ChatColor.GOLD, "Orange"),
    WHITE(ChatColor.WHITE, "Weiß"),
    BLACK(ChatColor.BLACK, "Schwarz"),
    PINK(ChatColor.LIGHT_PURPLE, "Pink");

    private final ChatColor color;
    private final String name;

}
