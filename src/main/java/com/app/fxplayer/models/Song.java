package com.app.fxplayer.models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.io.File;

public class Song {
    private  String source = "source";
    private  String title = "title";
    private  String artist = "artist";
    private  String album = "album";
    private  String year = "year";
    private String size = "size";
    private  Genre genre;
    private  Duration duration;
    private final ImageView image ;

    public Song(String title,String album,String artist,String year,Image image,String path)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.source = path;
        this.image = new ImageView(image);
        size = new File(path).length() / (1024 * 1024) + "MB";
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    public String getSize() {
        return size;
    }

    public Genre getGenre() {
        return genre;
    }

    public Duration getDuration() {
        return duration;
    }

    public ImageView getImage() {
        return image;
    }
}
