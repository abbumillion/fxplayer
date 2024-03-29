package com.app.fxplayer.application;

import com.app.fxplayer.controllers.LoginController;
import com.app.fxplayer.views.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FXPlayerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        new LoginController(new LoginView()).init();
    }
}


