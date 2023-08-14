package com.app.fxplayer.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalStorage  {
    private File settingsFile = new File("settings.txt");
    private File songsFile = new File("songs.txt");
    private File albumsFile = new File("albums.txt");
    private File artistsFile = new File("artists.txt");
    private File playlistsFile = new File("playlists.txt");
    private File favoritesFile = new File("favorites.txt");
    public void saveAppSettings(){}
    public void getAppState(){}
    public void saveAppState(){}
}
