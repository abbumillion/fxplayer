package com.app.fxplayer.controllers;


import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

public class PlayerController extends Controller{
    private final PlayerView playerView;

    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void register() {
        // music collector task
        // my music controller
        MyMusicTabController myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.register();
        myMusicTabController.start();
        // now playing controller
        NowPlayingTabController nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.register();
        nowPlayingTabController.start();
        // albums controller
        AlbumsTabController albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.register();
        albumsTabController.start();
        // artists controller
        ArtistsTabController artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.register();
        artistsTabController.start();
        // settings controller
        SettingsTabController settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.register();
        settingsTabController.start();
        // visualization controller
        VisualizationTabController visualizationTabController = new VisualizationTabController(playerView.getVisualizationView());
        visualizationTabController.register();
        visualizationTabController.start();
        // player view controller
        PlayerControllerComponentController playerControllerComponentController = new PlayerControllerComponentController(playerView.getPlayerControllerView());
        playerControllerComponentController.register();
        playerControllerComponentController.start();
    }

    @Override
    public void start() {

        playerView.showView();
    }
}
