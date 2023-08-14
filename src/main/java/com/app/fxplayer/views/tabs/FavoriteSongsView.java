package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;

public class FavoriteSongsView extends View {
    private ListView favoriteSongsListView;

    @Override
    public void init() {
        favoriteSongsListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(favoriteSongsListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        favoriteSongsListView.prefWidthProperty().bind(widthProperty());
        favoriteSongsListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        favoriteSongsListView.setCellFactory(songListView -> new SongCell());
    }
}
