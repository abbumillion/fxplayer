package com.app.fxplayer.player.audioplayer;

/**
 * PLAYER PLAYING MODES
 */
public enum PlayingMode {
    /**
     * RANDOM SELECTION OF SONGS
     */
    SHUFFLE,
    /**
     * REPEAT THE CURRENT SONG
     */
    REPEAT,
    /**
     * NO RANDOM SELECTION / BY ORDER
     */
    NO_SHUFFLE,
    /**
     * NO REPEATING CURRENT SONG
     */
    NO_REPEAT,
    /**
     * CYCLE THE PLAY LIST
     */
    CYCLE,
    /**
     * STOP THE PLAYER WHEN IT FINISHES THE PLAY LIST
     */
    NO_CYCLE
}
