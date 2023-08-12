package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.ModelRepository;
import javafx.beans.InvalidationListener;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Map;

public final class Generator {
    public  static void   generateSong(String path)
    {
        Media media = new Media(new File(path).toURI().toASCIIString());
        media.getMetadata().addListener((InvalidationListener) observable ->
        {
//            System.out.println("Adding : "+observable);
            ModelRepository.addSong(new Song((String) ((Map<?, ?>) observable).get("title"), (String) ((Map<?, ?>) observable).get("album"),
                    (String) ((Map<?, ?>) observable).get("artist"),
                    String.valueOf(((Map<?, ?>) observable).get("year")),
                    (Image) ((Map<?, ?>) observable).get("image"), path));
        });
    }
}
enum FileType{
    MP3,
    M4A,
    MKV,
}
