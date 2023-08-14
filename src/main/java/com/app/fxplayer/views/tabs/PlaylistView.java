package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Playlist;
import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import lombok.Data;

@Data
public class PlaylistView extends View {
    private ListView<Playlist> playlistListView;

    @Override
    public void init() {
        playlistListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().add(playlistListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        playlistListView.prefWidthProperty().bind(widthProperty());
        playlistListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {

    }
}
