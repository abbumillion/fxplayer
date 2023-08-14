package com.app.fxplayer.modelgenerator;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;


public final class Generator {
    public static void generateSong(String path) {
        Song song = new Song(path);
        SongRepository.getSongList().add(song);
    }
}
