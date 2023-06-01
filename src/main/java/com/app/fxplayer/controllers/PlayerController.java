package com.app.fxplayer.controllers;


import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

public class PlayerController extends Controller{
    PlayerView playerView;
    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void register() {
        Collector collector = new Collector();
        new Thread(collector).start();
        //
        playerView.getMyMusicView().getTableView().itemsProperty().bind(collector.getFileListview().itemsProperty());
        playerView.getAlbumsView().getAlbumListView().itemsProperty().bind(collector.getFileListview().itemsProperty());
        playerView.getArtistsView().getArtistListView().itemsProperty().bind(collector.getFileListview().itemsProperty());
        playerView.getMyMusicView().getTableView().itemsProperty().bind(collector.getFileListview().itemsProperty());
        //
    }

    @Override
    public void start() {
        playerView.showView();
    }
}
