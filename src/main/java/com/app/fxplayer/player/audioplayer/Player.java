package com.app.fxplayer.player.audioplayer;

import javafx.scene.media.MediaPlayer;

public class Player implements AudioPlayer{

    private MediaQueue mediaQueue = new MediaQueue();
    private  MediaPlayer mediaPlayer;

    @Override
    public void play() {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(mediaQueue.getCurrent());
        mediaPlayer.play();
    }


    @Override
    public void next() {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(mediaQueue.getNext());
        mediaPlayer.play();
    }

    @Override
    public void prev() {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(mediaQueue.getPrev());
        mediaPlayer.play();
    }

    private void checkMediaPlayer() {
        if (mediaPlayer != null)
            dispose();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void dispose() {
        mediaPlayer.dispose();
    }

    public  MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public MediaQueue getMediaQueue() {
        return mediaQueue;
    }
}
