package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import com.jfoenix.controls.JFXListView;
import javafx.geometry.Pos;
import lombok.Data;

@Data
public class RecentlyAddedView extends View {
    private JFXListView<Song> recentlyAddedJFXListView;
    @Override
    public void init() {
        recentlyAddedJFXListView = new JFXListView<>();
    }

    @Override
    public void build() {
        getChildren().add(recentlyAddedJFXListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        recentlyAddedJFXListView.prefWidthProperty().bind(widthProperty());
        recentlyAddedJFXListView.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {
        recentlyAddedJFXListView.setCellFactory(songListView -> new SongCell());
    }

}
