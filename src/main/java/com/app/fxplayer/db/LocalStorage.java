package com.app.fxplayer.db;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import javafx.collections.FXCollections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.*;
import java.util.List;

@Data
@Builder
public class LocalStorage {
    private static final File settingsFile = new File("settings.txt");
    private static final File songsFile = new File("songs.obf");
    private static final File albumsFile = new File("songs.obf");
    private static final File artistsFile = new File("songs.obf");
    private static final File playlistsFile = new File("songs.obf");
    private static final File favoritesFile = new File("songs.obf");
    // method for saving app settings
    public static void saveAppSettings(Settings settings) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(songsFile)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(settings);
                System.out.println("writing app settings");
            }
        }
    }
// method for  getting app settings
    public static Settings getAppSettings() throws FileNotFoundException {
        Settings settings;
        try(FileInputStream fileInputStream = new FileInputStream(settingsFile)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                settings = (Settings) objectInputStream.readObject();
                System.out.println("reading settings file");
                System.out.println(settings.getTotalSongs());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return settings;
    }

    // saving songs file
    public static void saveSongList() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(songsFile)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                for(Song song : SongRepository.getSongList())
                {
                    objectOutputStream.writeObject(song.getSource());
                }
            }
        }
    }

    // method for reading songs from file
    public static List<Song> getSongList()  {
        List<Song> songsList = FXCollections.observableArrayList();
        try(FileInputStream fileInputStream = new FileInputStream(songsFile)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                int totalSongs  = getAppSettings().getTotalSongs();
                for (int i = 0; i < totalSongs; i++) {
                    String source = (String) objectInputStream.readObject();
                    Song song = new Song(source);
                    songsList.add(song);
                    System.out.println("reading songs from file");
                    System.out.println(song);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return songsList;
    }

    // saving albums

    public static void saveAlbums()
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(albumsFile))
        {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                for (Album album : SongRepository.getAlbumList())
                {
                    objectOutputStream.writeObject(album);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // saving artists
    public static void saveArtists()
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(albumsFile))
        {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                for (Album album : SongRepository.getAlbumList())
                {
                    objectOutputStream.writeObject(album);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // saving playlists
    public static void savePlaylists()
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(albumsFile))
        {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                for (Album album : SongRepository.getAlbumList())
                {
                    objectOutputStream.writeObject(album);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // saving favorites
    public static void saveFavorites()
    {
        try(FileOutputStream fileOutputStream = new FileOutputStream(albumsFile))
        {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                for (Album album : SongRepository.getAlbumList())
                {
                    objectOutputStream.writeObject(album);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getAlbumsFile() {
        return albumsFile;
    }

    public static File getArtistsFile() {
        return artistsFile;
    }

    public static File getFavoritesFile() {
        return favoritesFile;
    }

    public static File getPlaylistsFile() {
        return playlistsFile;
    }

    public static File getSettingsFile() {
        return settingsFile;
    }

    public static File getSongsFile() {
        return songsFile;
    }

}
