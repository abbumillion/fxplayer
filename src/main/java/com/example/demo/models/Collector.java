package com.example.demo.models;

import javafx.concurrent.Task;

import java.io.File;

public class Collector extends Task<Song> {
    private final File drive;
    public Collector(File file)
    {
        this.drive = file;
    }
    @Override
    protected Song call() throws Exception {
            extract(drive);
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
//                else if (f.isFile()) {
////                    System.out.println(f.getName());
//                }
//                else
//                    System.out.println(f);
            }
        }
    }
}
