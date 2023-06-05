package com.app.fxplayer.controllers;


import com.app.fxplayer.controllers.componentcontrollers.ToolbarController;
import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

/**
 * APP
 */
public class PlayerController extends Controller{
    // player view instance
    private final PlayerView playerView;
    private  MyMusicTabController myMusicTabController;
    // now playing sub view controller
    private NowPlayingTabController nowPlayingTabController;
    // albums sub view controller
    private AlbumsTabController albumsTabController;
    private ArtistsTabController artistsTabController;
    // artist sub view controller
    private SettingsTabController settingsTabController;
    // visualization sub view controller
    private VisualizationTabController visualizationTabController;
    // player controller component controller
    private PlayerControllerComponentController playerControllerComponentController;
    // tool bar sub view controller
    private ToolbarController toolbarController;

    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void register() {
        // my music controller
        myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.register();

        // now playing controller
        nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.register();
        // albums controller
        albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.register();

        // artists controller
        artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.register();
        // settings controller
        settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.register();
        // visualization controller
        visualizationTabController = new VisualizationTabController(playerView.getVisualizationView());
        visualizationTabController.register();
        // player view controller
        playerControllerComponentController = new PlayerControllerComponentController(playerView.getPlayerControllerView());
        playerControllerComponentController.register();
        // tool-bar controller
        toolbarController = new ToolbarController(playerView.getToolBarView());
        toolbarController.register();
    }

    @Override
    public void start() {
        // showing player view on the screen
        playerView.showView();
        // starting my music tab controller
        myMusicTabController.start();
        // starting albums tab controller
        albumsTabController.start();
        // starting now playing tab controller
        nowPlayingTabController.start();
        //starting artists tab controller
        artistsTabController.start();
        // starting settings controller
        settingsTabController.start();
        // starting visualization controlller
        visualizationTabController.start();
        // starting player controller
        playerControllerComponentController.start();
        // starting tool bar controller
        toolbarController.start();
    }

    public AlbumsTabController getAlbumsTabController() {
        return albumsTabController;
    }

    public ArtistsTabController getArtistsTabController() {
        return artistsTabController;
    }

    public MyMusicTabController getMyMusicTabController() {
        return myMusicTabController;
    }

    public NowPlayingTabController getNowPlayingTabController() {
        return nowPlayingTabController;
    }

    public PlayerControllerComponentController getPlayerControllerComponentController() {
        return playerControllerComponentController;
    }

    public ToolbarController getToolbarController() {
        return toolbarController;
    }

    public SettingsTabController getSettingsTabController() {
        return settingsTabController;
    }

    /**
     *
     * @return
     */
    public VisualizationTabController getVisualizationTabController() {
        return visualizationTabController;
    }


}
