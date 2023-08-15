package com.app.fxplayer.controllers;

import com.app.fxplayer.modelgenerator.Collector;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

import java.io.IOException;

public class LoaderViewController extends Controller {
    private final LoaderView loaderView;

    public LoaderViewController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        loaderView.showView();

    }
    private void firstTimeOperation() {
        Collector collector = new Collector(loaderView);
        collector.start();
        loaderView.getProgressIndicator().progressProperty().bind(collector.progressProperty());
    }
}
