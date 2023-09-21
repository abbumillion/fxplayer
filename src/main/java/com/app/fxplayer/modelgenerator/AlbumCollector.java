package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlbumCollector extends Task<Album> {
    private File dir;
    @Override
    public Album call() {
        extract(dir);
        return null;
    }
    private void extract(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    extract(f);
                } else if (f.isFile()) {
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".MP3")) {
                        Song song = new Song(path);
                        addToAlbums(song);
                    }
                }
            }
        }
    }

    private void addToAlbums(Song song) {
        // check for album
        // by iterating through the albums list
        Album newAlbum;
        if (SongRepository.getAlbumList().isEmpty()) {
            //
            newAlbum = new Album();
            addAlbum(song, newAlbum);
            System.out.println("Add the first Album");
            //
        } else {
            for (Album album : SongRepository.getAlbumList()) {
                // if the album exists
                if (album.getAlbumName().equalsIgnoreCase(song.getAlbum())) {
                    System.out.println("album exists");
                    album.getAlbumSongs().add(song);
                    System.out.println("Album Added With Name : " + song.getAlbum() + " to Album : " + album.getAlbumName());
                    break;
                }
                // if not
                else {
                    newAlbum = new Album();
                    addAlbum(song, newAlbum);
                    System.out.println("Add New Album");
                }
            }
        }
    }

    private void addAlbum(Song song, Album album) {
        album.setAlbumName(song.getAlbum());
        album.setAlbumImage(song.getSongImage());
        album.setCopyrightYear(song.getYear());
        album.setArtistName(song.getArtist());
        SongRepository.getAlbumList().add(album);
        System.out.println("ALBUM INFORMATION");
        System.out.println("ALBUM NAME       : " + album.getAlbumName());
        System.out.println("ALBUM ARTIST     : " + album.getArtistName());
        System.out.println("ALBUM YEAR       : " + album.getCopyrightYear());
        System.out.println("ALBUM SONGS SIZE : " + album.getAlbumSongs().size());
//        System.out.println("ALBUM INFORMATION");
    }
}
