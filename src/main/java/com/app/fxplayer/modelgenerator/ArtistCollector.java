package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Song;
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
public class ArtistCollector extends Task<Artist> {
    private File dir;

    @Override
    public Artist call() {
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
//                        SongRepository.getArtistList().
                    }
                }
            }
        }
    }
}
