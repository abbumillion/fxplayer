package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

public final class SongRepository {
    @Getter
    private static final ObservableList<Song> songList = FXCollections.observableArrayList();
    @Getter
    private static final ObservableList<Artist> artistList = FXCollections.observableArrayList();
    @Getter
    private static final ObservableList<Album> albumList = FXCollections.observableArrayList();
    @Getter
    private static final ObservableList<Playlist> playlistList = FXCollections.observableArrayList();
}
