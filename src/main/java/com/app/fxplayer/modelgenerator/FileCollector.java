package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.FileRepo;
import com.app.fxplayer.repo.SongRepository;
import lombok.Builder;
import lombok.Data;

import java.io.File;
@Data
@Builder
public  class FileCollector implements Runnable{
    private  final File[] DRIVES = {new File("C://"), new File("D://")};
    public FileCollector()
    {}
    @Override
    public void run() {
        for (File f : DRIVES) {
            extract(f);
        }
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
                    }
                }
            }
        }
    }

}
