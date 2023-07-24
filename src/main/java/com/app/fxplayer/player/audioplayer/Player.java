package com.app.fxplayer.player.audioplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public final class Player {
    private static MediaPlayer mediaPlayer = new MediaPlayer(new Media(new File(MediaQueue.getCurrentSong().getSource()).toURI().toASCIIString()));
    public static void play() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static void next() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getNextSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public static void prev() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getPrevSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    private static void checkMediaPlayer() {
        if (mediaPlayer != null)
            mediaPlayer.dispose();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void dispose() {
        mediaPlayer.dispose();
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}
