package com.app.fxplayer.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.util.Duration;
import java.io.File;
import java.util.Map;

/**
 * SONG DATA CLASS
 */
public class Song {
    // song file source
    private StringProperty source = new SimpleStringProperty("");
    // song title
    private StringProperty title = new SimpleStringProperty("");;
    // song artist
    private StringProperty artist = new SimpleStringProperty("");;
    // song album
    private StringProperty album = new SimpleStringProperty("");;
    // year
    private StringProperty year = new SimpleStringProperty("");;
    // song duration
    private Duration duration;
    //  song image
    private Image image;
    // track number
    private int trackNumber;

    /**
     *
     * @param source
     */
    public Song(String source)
    {
        this.source.setValue(source);
        process(source);
    }

    /**
     *
     * @param source
     */
    private void process(String source)
    {
        File file = new File(source);
        Media media = new Media(file.toURI().toASCIIString());

    }

    /**
     *
     * @param map
     * checking the metadata
     * before storing
     */


    public String getSource() {
        return source.get();
    }

    /**
     *
     * @return duration
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     *
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @return artist
     */
    public String getArtist() {
        return artist.get();
    }

    /**
     *
     * @return
     */
    public int getTrackNumber() {
        return trackNumber;
    }

    public String getAlbum() {
        return album.get();
    }

    public String getTitle() {
        return title.get();
    }
}
