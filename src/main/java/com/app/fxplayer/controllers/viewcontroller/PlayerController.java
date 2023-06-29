package com.app.fxplayer.controllers.viewcontroller;


import com.app.fxplayer.controllers.componentcontrollers.PlayerControllerComponentController;
import com.app.fxplayer.controllers.componentcontrollers.ToolbarController;
import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

/**
 * APP
 */
public class PlayerController extends Controller {
    // player view instance
    private final PlayerView playerView;

    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void init() {
        // my music controller
        MyMusicTabController myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.init();
        // now playing controller
        // now playing sub view controller
        NowPlayingTabController nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.init();
        // albums controller
        // albums sub view controller
        AlbumsTabController albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.init();
        // artists controller
        ArtistsTabController artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.init();
        // settings controller
        // artist sub view controller
        SettingsTabController settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.init();
        // visualization controller
        // visualization sub view controller
        VisualizationTabController visualizationTabController = new VisualizationTabController(playerView.getVisualizationView());
        settingsTabController.init();
        // player view controller
        // player controller component controller
        PlayerControllerComponentController playerControllerComponentController = new PlayerControllerComponentController(playerView.getPlayerControllerView());
        settingsTabController.init();
        // toolbar controller
        // tool bar sub view controller
        ToolbarController toolbarController = new ToolbarController(playerView.getToolBarView());
        settingsTabController.init();
        //
        //
        RecentPlaysTabController recentPlaysTabController = new RecentPlaysTabController(playerView.getRecentPlaysView());
        settingsTabController.init();
        playerView.showView();
    }


}
