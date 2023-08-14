package com.app.fxplayer.models;

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
public class Album {
    private String name;
    private String artist;
    private String copyrightYear;
    private String copyrightOwner;
    private ObservableList<Song> songs;
    private Image albumImage;

}
