package com.app.fxplayer.application;

import com.app.fxplayer.models.collectors.Collector;
import javafx.application.Application;
import javafx.application.Platform;

/**
 *
 * main application starting  point
 * this is a simple java class with
 * main method to start java application
 * also will contain application resources
 */
public class app {
    public static void main(String[] args) throws Exception {
        //
        // this will launch the javafx application

        Application.launch(FXPlayerApplication.class);

        //
        //
    }
    // do i need to start some kind of background task here or there


}
