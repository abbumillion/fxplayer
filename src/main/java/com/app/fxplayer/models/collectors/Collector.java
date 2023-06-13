package com.app.fxplayer.models.collectors;

import com.app.fxplayer.models.models.Song;
import javafx.beans.InvalidationListener;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Map;

/**
 * SONG COLLECTOR
 */
public class Collector  implements Runnable{

    private static final File[] drives = {new File("C://"),new File("D://")};
    // song file collector
    private static final ListView<Song> fileListview = new ListView<>();

    /**
     *
     */
    public  void init() {

        for (File drive: drives) {
            extract(drive);
        }
    }

    /**
     *
     * @param file
     */
    private  void extract(File file)
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files)
            {
                // if it's directory
                if (f.isDirectory()) {
                    // extract it again
                    extract(f);
                }
                else if (f.isFile()) {
                    /**
                     * THIS IS A FILE
                     * SO WE NEED TO FILTER
                     * FOR MP3/MP4 FILES
                     * BY FILE TYPE
                     */
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".mp4"))
                    {
                        try {
                            //
                            fileListview.getItems().add(new Song(path));
                            songMaker(path);
                            //
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
            Media media = new Media(new File(path).toURI().toASCIIString());
            media.getMetadata().addListener((InvalidationListener) observable -> {
                if (observable != null) {
                   // Map<String, String> map = checkMetadata((Map) observable);
                    System.out.println(observable);
                  //  System.out.println(" 1.title  : -->" + map.get("title"));
                 //   System.out.println(" 2.artist : -->" + map.get("artist"));
                //    System.out.println(" 3.album  : -->" + map.get("album"));
//                System.out.println(" 4.image  : -->"+ (Image)map.get("image").toString());
                }
            });
        }
    }

    /**
     *
     * @param map
     * method for checking media metadata
     * for creating song,album,artist
     */
    private  Map<String,String> checkMetadata(Map<String, String> map) {
        // if the metadata value for a key is absent put a new
        // unknown value and default song and album image
        // title value absent
        map.putIfAbsent("title", "unknown");
        // artist value absent
        map.putIfAbsent("artist", "unknown");
        // album value absent
        map.putIfAbsent("album", "unknown");
        // year value absent
        map.putIfAbsent("year", "unknown");
        // image value absent
        map.putIfAbsent("image", "unknown");
        // return the map to it's caller
        return map;
    }

    /**
     *
     * @return list view of songs but not useful here
     */
    public static ListView<Song> getFileListview() {
        return fileListview;
    }

    /**
     * run the thread
     */
    @Override
    public void run() {
        // initialize the method
        init();
    }
}
