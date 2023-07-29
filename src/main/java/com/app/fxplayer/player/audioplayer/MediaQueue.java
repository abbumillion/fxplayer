package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.models.Song;

public final class MediaQueue {
    private static Song currentSong , nextSong , prevSong;

    public static void setCurrentSong(Song currentSong) {
        MediaQueue.currentSong = currentSong;
    }

    public static void setNextSong(Song nextSong) {
        MediaQueue.nextSong = nextSong;
    }

    public static void setPrevSong(Song prevSong) {
        MediaQueue.prevSong = prevSong;
    }

    public static Song getCurrentSong() {
        return currentSong;
    }

    public static Song getPrevSong() {
        return prevSong;
    }

    public static Song getNextSong() {
        return nextSong;
    }
}
