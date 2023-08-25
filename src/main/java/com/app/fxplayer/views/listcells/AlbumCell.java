package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.Album;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AlbumCell extends ListCell<Album> {
    @Override
    protected void updateItem(Album album, boolean b) {
        HBox hBox = new HBox(20);
        VBox vBox = new VBox(20);
        Label albumNameLabel = new Label();
        Label artistNameLabel = new Label();
        Label albumYearLabel = new Label();
        ImageView imageView = new ImageView();
        super.updateItem(album, b);
        if (album != null) {
            imageView.setImage(album.getAlbumImage());
            albumNameLabel.setText(album.getAlbumName());
            artistNameLabel.setText(album.getArtistName());
            albumYearLabel.setText(album.getCopyrightYear());
        }
        albumNameLabel.setAlignment(Pos.CENTER);
        artistNameLabel.setAlignment(Pos.CENTER);
        albumYearLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        imageView.setFitWidth(120);
        imageView.setFitHeight(100);
        vBox.getChildren().addAll(albumNameLabel, artistNameLabel, albumYearLabel);
        hBox.getChildren().addAll(imageView, vBox);
        setGraphic(hBox);
    }
}
