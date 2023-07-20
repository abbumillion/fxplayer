package com.app.fxplayer.modelgenerator;

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
            ModelRepository.addSong(new Song(title,album,artist,year,image,source));
        });
        return null;
    }
}
