package com.app.fxplayer.models;

import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.io.File;

public class Collector  extends Task<Song> {
    private static final File[] drives = {new File("C://"),new File("D://")};
    private static  ListView<Song> songListView = new ListView<>() ;
    private static  ListView<Playlist> playlistListView = new ListView<>();
    private static  ListView<Artist> artistListView = new ListView<>();
    private static  ListView<Album> albumListView = new ListView<>();

    public  void init() {
        System.out.println("collector initialized");
        songListView = new ListView<>();
        artistListView = new ListView<>();
        albumListView = new ListView<>();
        playlistListView = new ListView<>();
        for (File drive: drives) {
            extract(drive);
        }
    }

    private  void extract(File file)
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files)
            {
                if (f.isDirectory()) {
                    extract(f);
                }
                else if (f.isFile()) {
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".mp4"))
                    {
                        try {
                            songListView.getItems().add(new Song(path));
                        }catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override
    protected Song call() {
        init();
        return null;
    }

    public static ListView<Song> getSongListView() {
        return songListView;
    }

    public static ListView<Artist> getArtistListView() {
        return artistListView;
    }

    public static ListView<Album> getAlbumListView() {
        return albumListView;
    }

    public static ListView<Playlist> getPlaylistListView() {
        return playlistListView;
    }
}
