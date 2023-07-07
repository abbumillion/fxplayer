package com.app.fxplayer.application;

import com.app.fxplayer.application.config.ApplicationData;
import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.viewcontroller.PlayerController;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class FXPlayerApplication extends Application {
    private PlayerController playerController;
    private ApplicationData applicationData;
    private Settings settings;

    @Override
    public void init() throws Exception {
        settings = new Settings();
        applicationData = new ApplicationData();
        playerController = new PlayerController(new PlayerView());
    }

    @Override
    public void start(Stage stage) {

        playerController.init();
        new Thread(new Collector()).start();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}