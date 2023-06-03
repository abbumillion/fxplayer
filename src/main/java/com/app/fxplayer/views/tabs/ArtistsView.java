package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Artist;
import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;

public class ArtistsView extends View {
    private ListView<Artist> artistListView;
    @Override
    public void init() {
        artistListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(artistListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        artistListView.prefWidthProperty().bind(widthProperty());
        artistListView.prefHeightProperty().bind(heightProperty());
    }

    public ListView<Artist> getArtistListView() {
        return artistListView;
    }
}
