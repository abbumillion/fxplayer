package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControllerView;
import com.app.fxplayer.views.components.ToolBarView;
import com.app.fxplayer.views.tabs.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 */
public class PlayerView extends View {
    //
    private TabPane tabPane;
    //
    private Tab myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,recentlyAddedTab,albumsTab,artistsTab,visualizationTab,settingsTab;
   // my music sub view
    private MyMusicView myMusicView;
    //now playing sub view
    private NowPlayingView nowPlayingView;
    // most played sub view
    private MostPlayedView mostPlayedView;
    // recent plays sub view
    private RecentPlaysView recentPlaysView;
    // recently added sub view
    private RecentlyAddedView recentlyAddedView;
    // albums sub view
    private AlbumsView albumsView;
    // artists sub view
    private ArtistsView artistsView;
    // playlist view
    private PlaylistView playlistView;
    // visualization sub view
    private VisualizationView visualizationView;
    // settings sub view
    private SettingsView settingsView;
    // player controller sub view
    private PlayerControllerView playerControllerView;
    // toolbar sub view
    private ToolBarView toolBarView;

    /**
     *
     */
    @Override
    public void init() {
        // tabs
        myMusicTab = new Tab("My Music");
        nowPlayingTab = new Tab("Now Playing");
        albumsTab = new Tab("Albums");
        artistsTab = new Tab("Artists");
        visualizationTab = new Tab("Visualization");
        settingsTab = new Tab("Settings");
        mostPlayedTab = new Tab("Most Played");
        recentPlaysTab = new Tab("Recent Plays");
        recentlyAddedTab = new Tab("Recent Added");
        tabPane = new TabPane();
        // sub views
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        mostPlayedView = new MostPlayedView();
        recentPlaysView = new RecentPlaysView();
        recentlyAddedView = new RecentlyAddedView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        visualizationView = new VisualizationView();
        settingsView = new SettingsView();
        // components
        playerControllerView = new PlayerControllerView();
        toolBarView = new ToolBarView();
        //
    }

    /**
     *
     */
    @Override
    public void build() {
        //
        myMusicTab.setContent(myMusicView);
        nowPlayingTab.setContent(nowPlayingView);
        mostPlayedTab.setContent(mostPlayedView);
        recentPlaysTab.setContent(recentPlaysView);
        recentlyAddedTab.setContent(recentlyAddedView);
        albumsTab.setContent(albumsView);
        artistsTab.setContent(artistsView);
        visualizationTab.setContent(visualizationView);
        settingsTab.setContent(settingsView);
        tabPane.getTabs().addAll(myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,
                recentlyAddedTab,artistsTab,albumsTab,visualizationTab,settingsTab);
        getChildren().addAll(toolBarView,tabPane,playerControllerView);
        //
    }

    /**
     *
     */
    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    /**
     *
     */
    @Override
    public void bind() {
        //
        toolBarView.prefWidthProperty().bind(widthProperty().multiply(.155));
        toolBarView.prefHeightProperty().bind(heightProperty().multiply(.1125));
        //
        tabPane.prefWidthProperty().bind(widthProperty());
        tabPane.prefHeightProperty().bind(heightProperty().multiply(.85));
        //
        playerControllerView.prefWidthProperty().bind(widthProperty());
        playerControllerView.prefHeightProperty().bind(heightProperty().multiply(.075));
        //
    }
    @Override
    public void styling() {

    }

    /**
     *
     * @return my music sub view
     */
    public MyMusicView getMyMusicView() {
        return myMusicView;
    }

    /**
     *
     * @return player controller sub view
     */
    public PlayerControllerView getPlayerControllerView() {
        return playerControllerView;
    }

    /**
     *
     * @return albums sub view
     */
    public AlbumsView getAlbumsView() {
        return albumsView;
    }

    /**
     *
     * @return artists sub view
     */
    public ArtistsView getArtistsView() {
        return artistsView;
    }

    /**
     *
     * @return settings sub view
     */
    public SettingsView getSettingsView() {
        return settingsView;
    }

    /**
     *
     * @return now playing sub view
     */
    public NowPlayingView getNowPlayingView() {
        return nowPlayingView;
    }

    /**
     *
     * @return visualization sub view
     */
    public VisualizationView getVisualizationView() {
        return visualizationView;
    }

    /**
     *
     * @return toolbar sub view
     */
    public ToolBarView getToolBarView() {
        return toolBarView;
    }

    /**
     *
     * @return most played sub view
     */
    public MostPlayedView getMostPlayedView() {
        return mostPlayedView;
    }

    /**
     *
     * @return recently added sub view
     */
    public RecentlyAddedView getRecentlyAddedView() {
        return recentlyAddedView;
    }

    /**
     *
     * @return recently played sub view
     */
    public RecentPlaysView getRecentPlaysView() {
        return recentPlaysView;
    }

}
