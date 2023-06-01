package com.app.fxplayer;

import com.app.fxplayer.controllers.LoaderController;
import com.app.fxplayer.views.windows.LoaderView;
import javafx.application.Application;

import javafx.stage.Stage;

import java.io.IOException;

public class app extends Application {


    private LoaderController loaderController;

    @Override
    public void init() throws Exception {
        super.init();
        loaderController = new LoaderController(new LoaderView());
    }

    @Override
    public void start(Stage stage) throws IOException {
        loaderController.register();
        loaderController.start();
    }

    public static void main(String[] args) {
        System.out.println("APP...STARTED");
        launch();
        System.out.println("APP...STOPPED");
    }
}