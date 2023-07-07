package com.app.fxplayer.application.config;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.collections.ObservableList;

public class ApplicationData {
    private ObservableList<Song> songList;
    private ObservableList<Album> albumList;
    private ObservableList<Artist> artistList;
    private ObservableList<Playlist> playlistList;
    public ObservableList<Album> getAlbumList() {
        return albumList;
    }
    public ObservableList<Song> getSongList() {
        return songList;
    }
    public ObservableList<Artist> getArtistList() {
        return artistList;
    }
    public ObservableList<Playlist> getPlaylistList() {
        return playlistList;
    }
}
