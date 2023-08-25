package com.app.fxplayer.views;

import com.app.fxplayer.models.Album;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.AlbumCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArtistDetailView extends View {
    private ScrollPane scrollPane;
    private ImageView artistImageImageView;
    private ListView<Album> albumListView;
    private VBox vBox;
    @Override
    public void init() {
        albumListView = new ListView<>();
        scrollPane = new ScrollPane();
        artistImageImageView = new ImageView();
        vBox = new VBox(0);
    }

    @Override
    public void build() {
        vBox.getChildren().addAll(artistImageImageView,albumListView);
        scrollPane.setContent(vBox);
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        vBox.prefWidthProperty().bind(scrollPane.widthProperty());
        vBox.prefHeightProperty().bind(scrollPane.heightProperty());

        scrollPane.prefWidthProperty().bind(widthProperty());
        scrollPane.prefHeightProperty().bind(heightProperty());

        artistImageImageView.fitWidthProperty().bind(vBox.widthProperty());
        artistImageImageView.fitHeightProperty().bind(vBox.heightProperty().multiply(.37));

        albumListView.prefWidthProperty().bind(vBox.widthProperty());
        albumListView.prefHeightProperty().bind(vBox.heightProperty().multiply(.63));

    }

    @Override
    public void styling() {
        albumListView.setCellFactory(albumListView -> new AlbumCell());
    }
}
