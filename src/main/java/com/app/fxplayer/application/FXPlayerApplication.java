package com.app.fxplayer.application;

import com.app.fxplayer.application.config.ApplicationData;
import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.viewcontroller.LoaderViewController;
import com.app.fxplayer.player.visualization.soundcloud.WaveFormService;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.components.audiovirtualizationview.WaveVisualization;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.*;

import static javax.sound.sampled.AudioSystem.getLine;

public class FXPlayerApplication extends Application {

    WaveVisualization waveVisualization = new WaveVisualization(520, 32);

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        LoaderViewController loaderViewController = new LoaderViewController(new LoaderView());
        loaderViewController.init();
    }

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        launch(args);
    }

}


