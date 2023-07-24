package com.app.fxplayer.views.listcells;
import com.app.fxplayer.models.Song;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
public  class SongCell extends ListCell<Song> {
    @Override
    protected void updateItem(Song song, boolean b) {
        HBox hBox =  new HBox(10);
        Label titleLabel = new Label("title label");
        Label albumLabel = new Label("album label");
        Label artistLabel = new Label("artist label");
        Label sizeLabel = new Label("size label");
        ImageView imageView = new ImageView();
        super.updateItem(song, b);
        if (song != null)
        {
            imageView.imageProperty().bind(song.getImage().imageProperty());
            titleLabel.setText(song.getTitle());
            albumLabel.setText(song.getAlbum());
            artistLabel.setText(song.getArtist());
            sizeLabel.setText(song.getSize());
        }
        imageView.setFitWidth(36);
        imageView.setFitHeight(24);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
        albumLabel.setAlignment(Pos.CENTER_LEFT);
        artistLabel.setAlignment(Pos.CENTER_LEFT);
        sizeLabel.setAlignment(Pos.CENTER_LEFT);
        titleLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(.2));
        artistLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(.2));
        albumLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(.2));
        sizeLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(.2));
        hBox.getChildren().addAll(imageView,titleLabel,albumLabel,artistLabel,sizeLabel);
        setGraphic(hBox);
    }
}
