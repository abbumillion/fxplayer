package com.app.fxplayer.application;

import com.app.fxplayer.application.config.ApplicationData;
import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.viewcontroller.PlayerViewController;
import com.app.fxplayer.modelgenerator.Collector;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.stage.Stage;

public class FXPlayerApplication extends Application {
    private PlayerViewController playerViewController;
    private ApplicationData applicationData;
    private Settings settings;

    @Override
    public void init() throws Exception {
        settings = new Settings();
        applicationData = new ApplicationData();
        playerViewController = new PlayerViewController(new PlayerView());

    }

    @Override
    public void start(Stage stage) {
        playerViewController.init();
        new Thread(new Collector()).start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}