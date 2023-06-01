package com.app.fxplayer.models;

import javafx.concurrent.Task;
import javafx.scene.control.ListView;

import java.io.File;

/**
 * SONG COLLECTOR
 */
public class Collector extends Task<Song> {

    private final File[] drives = {new File("C://"),new File("D://")};
    private ListView fileListview = new ListView();

    @Override
    protected Song call() {

        for (File drive: drives) {
            extract(drive);
        }
        return null;
    }
    private void extract(File file)
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files)
            {
                updateMessage(f.getName());
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
                        System.out.println(f.getName());
                    }
                }
            }
        }
    }

    public ListView getFileListview() {
        return fileListview;
    }
}
