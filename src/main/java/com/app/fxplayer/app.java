package com.app.fxplayer;

import com.app.fxplayer.controllers.PlayerController;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {

    private PlayerController playerController;

    @Override
    public void init() throws Exception {
        super.init();
        playerController = new PlayerController(new PlayerView());
    }

    @Override
    public void start(Stage stage) throws IOException {

        playerController.register();
        playerController.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Collector.init();
            }
        }).start();


    }

    public static void main(String[] args) {
        launch();
    }
}