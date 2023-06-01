package com.app.fxplayer.controllers;


import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.windows.LoaderView;
import com.app.fxplayer.views.windows.PlayerView;
import javafx.concurrent.Task;

import java.io.File;

public class LoaderController extends Controller{
    private final LoaderView loaderView;
    public LoaderController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void register() {
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 1000 ; i++) {
                    updateMessage("downloading : "+ i);
                    updateProgress(i,1000);
                    Thread.sleep(100);
                }
                return null;
            }
        };
        new Thread(task).start();
        loaderView.getProgressMessageLabel().textProperty().bind(task.messageProperty());
        loaderView.getProgressBar().progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(e->{
            PlayerController playerController = new PlayerController(new PlayerView());
            playerController.register();
            playerController.start();
        });
    }

    @Override
    public void start()
    {
        loaderView.showView();
    }
}
