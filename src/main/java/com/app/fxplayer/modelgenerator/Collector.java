package com.app.fxplayer.modelgenerator;

import javafx.concurrent.Task;

import java.io.File;

public class Collector extends Task<File> {
    private static final File[] drives = {new File("C://"), new File("D://")};

    private void extract(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    extract(f);
                } else if (f.isFile()) {
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".MP3")) {
                        try {
                            updateMessage("Found ->" + path);
                            Generator.generateSong(path);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override
    protected File call() {
        for (File f : drives) {
            extract(f);
        }
        return null;
    }

}
