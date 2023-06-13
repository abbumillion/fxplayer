package com.app.fxplayer.application;

import com.app.fxplayer.controllers.maincontrollers.PlayerController;
import com.app.fxplayer.models.collectors.Collector;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class application extends Application {
    // application data
    private ApplicationData applicationData;
    // application states
    private ApplicationStates applicationStates;
    // application settings
    private Settings settings;
    // application view controller
    private PlayerController playerController;

    /**
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        playerController = new PlayerController(new PlayerView());
        new Thread(new Collector()).start();
    }

    /**
     *
     * @param stage stage style
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        playerController.register();
        playerController.start();

      //  playerController.setApplicationStates(ApplicationStates.RUNNING);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(15-4/.25+2);
        launch();
    }
}