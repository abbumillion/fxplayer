package com.app.fxplayer.player.audioplayer;


import javafx.scene.media.Media;
import javafx.util.Duration;

public  interface AudioPlayer {
    void play(Media media);
    void pause();
    void next(Media media);
    void prev(Media media);
    void stop();
    void dispose();
    void forward(Duration duration);
    void backward(Duration duration);

}
