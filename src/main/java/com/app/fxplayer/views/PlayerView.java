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
    // visualization sub view
    private VisualizationView visualizationView;
    // settings sub view
    private SettingsView settingsView;
    // player controller sub view
    private PlayerControllerView playerControllerView;
    // tool bar sub view
    private ToolBarView toolBarView;

    /**
     *
     */
    @Override
    public void init() {
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
        //
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        mostPlayedView = new MostPlayedView();
        recentPlaysView = new RecentPlaysView();
        recentlyAddedView = new RecentlyAddedView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        visualizationView = new VisualizationView();
        settingsView = new SettingsView();
        //
        playerControllerView = new PlayerControllerView();
        //
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
     * @return
     */
    public MyMusicView getMyMusicView() {
        return myMusicView;
    }

    /**
     *
     * @return
     */
    public PlayerControllerView getPlayerControllerView() {
        return playerControllerView;
    }

    /**
     *
     * @return
     */
    public AlbumsView getAlbumsView() {
        return albumsView;
    }

    /**
     *
     * @return
     */
    public ArtistsView getArtistsView() {
        return artistsView;
    }

    /**
     *
     * @return
     */
    public SettingsView getSettingsView() {
        return settingsView;
    }

    /**
     *
     * @return
     */
    public NowPlayingView getNowPlayingView() {
        return nowPlayingView;
    }

    /**
     *
     * @return
     */
    public VisualizationView getVisualizationView() {
        return visualizationView;
    }

    /**
     *
     * @return toolbar
     */
    public ToolBarView getToolBarView() {
        return toolBarView;
    }

    /**
     *
     * @return
     */
    public MostPlayedView getMostPlayedView() {
        return mostPlayedView;
    }

    /**
     *
     * @return
     */
    public RecentlyAddedView getRecentlyAddedView() {
        return recentlyAddedView;
    }

    /**
     *
     * @return
     */
    public RecentPlaysView getRecentPlaysView() {
        return recentPlaysView;
    }

}
