package com.app.fxplayer.models;

import javafx.concurrent.Task;

import java.io.File;

/**
 * SONG COLLECTOR
 */
public class Collector extends Task<Song> {

    private final File[] drives = {new File("C://"),new File("D://")};

    @Override
    protected Song call() {

        for (File drive: drives) {
            extract(drive);
        }
        return new Song();
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
                    System.out.println(f.getName());
                }
                else
                    System.out.println(f);
            }
        }
    }
}
