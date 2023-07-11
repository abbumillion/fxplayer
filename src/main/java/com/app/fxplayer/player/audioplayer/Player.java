package com.app.fxplayer.player.audioplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Player implements AudioPlayer{
    private  MediaPlayer mediaPlayer;

    @Override
    public void play(Media media) {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    @Override
    public void pause() {
        if (mediaPlayer != null)
            mediaPlayer.pause();
    }


    @Override
    public void next(Media media) {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private void checkMediaPlayer() {
        if (mediaPlayer != null)
            dispose();
    }


    @Override
    public void prev(Media media) {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }


    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void dispose() {
        mediaPlayer.dispose();
    }

    @Override
    public void forward(Duration duration) {

    }


    @Override
    public void backward(Duration duration) {

    }

    public  MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
