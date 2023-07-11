package com.app.fxplayer.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
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
    private  StringProperty source = new SimpleStringProperty("source");
    // song title
    private  StringProperty title = new SimpleStringProperty("title");
    // song artist
    private  StringProperty artist = new SimpleStringProperty("artist");
    // song album
    private  StringProperty album = new SimpleStringProperty("album");
    // year
    private  StringProperty year = new SimpleStringProperty("year");
    //
    private StringProperty size = new SimpleStringProperty("size");
    // song genre
    private Genre genre;
    // song duration
    private Duration duration = new Duration(0.0);
    //  song image
    private Image image = new Image(new File("src/main/resources/images/song.png").toURI().toASCIIString());
    // track number
    private int trackNumber = 0;

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

        media.getMetadata().addListener((InvalidationListener) observable ->
        {
            //
            Map map = (Map) observable;
            if (!map.isEmpty()) {
                //
                title.setValue((String) map.get("title"));
                album.setValue((String) map.get("album"));
                artist.setValue((String) map.get("artist"));
                year.setValue((Integer) map.get("year") + "");
                image = (Image) map.get("image");
                size.setValue(file.getFreeSpace() + "MB");
//                //
//                System.out.println(title);
//                System.out.println(album);
//                System.out.println(artist);
//                System.out.println(year);
                //
            }
        });
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

    public String getSize() {
        return size.get();
    }

    public String getYear() {
        return year.get();
    }
}
