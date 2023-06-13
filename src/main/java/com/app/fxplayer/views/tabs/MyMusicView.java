package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.models.Song;
import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;

public class MyMusicView extends View {
    //
    private ImageView imageView;
    //
    private ListView<Song> songListView;
    //
    private HBox hBox;
    @Override
    public void init() {
        //
        songListView = new ListView<>();
        //
//        indexColumn = new TableColumn<>("index");
//        titleColumn = new TableColumn<>("title");
//        sizeColumn = new TableColumn<>("Size");
//        artistColumn = new TableColumn<>("artist");
//        albumColumn = new TableColumn<>("album");
        //
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
        //
        hBox = new HBox();

    }

    @Override
    public void build() {
//        tableView.getColumns().addAll(indexColumn,titleColumn,sizeColumn,artistColumn,albumColumn);
        hBox.getChildren().addAll(imageView,songListView);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void bind() {
        //imageview
        imageView.fitWidthProperty().bind(hBox.widthProperty().multiply(.4));
        imageView.fitHeightProperty().bind(hBox.heightProperty().multiply(.999999));
        //tableview
        songListView.prefWidthProperty().bind(hBox.widthProperty().multiply(.6));
        songListView.prefHeightProperty().bind(hBox.heightProperty());
        //
//        indexColumn.prefWidthProperty().bind(tableView.prefWidthProperty().multiply(.2));
//        albumColumn.prefWidthProperty().bind(tableView.prefWidthProperty().multiply(.2));
//        artistColumn.prefWidthProperty().bind(tableView.prefWidthProperty().multiply(.2));
//        sizeColumn.prefWidthProperty().bind(tableView.prefWidthProperty().multiply(.2));
//        titleColumn.prefWidthProperty().bind(tableView.prefWidthProperty().multiply(.2));
        //
        hBox.prefWidthProperty().bind(widthProperty());
        hBox.prefHeightProperty().bind(heightProperty());
        //
    }
    @Override
    public void styling() {

    }

//
//    public TableColumn<Song, String> getIndexColumn() {
//        return indexColumn;
//    }
//
//    public TableView<Song> getTableView() {
//        return tableView;
//    }
//
//    public TableColumn<Song, String> getAlbumColumn() {
//        return albumColumn;
//    }
//
//    public TableColumn<Song, String> getTitleColumn() {
//        return titleColumn;
//    }
//
//    public TableColumn<Song, String> getArtistColumn() {
//        return artistColumn;
//    }
//
//    public TableColumn<Song, String> getSizeColumn() {
//        return sizeColumn;
//    }


    public ListView<Song> getSongListView() {
        return songListView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
