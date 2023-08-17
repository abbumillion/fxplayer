package com.app.fxplayer.models;

import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Playlist {
    private String playlistName;
    private Date createdDate;
    private ObservableList<Song> songObservableList;
}
