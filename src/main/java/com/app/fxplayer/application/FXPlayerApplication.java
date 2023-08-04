package com.app.fxplayer.application;

import com.app.fxplayer.controllers.viewcontroller.LoaderViewController;
import com.app.fxplayer.views.LoaderView;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class FXPlayerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        new LoaderViewController(new LoaderView()).init();
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        launch(args);
    }

}


