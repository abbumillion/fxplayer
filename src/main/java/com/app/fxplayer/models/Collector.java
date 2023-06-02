package com.app.fxplayer.models;

import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.io.File;

/**
 * SONG COLLECTOR
 */
public class Collector  {

    private static final File[] drives = {new File("C://"),new File("D://")};
    // song file collector
    private static final ListView fileListview = new ListView();

    public static void init() {

        for (File drive: drives) {
            extract(drive);
        }
    }
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
                        fileListview.getItems().add(path);
//                        System.out.println(f.getName());
                    }
                }
            }
        }
    }

    public static ListView getFileListview() {
        return fileListview;
    }
}
