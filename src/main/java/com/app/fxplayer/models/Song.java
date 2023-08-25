package com.app.fxplayer.models;

import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song implements Serializable {
    private String source = "source";
    private String title = "title";
    private String artist = "artist";
    private String album = "album";
    private String year = "year";
    private String size = "size";
    private String genre;
    private int numberOfPlays;
    private Date addedDate;
    private Date lastPlayedDate;
    private Image songImage;
    private double duration;

    public Song(String path) {
        this.source = path;
        size = new File(path).length() / (1024 * 1024) + "MB";
        Media media = new Media(new File(path).toURI().toASCIIString());
        media.getMetadata().addListener((InvalidationListener) observable ->
        {
            this.title = (String) ((Map<?, ?>) observable).get("title");
            this.artist = (String) ((Map<?, ?>) observable).get("album");
            this.album = (String) ((Map<?, ?>) observable).get("artist");
            this.genre = (String) ((Map<?, ?>) observable).get("genre");
            this.songImage = (Image) ((Map<?, ?>) observable).get("image");
            this.year = String.valueOf(((Map<?, ?>) observable).get("year"));
            addedDate = new Date();
            lastPlayedDate = new Date();
        });
    }
}
