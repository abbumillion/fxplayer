package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.scene.media.Media;
import java.util.List;

public class MediaQueue{
    private static List mediaQueue = FXCollections.observableArrayList();
    private static int currentIndex = 0;
    // to add a song to current
    public static void addToCurrent(Song song)
    {
        mediaQueue.add(song);
        currentIndex = mediaQueue.indexOf(song);
    }

    public static void addToNext(Song song)
    {
        mediaQueue.add(song);
        currentIndex = mediaQueue.indexOf(song);
    }

    public static void addToPrev(Song song)
    {
        mediaQueue.add(song);
        currentIndex = mediaQueue.indexOf(song);
    }

    public static void removeAll()
    {
        mediaQueue.clear();
    }

    public static Song getCurrent()
    {

        return (Song) mediaQueue.get(currentIndex);
    }

    public static Song getPrev()
    {
        return (Song) mediaQueue.get(currentIndex - 1);
    }

    public static Song getNext()
    {
        return (Song) mediaQueue.get(currentIndex + 1);
    }

    public static List getMediaQueue() {
        return mediaQueue;
    }

}
