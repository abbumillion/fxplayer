package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;

public class MyMusicView extends View {
    //
    private ImageView imageView;
    //
    private TableView<Song> tableView;
    //
    private TableColumn<Song,String> indexColumn,titleColumn,sizeColumn,artistColumn,albumColumn;
    //
    private HBox hBox;
    @Override
    public void init() {
        //
        tableView = new TableView<>();
        //
        indexColumn = new TableColumn<>("index");
        titleColumn = new TableColumn<>("title");
        sizeColumn = new TableColumn<>("Size");
        artistColumn = new TableColumn<>("artist");
        albumColumn = new TableColumn<>("album");
        //
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
        //
        hBox = new HBox();

    }

    @Override
    public void build() {
        tableView.getColumns().addAll(indexColumn,titleColumn,sizeColumn,artistColumn,albumColumn);
        hBox.getChildren().addAll(imageView,tableView);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //imageview
        imageView.fitWidthProperty().bind(hBox.widthProperty().multiply(.4));
        imageView.fitHeightProperty().bind(hBox.heightProperty());
        //tableview
        tableView.prefWidthProperty().bind(hBox.widthProperty().multiply(.6));
        tableView.prefHeightProperty().bind(hBox.heightProperty());
        //
        hBox.prefWidthProperty().bind(widthProperty());
        hBox.prefHeightProperty().bind(heightProperty());
        //
    }
    @Override
    public void styling() {

    }


    public TableColumn<Song, String> getIndexColumn() {
        return indexColumn;
    }

    public TableView<Song> getTableView() {
        return tableView;
    }

    public TableColumn<Song, String> getAlbumColumn() {
        return albumColumn;
    }

    public TableColumn<Song, String> getTitleColumn() {
        return titleColumn;
    }

    public TableColumn<Song, String> getArtistColumn() {
        return artistColumn;
    }

    public TableColumn<Song, String> getSizeColumn() {
        return sizeColumn;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
