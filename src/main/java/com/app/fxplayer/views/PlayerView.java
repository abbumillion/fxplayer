package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControllerView;
import com.app.fxplayer.views.components.SearchBarView;
import com.app.fxplayer.views.tabs.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class PlayerView extends View {

    private TabPane tabPane;
    private Tab myMusicTab,nowPlayingTab,albumsTab,artistsTab,visualizationTab,settingsTab;
    private MyMusicView myMusicView;
    private NowPlayingView nowPlayingView;
    private AlbumsView albumsView;
    private ArtistsView artistsView;
    private VisualizationView visualizationView;
    private SettingsView settingsView;
    private PlayerControllerView playerControllerView;
    private SearchBarView searchBarView;
    @Override
    public void init() {
        myMusicTab = new Tab("My Music");
        nowPlayingTab = new Tab("Now Playing");
        albumsTab = new Tab("Albums");
        artistsTab = new Tab("Artists");
        visualizationTab = new Tab("Visualization");
        settingsTab = new Tab("Settings");
        tabPane = new TabPane();
        //
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        visualizationView = new VisualizationView();
        settingsView = new SettingsView();
        //
        playerControllerView = new PlayerControllerView();
        //
        searchBarView = new SearchBarView();
    }

    @Override
    public void build() {
        //-------------------------------------------------------------------------------------------------------------//
        myMusicTab.setContent(myMusicView);
        nowPlayingTab.setContent(nowPlayingView);
        albumsTab.setContent(albumsView);
        artistsTab.setContent(artistsView);
        visualizationTab.setContent(visualizationView);
        settingsTab.setContent(settingsView);
        tabPane.getTabs().addAll(myMusicTab,nowPlayingTab,artistsTab,albumsTab,visualizationTab,settingsTab);
        getChildren().addAll(searchBarView,tabPane,playerControllerView);
        //-------------------------------------------------------------------------------------------------------------//
    }

    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    @Override
    public void bind() {
        //
        searchBarView.prefWidthProperty().bind(widthProperty());
        searchBarView.prefHeightProperty().bind(heightProperty().multiply(.075));
        //
        tabPane.prefWidthProperty().bind(widthProperty());
        tabPane.prefHeightProperty().bind(heightProperty().multiply(.85));
        //
        playerControllerView.prefWidthProperty().bind(widthProperty());
        playerControllerView.prefHeightProperty().bind(heightProperty().multiply(.075));
        //
    }

    public MyMusicView getMyMusicView() {
        return myMusicView;
    }

    public PlayerControllerView getPlayerControllerView() {
        return playerControllerView;
    }

    public AlbumsView getAlbumsView() {
        return albumsView;
    }

    public ArtistsView getArtistsView() {
        return artistsView;
    }

    public SettingsView getSettingsView() {
        return settingsView;
    }

    public NowPlayingView getNowPlayingView() {
        return nowPlayingView;
    }

    public VisualizationView getVisualizationView() {
        return visualizationView;
    }

    public SearchBarView getSearchBarView() {
        return searchBarView;
    }
}
