package com.app.fxplayer.application.config;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Artist;
import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.models.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AppData {
    private List<Song> songList;
    private List<Playlist> playlists;
    private List<Song> favoriteSongs;
    private List<Album> albumList;
    private List<Artist> artistList;
    private Song lastSong;
    private double lastStoppedDuration;
}
