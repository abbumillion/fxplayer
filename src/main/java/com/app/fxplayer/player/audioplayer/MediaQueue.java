package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.models.Song;
import javafx.scene.media.Media;

public final class MediaQueue {
    private static Song currentSong , nextSong , prevSong;
    private static Media media;
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

    public static void setMedia(Media media) {
        MediaQueue.media = media;
    }

    public static Media getMedia() {
        return media;
    }
}

