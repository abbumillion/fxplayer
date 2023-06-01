package com.app.fxplayer.models;

//import javafx.scene.media.Media;
import javafx.util.Duration;

import java.io.File;

/**
 * SONG DATA CLASS
 */
public class Song {
    // song file source
    private String source;
    // song title
    private String title;
    // song artist
    private String artist;
    // song album
    private String album;
    // song duration
    private Duration duration;
    public Song(String source)
    {
        this.source = source;
        process(source);
    }

    //
    private void process(String source)
    {
        File file = new File(source);
//        Media media = new Media(file.toURI().toASCIIString());
    }
}
