package com.app.fxplayer.models.models;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

/**
 * ALBUM DATA CLASS
 */
public class Album {
    // albums name
    private StringProperty name;
    // artists name
    private StringProperty artist;
    // copy right year
    private StringProperty copyrightYear;
    // copy right owner
    private StringProperty copyrightOwner;
    // song list
    private ObservableList<Song> songs;
    // album image
    private Image albumImage;
}
