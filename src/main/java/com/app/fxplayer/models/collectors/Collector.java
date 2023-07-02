package com.app.fxplayer.models.collectors;

import com.app.fxplayer.models.models.Album;
import com.app.fxplayer.models.models.Artist;
import com.app.fxplayer.models.models.Playlist;
import com.app.fxplayer.models.models.Song;
import javafx.beans.InvalidationListener;
import javafx.concurrent.Task;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SONG COLLECTOR
 */
public class Collector  extends Task<Song> {
    private static final File[] drives = {new File("C://"),new File("D://")};
    private   ListView<Song> songListView ;
    private   ListView<Playlist> playlistListView;
    private   ListView<Artist> artistListView;
    private   ListView<Album> albumListView;

    public  void init() {
        System.out.println("collector initialized");
        songListView = new ListView<>();
        artistListView = new ListView<>();
        albumListView = new ListView<>();
        playlistListView = new ListView<>();
        // collecting files start here
        for (File drive: drives) {
            extract(drive);
        }
        //
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
                            songMaker(path);
                        }catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private  void songMaker(String path) {
        if (!path.isEmpty())
        {
            Song song = new Song(checkPath(path));


//            Media media = new Media(new File(path).toURI().toASCIIString());
//            media.getMetadata().addListener((InvalidationListener) observable -> {
//                if (observable != null) {
//                    Map<String, String> map = checkMetadata((Map) observable);
//                    System.out.println(" 1.title  : -->" + map.get("title"));
//                    System.out.println(" 2.artist : -->" + map.get("artist"));
//                    System.out.println(" 3.album  : -->" + map.get("album"));
//                }
//            });
        }
    }

    private String checkPath(String path) {
        // check the correctness of the path here
        return path;
    }

    private  Map<String,String> checkMetadata(Map<String, String> map) {
        return map;
    }

    @Override
    protected Song call() {
        init();
        return null;
    }
}
