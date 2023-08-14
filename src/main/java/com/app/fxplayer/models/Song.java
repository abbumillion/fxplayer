package com.app.fxplayer.models;

import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.util.Duration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {
    private Image image;
    private String source = "source";
    private String title = "title";
    private String artist = "artist";
    private String album = "album";
    private String year = "year";
    private String size = "size";
    private String genre;
    private Duration duration;
    private int numberOfPlays;
    private Date addedDate;
    private Date lastPlayedDate;

    public Song(String path) {
        Media media = new Media(new File(path).toURI().toASCIIString());
        media.getMetadata().addListener((InvalidationListener) observable ->
        {
            this.title = (String) ((Map<?, ?>) observable).get("title");
            this.artist = (String) ((Map<?, ?>) observable).get("album");
            this.album = (String) ((Map<?, ?>) observable).get("artist");
            this.genre = (String) ((Map<?, ?>) observable).get("genre");
            this.year = String.valueOf(((Map<?, ?>) observable).get("year"));
            this.source = path;
            this.image = (Image) ((Map<?, ?>) observable).get("image");
            size = new File(path).length() / (1024 * 1024) + "MB";
            addedDate = new Date();
        });
    }


}
