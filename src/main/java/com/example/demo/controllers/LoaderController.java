package com.example.demo.controllers;

import model.Collector;
import views.LoaderView;
import views.PlayerView;
import views.View;

import java.io.File;

public class LoaderController extends Controller{
    private final LoaderView loaderView;
    public LoaderController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void register() {
        Collector collector = new Collector(new File("/"));
        new Thread(collector).start();
        loaderView.getProgressMessageLabel().textProperty().bind(collector.messageProperty());
        loaderView.getProgressBar().progressProperty().bind(collector.progressProperty());
        collector.setOnSucceeded(e->{
            PlayerController playerController = new PlayerController(new PlayerView());
            playerController.register();
            playerController.start();
        });
    }

    @Override
    public void start() {
        loaderView.show();
    }
}
