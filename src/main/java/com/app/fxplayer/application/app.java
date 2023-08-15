package com.app.fxplayer.application;

import com.app.fxplayer.modelgenerator.FileCollector;
import javafx.application.Application;

public class app {
    public static void main(String[] args) throws Exception {
        configurations();
        Application.launch(FXPlayerApplication.class);
    }

    private static void configurations() {
        new Thread(new FileCollector()).start();
    }
}
