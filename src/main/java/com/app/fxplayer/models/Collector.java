package com.app.fxplayer.models;

import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.io.File;

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
    public static void init() {

        for (File drive: drives) {
            extract(drive);
        }
    }

    /**
     *
     * @param file
     */
    private static void extract(File file)
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files)
            {
                if (f.isDirectory()) {
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
                            Song song = new Song(path);
                            fileListview.getItems().add(song);
                        }catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public static ListView<Song> getFileListview() {
        return fileListview;
    }

    @Override
    public void run() {
        init();
    }
}
