/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock.gamestate;

import de.digitaldevs.flashblock.FlashBlockPlugin;
import de.digitaldevs.flashblock.countdown.LobbyCountdown;
import de.digitaldevs.gameapi.gamestate.GameState;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LobbyState implements GameState {

    private final FlashBlockPlugin plugin;
    private final LobbyCountdown lobbyCountdown;

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
