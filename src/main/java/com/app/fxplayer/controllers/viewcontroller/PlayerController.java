package com.app.fxplayer.controllers.viewcontroller;


import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

public class PlayerController extends Controller {
    private final PlayerView playerView;

    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void init() {
        MyMusicTabController myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.init();
        NowPlayingTabController nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.init();
        AlbumsTabController albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.init();
        ArtistsTabController artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.init();
        SettingsTabController settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.init();
        VisualizationTabController visualizationTabController = new VisualizationTabController(playerView.getVisualizationView());
        visualizationTabController.init();
        RecentPlaysTabController recentPlaysTabController = new RecentPlaysTabController(playerView.getRecentPlaysView());
        recentPlaysTabController.init();
        PlayerControlsViewController playerControlsViewController = new PlayerControlsViewController(playerView.getPlayerControllerView());
        playerControlsViewController.init();
        playerView.showView();
    }


}
