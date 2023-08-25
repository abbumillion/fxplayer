package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArtistsView extends View {
    private ListView artistListView;

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
        artistListView.setCellFactory(songListView -> new SongCell());

    }


    @Override
    public void bind() {
        artistListView.prefWidthProperty().bind(widthProperty());
        artistListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {

    }

}
