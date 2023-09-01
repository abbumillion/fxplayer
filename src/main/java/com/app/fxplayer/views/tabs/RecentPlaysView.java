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
public class RecentPlaysView extends View {
    private ListView<Song> recentPlaysListView;

    @Override
    public void init() {
        recentPlaysListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().add(recentPlaysListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        recentPlaysListView.prefWidthProperty().bind(widthProperty());
        recentPlaysListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        recentPlaysListView.setCellFactory(songListView -> new SongCell());
    }
}
