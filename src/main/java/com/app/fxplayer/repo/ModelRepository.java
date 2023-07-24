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
    // artist collections
    private static final ListView<Artist> artistList = new ListView<>();
    // album collections
    private static final ListView<Album> albumList = new ListView<>();
    // playlist collections
    private static final ListView<Playlist> playlistList = new ListView<>();
    // most played songs collection
    private static final ListView<Song> mostPlayed = new ListView<>();
    // recently played songs collections
    private static final ListView<Song> recentlyPlayed = new ListView<>();
    // for initializing the
    // repository events
//    public void init()
//    {
//        songList.getSelectionModel().selectedItemProperty().addListener((observableValue, song, t1) ->
//        {
//            //
//            if ()
//            //
//        });
//    }
    public static boolean addSong(Song song)
    {
        boolean value = false;
        if (!songList.getItems().contains(song))
        {
            // adding song to song list
            songList.getItems().add(song);
            //adding song to album collections
            addToAlbum(song);
            // adding song to artist collections
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
            //
        }
        return value;
    }

    private static void addToArtist(Song song) {
        //
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
