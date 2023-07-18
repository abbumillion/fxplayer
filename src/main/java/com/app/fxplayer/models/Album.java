package com.app.fxplayer.models;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;

public class Album {
    private String name ;
    private String artist;
    private String copyrightYear;
    private String copyrightOwner;
    private ObservableList<Song> songs;
    private Image albumImage;
    public Album(Song song)
    {
        //
        name = song.getAlbum();
        artist = song.getArtist();
        songs.add(song);
        albumImage = song.getImage();
        //
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public Image getAlbumImage() {
        return albumImage;
    }

    public ObservableList<Song> getSongs() {
        return songs;
    }

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }
}
