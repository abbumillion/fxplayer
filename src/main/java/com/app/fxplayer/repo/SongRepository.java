package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class SongRepository {
    private static ObservableList<Song> songList = FXCollections.observableArrayList();
    private static ObservableList<Artist> artistList = FXCollections.observableArrayList();
    private static ObservableList<Album> albumList = FXCollections.observableArrayList();
    private static ObservableList<Playlist> playlistList = FXCollections.observableArrayList();

    public static ObservableList<Song> getSongList() {
        return songList;
    }

    public static ObservableList<Song> getRecentPlaysSongList() {
        List<Song> songs = songList.stream()
                .sorted(Comparator.comparing(i -> i.getLastPlayedDate()))
                .collect(Collectors.toList());
        ObservableList<Song> songObservableList = FXCollections.observableArrayList(songs);
        return songObservableList;
    }


    public static ObservableList<Song> getRecentAddedSongList() {
        List<Song> songs = songList.stream()
                .sorted(Comparator.comparing(i -> i.getAddedDate()))
                .collect(Collectors.toList());
        ObservableList<Song> songObservableList = FXCollections.observableArrayList(songs);
        return songObservableList;
    }

    public static ObservableList<Song> getMostPlayedSongList() {
        List<Song> songs = songList.stream()
                .sorted(Comparator.comparing(i -> i.getNumberOfPlays()))
                .collect(Collectors.toList());
        ObservableList<Song> songObservableList = FXCollections.observableArrayList(songs);
        return songObservableList;
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
