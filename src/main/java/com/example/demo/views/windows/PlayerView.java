package com.example.demo.views.windows;

import com.example.demo.views.View;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class PlayerView extends View {

    private TabPane tabPane;
    private Tab myMusicTab,nowPlayingTab,albumsTab,artistsTab,visualizationTab,settingsTab;
    @Override
    public void init() {
        //
        myMusicTab = new Tab("My Music");
        nowPlayingTab = new Tab("My Music");
        albumsTab = new Tab("My Music");
        artistsTab = new Tab("My Music");
        visualizationTab = new Tab("My Music");
        settingsTab = new Tab("My Music");
        //
        tabPane = new TabPane();

    }

    @Override
    public void build() {
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
