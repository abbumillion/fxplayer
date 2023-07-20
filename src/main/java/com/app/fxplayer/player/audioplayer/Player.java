package com.app.fxplayer.player.audioplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Player implements AudioPlayer{
    private  MediaPlayer mediaPlayer;

    @Override
    public void play() {
        //
        checkMediaPlayer();
        File file = new File(MediaQueue.getCurrent().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        //
    }


    @Override
    public void next() {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(new Media(MediaQueue.getCurrent().getSource()));
        mediaPlayer.play();
    }

    @Override
    public void prev() {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(new Media(MediaQueue.getCurrent().getSource()));
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


}
