package com.app.fxplayer.application;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class FXPlayerApplication extends Application {
    private Settings appSettings;
    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        new PlayerViewController(new PlayerView()).init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}


