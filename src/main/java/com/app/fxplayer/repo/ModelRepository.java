package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import javafx.scene.control.ListView;

public class ModelRepository {
    private static ListView songList = new ListView<>();
    private static ListView artistList = new ListView<>();
    private static ListView albumList = new ListView<>();
    private static ListView playlistList = new ListView<>();
    private static ListView mostPlayed = new ListView<>();
    private static ListView recentlyPlayed = new ListView<>();

    public static boolean addSong(Song song)
    {
        boolean value = false;
        // check if the song exists
        if (!songList.getItems().contains(song))
        {
            // add to the song list
            songList.getItems().add(song);
            // add to the albums

            for (Object alb : albumList.getItems())
            {
                Album album = (Album) alb;
                if (album.getName() == song.getAlbum())
                {
                    // album found
                    // add song to rhe album
                    System.out.println("album exists add to song to the album");
                    album.getSongs().add(song);
                }
                else
                {
                    // album not exist
                    // so create new album
                    // add to the list
                    Album newAlbum = new Album(song);
                    System.out.println("new album created");
                    albumList.getItems().add(newAlbum);
                    //
                }
            }
        }
        return value;
    }

    public static ListView getAlbumList() {
        return albumList;
    }

    public static ListView getArtistList() {
        return artistList;
    }

    public static ListView getPlaylistList() {
        return playlistList;
    }

    public static ListView getSongList() {
        return songList;
    }
}
