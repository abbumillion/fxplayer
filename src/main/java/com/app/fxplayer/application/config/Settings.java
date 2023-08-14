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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settings {
    private String theme = "src/main/resources/stylesheets/dark.css";;
    private String font;
    private String tabSide;
    private String stageStyle;
    private boolean isFirstTime;
    private boolean isFullScreen;
    private List<Song> songList;
    private List<Playlist> playlists;
    private List<Song> favoriteSongs;
    private List<Album> albumList;
    private List<Artist> artistList;
}
