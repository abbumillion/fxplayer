package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.scene.control.ListView;

import java.util.Objects;

/**
 * THIS IS OUR APPS DATA MODEL
 * HOLDER AND DIRECT RELATION WITH
 * THE PLAYER
 */
public final class ModelRepository {
    private static final ListView<Song> songList = new ListView<>();
    private static final ListView<Artist> artistList = new ListView<>();
    private static final ListView<Album> albumList = new ListView<>();
    private static final ListView<Playlist> playlistList = new ListView<>();
    private static final ListView<Song> mostPlayed = new ListView<>();
    private static final ListView<Song> recentlyPlayed = new ListView<>();
    public static boolean addSong(Song song)
    {
        boolean value = false;
        if (!songList.getItems().contains(song))
        {
            songList.getItems().add(song);
            addToAlbum(song);
            addToArtist(song);
            if(albumList.getItems().isEmpty()) {
                for (Album alb : albumList.getItems()) {
                    Album album = alb;
                    if (Objects.equals(album.getName(), song.getAlbum())) {
                        System.out.println("album found here please add the song to the album");
                        album.getSongs().add(song);
                    } else {
                        System.out.println("album does exist so create a new \n and add the song to the album");
                        Album newAlbum = new Album(song);
                        albumList.getItems().add(newAlbum);
                    }
                }
            }
        }
        return value;
    }

    private static void addToArtist(Song song) {
//        checkForDuplicateSongs(song);
    }

    private static void addToAlbum(Song song) {
    }

    public static ListView<Album> getAlbumList() {
        return albumList;
    }

    public static ListView<Artist> getArtistList() {
        return artistList;
    }

    public static ListView<Playlist> getPlaylistList() {
        return playlistList;
    }

    public static ListView<Song> getSongList() {
        return songList;
    }
}
