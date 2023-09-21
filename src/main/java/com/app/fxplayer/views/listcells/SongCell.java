package com.app.fxplayer.views.listcells;
import com.app.fxplayer.models.Song;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class SongCell extends ListCell<Song> {
    @Override
    protected void updateItem(Song song, boolean b) {
        super.updateItem(song, b);
        HBox hBox1 = new HBox(2.2345);
        HBox hBox2 = new HBox(2.2345);
        VBox vBox = new VBox();
        Label titleLabel = new Label("title label");
        Label albumLabel = new Label("album label");
        Label artistLabel = new Label("artist label");
        Label sizeLabel = new Label("size label");
        Button addToPlaylistButton = new Button("add to playlist");
        Button addToFavoritesButton = new Button("add to favorites");
        Button deleteSongButton = new Button("delete");
        ImageView imageView = new ImageView();
        if (song != null) {
            imageView.setImage(song.getSongImage());
            titleLabel.setText(song.getTitle());
            albumLabel.setText(song.getAlbum());
            artistLabel.setText(song.getArtist());
            sizeLabel.setText(song.getSize());
        }
        imageView.setFitWidth(38);
        imageView.setFitHeight(26);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
        albumLabel.setAlignment(Pos.CENTER_LEFT);
        artistLabel.setAlignment(Pos.CENTER_LEFT);
        sizeLabel.setAlignment(Pos.CENTER_LEFT);
        hBox2.setAlignment(Pos.CENTER);
        addToPlaylistButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.018));
        hBox1.getChildren().addAll(imageView, titleLabel, albumLabel, artistLabel, sizeLabel);
        hBox2.getChildren().addAll(addToFavoritesButton, addToPlaylistButton, deleteSongButton);
        vBox.getChildren().addAll(hBox1, hBox2);
        titleLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.2));
        artistLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.2));
        albumLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.2));
        sizeLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.2));
        hBox1.prefWidthProperty().bind(vBox.widthProperty());
        hBox2.setVisible(false);
        addToPlaylistButton.setOnAction(event -> {
            System.out.println("add current song to selected playlist");
        });
        addToFavoritesButton.setOnAction(event -> {
            System.out.println("add current song to favorites");
        });
        deleteSongButton.setOnAction(event -> {
            System.out.println("delete current song");
        });
        setOnMouseClicked(event ->
        {
            hBox2.setVisible(true);
            hBox1.prefWidthProperty().bind(vBox.widthProperty());
            hBox1.prefHeightProperty().bind(vBox.heightProperty().multiply(.5));
            hBox2.prefWidthProperty().bind(vBox.widthProperty());
            hBox2.prefHeightProperty().bind(vBox.heightProperty().multiply(.5));
        });
        hBox2.setSpacing(12.5);
//        hBox2.setPadding(new Insets(2.3,2.3,2.3,2.3));
        setGraphic(vBox);
    }
}
