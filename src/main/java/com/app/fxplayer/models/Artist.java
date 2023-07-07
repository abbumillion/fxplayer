package com.app.fxplayer.models;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * ARTISTS DATA CLASS
 */
public class Artist {
    // artist name
    private StringProperty artistName;
    // albums list
    private ObservableList<Album> albums;
}
