package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public  class FileCollector implements Runnable{
    private File dir;
    @Override
    public void run() {
            extract(dir);
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
                        SongRepository.addSongToAlbums(song);
                    }
                }
            }
        }
    }

}
