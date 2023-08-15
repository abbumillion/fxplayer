package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Collector extends Service<Song> {
    private LoaderView loaderView;
    private  final File[] DRIVES = {new File("C://"), new File("D://")};

    private void extract(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    extract(f);
                } else if (f.isFile()) {
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".MP3")) {
                            generateSong(path);
                    }
                }
            }
        }
    }



    @Override
    protected Task<Song> createTask() {
        for (File f : DRIVES) {
            extract(f);
        }
        setOnSucceeded(Event -> {
            loaderView.hideView();
            PlayerViewController playerViewController = new PlayerViewController(new PlayerView());
            try {
                playerViewController.init();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        return null;
    }
    public  void generateSong(String path) {
        Song song = new Song(path);
        SongRepository.getSongList().add(song);
    }
    private  void addSongToAlbumsRepo(Song song) {
        for (Album album : SongRepository.getAlbumList())
        {
            if (!album.getName().equals(song.getAlbum())) {
                Album newAlbum = new Album();
                newAlbum.setName(song.getAlbum());
                newAlbum.setArtist(song.getArtist());
                SongRepository.getAlbumList().add(newAlbum);
            }
            break;
        }
    }
}
