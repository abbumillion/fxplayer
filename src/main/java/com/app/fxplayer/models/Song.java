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
        media.getMetadata().addListener((InvalidationListener) observable -> {
            Map map = (Map) observable;
            System.out.println(map);
            if (map.isEmpty())
            {
                // non metadata
            }
            else
            {
                // collect metadata
                String title = map.get("title").toString();
                String year = map.get("year").toString();
                String album = map.get("album").toString();
                String artist = map.get("artist").toString();
                //
                Image image = (Image) map.get("image");
                //
                if (title != null)
                {
                    this.title .setValue(title);
                }
                if (year != null)
                {
//                    this.year = Integer.getInteger(year.toString());
                }
                if (image != null)
                {
                    this.image = (Image) image;
                }
                if (album != null)
                {
                    this.album.setValue(album);
                }
                if (artist != null)
                {
                    this.artist .setValue(artist);
                }
            }
        });
    }

    /**
     *
     * @return
     */
    public StringProperty getSource() {
        return source;
    }

    /**
     *
     * @return
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     *
     * @return
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @return
     */
    public StringProperty getArtist() {
        return artist;
    }

    /**
     *
     * @return
     */
    public int getTrackNumber() {
        return trackNumber;
    }

    /**
     *
     * @return
     */
    public StringProperty getAlbum() {
        return album;
    }

    /**
     *
     * @return
     */
    public StringProperty getTitle() {
        return title;
    }

}
