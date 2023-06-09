package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;

/**
 * ARTISTS TAB SUB VIEW CLASS
 */

public class ArtistsView extends View {
    /**
     * ARTISTS COLLECTIONS HOLDER LIST VIEW
     */
    private ListView artistListView;

    /**
     *
     */
    @Override
    public void init() {
        artistListView = new ListView<>();
    }

    /**
     *
     */

    @Override
    public void build() {
        getChildren().addAll(artistListView);
    }

    /**
     *
     */

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    /**
     *
     */

    @Override
    public void bind() {
        artistListView.prefWidthProperty().bind(widthProperty());
        artistListView.prefHeightProperty().bind(heightProperty());
    }

    /**
     *
     */
    @Override
    public void styling() {

    }

    /**
     *
     * @return artists list view
     */
    public ListView getArtistListView() {
        return artistListView;
    }
}
