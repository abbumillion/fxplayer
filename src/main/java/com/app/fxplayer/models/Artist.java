package com.app.fxplayer.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist {
    private String artistName = "Artist Name";
    private Image artistImage;
    private ObservableList<Album> albums = FXCollections.observableArrayList();
}
