package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.ModelRepository;
import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Map;

public final class Generator {
    public static Song generateSong(String path)
    {
        Media media = new Media(new File(path).toURI().toASCIIString());
        media.getMetadata().addListener((InvalidationListener) observable ->
        {
            String title,album,artist,year,source;
            Image image;
            Map map = (Map) observable;
            title = (String) map.get("title");
            album = (String) map.get("artist");
            artist = (String) map.get("album");
            year = map.get("year") + "";
            image = (Image) map.get("image");
            source = path;
            addSongToRepository(title,album,artist,year,image,source);
        });
        return null;
    }

    private static void addSongToRepository(String title,String album,String artist,String year,Image image,String path) {
        Song song = new Song(title,album,artist,year,image,path);
        ModelRepository.getSongList().getItems().add(song);
        checkAlbum(song);
        checkArtist(song);
    }

    private static void checkAlbum(Song song) {
        for (Object obj : ModelRepository.getAlbumList().getItems())
        {
            Album album = (Album) obj;
            if (album.getName() == song.getAlbum())
            {
                //
                System.out.println("album found here");
                //
            }
            else {
                // album doesn't exist
                // so create a new one
                //
                Album newAlbum = new Album(song);
            }
        }

    }

    private static void checkArtist(Song song) {
        for (Object obj : ModelRepository.getArtistList().getItems())
        {
            //
            System.out.println("artist found here");
            //
        }
    }
}
