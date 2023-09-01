package com.app.fxplayer.views;

import com.app.fxplayer.models.Song;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AlbumDetailView extends View {
    private ImageView albumImageImageView;
    private ListView<Song> albumsSongListView;

    @Override
    public void init() {
        albumImageImageView = new ImageView();
        albumsSongListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(albumImageImageView, albumsSongListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        albumImageImageView.fitWidthProperty().bind(widthProperty());
        albumImageImageView.fitHeightProperty().bind(heightProperty().multiply(.37));

        albumsSongListView.prefWidthProperty().bind(widthProperty());
        albumsSongListView.prefHeightProperty().bind(heightProperty().multiply(.63));
    }

    @Override
    public void styling() {

    }
}
