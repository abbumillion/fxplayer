package com.app.fxplayer.application;

import com.app.fxplayer.application.config.ApplicationData;
import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.viewcontroller.LoaderViewController;
import com.app.fxplayer.views.LoaderView;
import javafx.application.Application;
import javafx.stage.Stage;

public class FXPlayerApplication extends Application {
    private LoaderViewController loaderViewController;
    private ApplicationData applicationData;
    private Settings settings;

    @Override
    public void init() throws Exception {
        settings = new Settings();
        applicationData = new ApplicationData();
        loaderViewController = new LoaderViewController(new LoaderView());

    }

    @Override
    public void start(Stage stage) {
        loaderViewController.init();
//        new Thread(new Collector()).start();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(1);
    }

}