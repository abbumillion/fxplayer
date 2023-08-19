package com.app.fxplayer.repo;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Objects;
public final class SongRepository {
    private static ObservableList<Song> songList = FXCollections.observableArrayList();
    private static ObservableList<Artist> artistList = FXCollections.observableArrayList();
    private static ObservableList<Album> albumList = FXCollections.observableArrayList();
    private static ObservableList<Playlist> playlistList = FXCollections.observableArrayList();
    public static synchronized ObservableList<Song> getSongList() {
        return songList;
    }

    public static void addSongToAlbums(Song song)
    {
        if (getAlbumList().isEmpty())
        {
            createAlbum(song);
        }
        else {
            for (Album album : getAlbumList()) {
                if (Objects.equals(album.getAlbumName(), song.getAlbum())) {
                    album.getAlbumSongs().add(song);
                } else {
                    createAlbum(song);
                }
            }
        }
    }

    private static void createAlbum(Song song) {
        Album newAlbum = new Album();
        newAlbum.setAlbumImage(song.getSongImage());
        newAlbum.setAlbumName(song.getAlbum());
        newAlbum.setArtistName(song.getArtist());
        newAlbum.setCopyrightYear(song.getYear());
        newAlbum.getAlbumSongs().add(song);
        getAlbumList().add(newAlbum);
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
//    public static void addSongToAlbums(Song song)
//    {
//        if (albumList.isEmpty())
//        {}
//        else {
//            for (int i = 0 ; i < albumList.size() ; i++)
//            {
//                Album album = albumList.get(i);
//                // check if the song album already exists
//                if (album.getAlbumName() == song.getAlbum())
//                {
//                    // album found just add the song to this album
//                    System.out.println("Album Found");
//                }else {
//                    // we have no album for this song
//                    // create new album object and add the song to it
//                    // finally add the new album to albums list
//
//                }
//            }
//        }
//    }
//    public static ObservableList<Song> getRecentAddedSongList() {
//        List<Song> songs = songList.stream()
//                .sorted(Comparator.comparing(i -> i.getAddedDate()))
//                .collect(Collectors.toList());
//        ObservableList<Song> songObservableList = FXCollections.observableArrayList(songs);
//        return songObservableList;
//    }
//
//    public static ObservableList<Song> getMostPlayedSongList() {
//        List<Song> songs = songList.stream()
//                .sorted(Comparator.comparing(i -> i.getNumberOfPlays()))
//                .collect(Collectors.toList());
//        ObservableList<Song> songObservableList = FXCollections.observableArrayList(songs);
//        return songObservableList;
//    }

//    public static ObservableList<Song> getRecentPlaysSongList() {
//        List<Song> songs = getSongList().stream()
//                .sorted(Comparator.comparing(Song::getLastPlayedDate))
//                .collect(Collectors.toList());
//        return FXCollections.observableArrayList(songs);
//    }