package com.app.fxplayer.views;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import lombok.Data;

@Data
public class LoaderView extends View {
    private ListView<Song> songListView;
    private PlayerControlsView playerControlsView;
 
    @Override
    public void init() {
        songListView = new ListView<>();
        playerControlsView = new PlayerControlsView();
    }

    @Override
    public void build() {
        getChildren().addAll(songListView, playerControlsView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        playerControlsView.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        playerControlsView.prefWidthProperty().bind(widthProperty());
        playerControlsView.prefHeightProperty().bind(heightProperty().multiply(.15));
        songListView.prefWidthProperty().bind(widthProperty());
        songListView.prefHeightProperty().bind(heightProperty().multiply(.83));
    }

    @Override
    public void styling() {
    songListView.setCellFactory(songListView -> new SongCell());
    }
}
