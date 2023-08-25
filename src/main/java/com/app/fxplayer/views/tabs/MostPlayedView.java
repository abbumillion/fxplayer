package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
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
public class MostPlayedView extends View {
    private ListView<Song> mostPlayedListView;

    @Override
    public void init() {
        mostPlayedListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().add(mostPlayedListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        mostPlayedListView.prefWidthProperty().bind(widthProperty());
        mostPlayedListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        mostPlayedListView.setCellFactory(songListView -> new SongCell());
    }
}
