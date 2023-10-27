package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
public class SongCell extends ListCell<Song> {
    @Override
    protected void updateItem(Song song, boolean b) {
        super.updateItem(song, b);
        HBox hBox1 = new HBox(6.28);
        Label indexLabel = new Label("index label");
        Label titleLabel = new Label("title label");
        Label albumLabel = new Label("album label");
        Label artistLabel = new Label("artist label");
        Label sizeLabel = new Label("size label");
        ImageView imageView = new ImageView();
        // list cell data
        if (song != null) {
            indexLabel.setText(String.valueOf(SongRepository.getSongList().indexOf(song)));
            imageView.setImage(song.getSongImage());
            titleLabel.setText(song.getTitle());
            albumLabel.setText(song.getAlbum());
            artistLabel.setText(song.getArtist());
            sizeLabel.setText(song.getSize());
        }
        // image size
        imageView.setFitWidth(40);
        imageView.setFitHeight(28);
        // alignment
        indexLabel.setAlignment(Pos.CENTER_LEFT);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
        albumLabel.setAlignment(Pos.CENTER_LEFT);
        artistLabel.setAlignment(Pos.CENTER_LEFT);
        sizeLabel.setAlignment(Pos.CENTER_LEFT);
        hBox1.setAlignment(Pos.CENTER);
        //
        hBox1.setPadding(new Insets(.5,.5,.5,.5));
        //
        hBox1.getChildren().addAll(indexLabel,imageView, titleLabel, albumLabel, artistLabel, sizeLabel);
        //
        indexLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.0525));
        titleLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.1525));
        artistLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.1525));
        albumLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.1525));
        sizeLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.0525));
        hBox1.prefWidthProperty().bind(widthProperty());
        //
        setGraphic(hBox1);
    }
}
