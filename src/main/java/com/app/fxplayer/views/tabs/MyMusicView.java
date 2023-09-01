package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.*;

import java.io.File;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MyMusicView extends View {
    private ImageView imageView;
    private ListView<Song> songListView;
    private HBox hBox;
    private VBox vBox;
    private Hyperlink songTitleHyperLink, songArtistHyperLink;

    @Override
    public void init() {
        hBox = new HBox();
        vBox = new VBox();
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
        songTitleHyperLink = new Hyperlink("Song Title hyper link");
        songArtistHyperLink = new Hyperlink("Song artist hyper link");
        songListView = new ListView<>();
    }

    @Override
    public void build() {
        vBox.getChildren().addAll(imageView, songTitleHyperLink, songArtistHyperLink);
        hBox.getChildren().addAll(vBox, songListView);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        songTitleHyperLink.setAlignment(Pos.CENTER);
        songArtistHyperLink.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void bind() {
        songTitleHyperLink.prefWidthProperty().bind(vBox.widthProperty().multiply(.35));
        songArtistHyperLink.prefHeightProperty().bind(vBox.heightProperty().multiply(.1));
        imageView.fitWidthProperty().bind(vBox.widthProperty());
        imageView.fitHeightProperty().bind(vBox.heightProperty().multiply(.9));
        songListView.prefWidthProperty().bind(hBox.widthProperty().multiply(.63));
        songListView.prefHeightProperty().bind(hBox.heightProperty());
        vBox.prefWidthProperty().bind(hBox.widthProperty().multiply(.47));
        vBox.prefHeightProperty().bind(hBox.heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        hBox.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        songListView.setCellFactory(songListView -> new SongCell());
    }

}
