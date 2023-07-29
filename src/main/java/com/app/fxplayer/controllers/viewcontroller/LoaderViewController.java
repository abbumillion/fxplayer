package com.app.fxplayer.controllers.viewcontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.modelgenerator.Collector;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.audioplayer.MediaQueue;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

public class LoaderViewController extends Controller {
    // loader view instance
    private final LoaderView loaderView;
    //
    public LoaderViewController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() throws InterruptedException {
        Collector collector = new Collector();
        new Thread(collector).start();
        collector.setOnRunning(Event->{
            loaderView.hideView();
            PlayerViewController playerViewController = new PlayerViewController(new PlayerView());
            playerViewController.init();
        });
        loaderView.getLoaderListView().itemsProperty().bind(ModelRepository.getSongList().itemsProperty());
        loaderView.showView();
        loaderView.getLoaderListView().getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) ->
        {
            if (t1 != null)
            {
                Song song = (Song) t1;
                MediaQueue.setCurrentSong(song);
                Player.play();
            }
        });
    }
}
