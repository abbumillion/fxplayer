package com.app.fxplayer.application;

import com.app.fxplayer.modelgenerator.FileCollector;
import javafx.application.Application;

import java.io.File;

public class app {
    private static final File[] DRIVES = {new File("C://Users"), new File("D://")};
    public static void main(String[] args) throws Exception {
        configurations();
        Application.launch(FXPlayerApplication.class);
    }

    private static void configurations() {

        for (File file : DRIVES)
        {
            new Thread(new FileCollector(file)).start();
        }

    }
}
