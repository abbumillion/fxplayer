package com.app.fxplayer.player.audioplayer;

import javafx.collections.FXCollections;
import javafx.scene.media.Media;

import java.util.List;

public class MediaQueue{
    private List mediaQueue = FXCollections.emptyObservableList();
    private int currentIndex = 0;
    public void add(Media media)
    {
        mediaQueue.add(media);
        currentIndex = mediaQueue.indexOf(media);
    }
    public void remove()
    {
    }

    public Media getCurrent()
    {

        return (Media) mediaQueue.get(currentIndex);
    }

    public Media getPrev()
    {
        return (Media) mediaQueue.get(currentIndex - 1);
    }

    public Media getNext()
    {
        return (Media) mediaQueue.get(currentIndex + 1);
    }

    public List getMediaQueue() {
        return mediaQueue;
    }
}
