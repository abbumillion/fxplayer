package com.app.fxplayer.application;

import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class FXPlayerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
//        new LoaderViewController(new LoaderView()).init();
        new PlayerViewController(new PlayerView()).init();
    }

}


