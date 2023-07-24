package com.app.fxplayer.viewModel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlbumViewModel {
    private StringProperty albumName = new SimpleStringProperty("Name");
    private StringProperty artist = new SimpleStringProperty("Artist");
    private StringProperty year = new SimpleStringProperty("Year");
    private StringProperty copyrightYear = new SimpleStringProperty("Copyright Year");
    private StringProperty copyrightOwner = new SimpleStringProperty("Copyright Owner");

    private ObservableList songViewModels = FXCollections.emptyObservableList();

    public String getAlbumName() {
        return albumName.get();
    }

    public StringProperty albumNameProperty() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName.set(albumName);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getCopyrightYear() {
        return copyrightYear.get();
    }

    public StringProperty copyrightYearProperty() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear.set(copyrightYear);
    }

    public String getCopyrightOwner() {
        return copyrightOwner.get();
    }

    public StringProperty copyrightOwnerProperty() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner.set(copyrightOwner);
    }

    public ObservableList getSongViewModels() {
        return songViewModels;
    }

    public void setSongViewModels(ObservableList songViewModels) {
        this.songViewModels = songViewModels;
    }
}
