package com.app.fxplayer.application;

import com.app.fxplayer.controllers.viewcontroller.PlayerController;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FXPlayerApplication extends Application {
    // application view controller
    private PlayerController playerController;

    @Override
    public void init() throws Exception {
        playerController = new PlayerController(new PlayerView());
    }

    @Override
    public void start(Stage stage) throws IOException {
        playerController.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}