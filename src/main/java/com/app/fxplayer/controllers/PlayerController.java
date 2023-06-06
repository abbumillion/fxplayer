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
    //
    private RecentPlaysTabController recentPlaysTabController;

    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void register() {
        // my music controller
        myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.register();
        myMusicTabController.start();
        // now playing controller
        nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.register();
        nowPlayingTabController.start();
        // albums controller
        albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.register();
        albumsTabController.start();
        // artists controller
        artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.register();
        artistsTabController.start();
        // settings controller
        settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.register();
        settingsTabController.start();
        // visualization controller
        visualizationTabController = new VisualizationTabController(playerView.getVisualizationView());
        visualizationTabController.register();
        visualizationTabController.start();
        // player view controller
        playerControllerComponentController = new PlayerControllerComponentController(playerView.getPlayerControllerView());
        playerControllerComponentController.register();
        playerControllerComponentController.start();
        // toolbar controller
        toolbarController = new ToolbarController(playerView.getToolBarView());
        toolbarController.register();
        toolbarController.start();
        //
        recentPlaysTabController = new RecentPlaysTabController(playerView.getRecentPlaysView());
        recentPlaysTabController.register();
        recentPlaysTabController.start();
    }

    /**
     * controller starter
     */
    @Override
    public void start() {
        playerView.showView();
    }

    /**
     *
     * @return visualization tab controller
     */
    public VisualizationTabController getVisualizationTabController() {
        return visualizationTabController;
    }

    /**
     *
     * @return now playing tab controller
     */
    public NowPlayingTabController getNowPlayingTabController() {
        return nowPlayingTabController;
    }

    /**
     *
     * @return my music tab controller
     */
    public MyMusicTabController getMyMusicTabController() {
        return myMusicTabController;
    }

    /**
     *
     * @return albums tab controller
     */
    public AlbumsTabController getAlbumsTabController() {
        return albumsTabController;
    }

    /**
     *
     * @return artists tab controller
     */
    public ArtistsTabController getArtistsTabController() {
        return artistsTabController;
    }

    /**
     *
     * @return settings tab controller
     */
    public SettingsTabController getSettingsTabController() {
        return settingsTabController;
    }

    /**
     *
     * @return player view instance
     */
    public PlayerView getPlayerView() {
        return playerView;
    }

    /**
     *
     * @return toolbar controller
     */
    public ToolbarController getToolbarController() {
        return toolbarController;
    }

    /**
     *
     * @return player controller component controller
     */
    public PlayerControllerComponentController getPlayerControllerComponentController() {
        return playerControllerComponentController;
    }

    /**
     *
     * @return recent plays tab controller
     */
    public RecentPlaysTabController getRecentPlaysTabController() {
        return recentPlaysTabController;
    }

}
