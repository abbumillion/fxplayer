package com.app.fxplayer.controllers.viewcontroller;

import com.app.fxplayer.controllers.Controller;
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
        firstTimeOperation();
        loaderView.showView();
    }

    private void firstTimeOperation() {
        Collector collector = new Collector();
        new Thread(collector).start();
        collector.setOnRunning(Event -> {
            loaderView.hideView();
            PlayerViewController playerViewController = new PlayerViewController(new PlayerView());

            try {
                playerViewController.init();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        loaderView.getProgressIndicator().progressProperty().bind(collector.progressProperty());
    }
}
