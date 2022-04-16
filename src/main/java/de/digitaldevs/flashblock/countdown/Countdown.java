/*
 * Copyright (c) 2022. DigitalDevs
 */

package de.digitaldevs.flashblock.countdown;

public abstract class Countdown {

    int taskID;

    abstract void start();

    abstract void stop();
}
