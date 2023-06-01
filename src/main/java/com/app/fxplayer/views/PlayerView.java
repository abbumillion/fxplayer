package com.app.fxplayer.views;

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
    }

    @Override
    public void build() {
        myMusicTab.setContent(myMusicView);
        nowPlayingTab.setContent(nowPlayingView);
        albumsTab.setContent(albumsView);
        artistsTab.setContent(artistsView);
        visualizationTab.setContent(visualizationView);
        settingsTab.setContent(settingsView);
        tabPane.getTabs().addAll(myMusicTab,nowPlayingTab,artistsTab,albumsTab,visualizationTab,settingsTab);
        getChildren().add(tabPane);
    }

    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    @Override
    public void bind() {
        tabPane.prefWidthProperty().bind(widthProperty());
        tabPane.prefHeightProperty().bind(heightProperty());
    }
}
