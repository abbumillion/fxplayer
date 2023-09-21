package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class SongRepository {
    private static final ObservableList<Song> songList = FXCollections.observableArrayList();
    private static final ObservableList<Artist> artistList = FXCollections.observableArrayList();
    private static final ObservableList<Album> albumList = FXCollections.observableArrayList();
    private static final ObservableList<Playlist> playlistList = FXCollections.observableArrayList();
    public static  ObservableList<Song> getSongList() {
        return songList;
    }
    public static ObservableList<Playlist> getPlaylistList() {
        return playlistList;
    }

    public static ObservableList<Album> getAlbumList() {
        return albumList;
    }

    public static ObservableList<Artist> getArtistList() {
        return artistList;
    }
}
