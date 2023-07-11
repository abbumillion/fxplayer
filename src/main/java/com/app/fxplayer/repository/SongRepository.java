package com.app.fxplayer.repository;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    private static ListView<Song>  songList = new ListView<>();;
    private static ListView<Album> albumList = new ListView<>();;

    public SongRepository()
    {


    }

    public static ListView<Song> getSongList() {
        return songList;
    }

    public static ListView<Album> getAlbumList() {
        return albumList;
    }
}
