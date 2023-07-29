package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.ModelRepository;
import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Map;

public final class Generator {
    public synchronized static Song generateSong(String path)
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
            addToRepository(title,album,artist,year,image,source);
        });
        return null;
    }

    private static void addToRepository(String title, String album, String artist, String year, Image image, String source) {
        ModelRepository.addSong(new Song(title,album,artist,year,image,source));
    }
}
