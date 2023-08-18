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
    private String albumName;
    private String artistName;
    private String copyrightYear;
    private String copyrightOwner;
    private Image albumImage;
    private ObservableList<Song> albumSongs;
}
