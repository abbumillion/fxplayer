package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import javafx.concurrent.Task;
import lombok.*;

import java.io.File;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileCollector extends Task<Song> {
    private File dir;
    @Override
    public Song call() {
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
                        SongRepository.getSongList().add(song);
                        // add the song to album
                        updateMessage(song.getTitle());
                    }
                }
            }
        }
    }

}
