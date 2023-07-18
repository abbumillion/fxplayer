package com.app.fxplayer.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Artist {
    private String artistName = "Artist Name";
    private ObservableList<Album> albums = FXCollections.observableArrayList();

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public ObservableList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ObservableList<Album> albums) {
        this.albums = albums;
    }
}
