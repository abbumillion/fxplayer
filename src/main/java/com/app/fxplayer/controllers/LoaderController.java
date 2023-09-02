package com.app.fxplayer.controllers;

import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;
import javafx.concurrent.Task;

import java.io.IOException;

public class LoaderController extends Controller{
    private final LoaderView loaderView;
    public LoaderController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {

        Task<Integer> task = new Task<>() {
            @Override
            protected Integer call() throws Exception {
                int max = 1000;
                for (int i = 0; i < max; i++) {
                    Thread.sleep(1);
                    updateProgress(i,max);
                }
                return null;
            }
        };

        new Thread(task).start();
        task.setOnSucceeded(event -> {
            try {
                new PlayerViewController(new PlayerView()).init();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        loaderView.getProgressIndicator().progressProperty().bind(task.progressProperty());
        loaderView.showView();
    }
}
