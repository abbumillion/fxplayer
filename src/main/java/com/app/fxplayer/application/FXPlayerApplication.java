package com.app.fxplayer.application;

import com.app.fxplayer.controllers.viewcontroller.LoaderViewController;
import com.app.fxplayer.views.LoaderView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FXPlayerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        new LoaderViewController(new LoaderView()).init();
    }

}


