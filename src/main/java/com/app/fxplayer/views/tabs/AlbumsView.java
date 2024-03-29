package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.AlbumCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AlbumsView extends View {
    private ListView<Album> albumListView;

    @Override
    public void init() {
        albumListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(albumListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        albumListView.prefWidthProperty().bind(widthProperty());
        albumListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        albumListView.setCellFactory(songListView -> new AlbumCell());
    }

    public ListView getAlbumListView() {
        return albumListView;
    }
}
