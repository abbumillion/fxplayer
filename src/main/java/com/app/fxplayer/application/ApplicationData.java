package com.app.fxplayer.application;

import com.app.fxplayer.models.models.Album;
import com.app.fxplayer.models.models.Artist;
import com.app.fxplayer.models.models.Playlist;
import com.app.fxplayer.models.models.Song;
import javafx.collections.ObservableList;

/**
 * APPLICATION DATA STORING CLASS
 * LIKE MUSIC LIST,PLAYLISTS,ALBUMS,ARTISTS,
 * MOST PLAYED,RECENTLY PLAYED,RECENTLY ADDED
 */
public class ApplicationData {
    /**
     * songs list
     */
    private ObservableList<Song> songList;
    /**
     * albums list
     */
    private ObservableList<Album> albumList;
    /**
     * artists list
     */
    private ObservableList<Artist> artistList;
    /**
     * playlists list
     */
    private ObservableList<Playlist> playlistList;

    /**
     *
     * @return albums
     */
    public ObservableList<Album> getAlbumList() {
        return albumList;
    }

    /**
     *
     * @return songs
     */
    public ObservableList<Song> getSongList() {
        return songList;
    }

    /**
     *
     * @return artists
     */
    public ObservableList<Artist> getArtistList() {
        return artistList;
    }

    /**
     *
     * @return playlists
     */
    public ObservableList<Playlist> getPlaylistList() {
        return playlistList;
    }
}
