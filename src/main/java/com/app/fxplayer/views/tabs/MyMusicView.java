package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import lombok.Data;

import java.io.File;
@Data
public class MyMusicView extends View {
    //
    private ImageView imageView;
    //
    private ListView<Song> songListView;

    private TableColumn<Song, String> titleColumn,sizeColumn,artistColumn,albumColumn;
    //
    //
    private HBox hBox;
    @Override
    public void init() {
        //
        songListView = new ListView<>();
        //
//        indexColumn = new TableColumn<>("index");
//        titleColumn = new TableColumn<>("title");
//        sizeColumn = new TableColumn<>("size");
//        artistColumn = new TableColumn<>("artist");
//        albumColumn = new TableColumn<>("album");
//        tableView = new ListView<>();
        //
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
        //
        hBox = new HBox();

    }

    @Override
    public void build() {
//        tableView.getColumns().addAll(titleColumn,sizeColumn,artistColumn,albumColumn);
        hBox.getChildren().addAll(imageView,songListView);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        hBox.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void bind() {
        imageView.fitWidthProperty().bind(hBox.widthProperty().multiply(.4));
        imageView.fitHeightProperty().bind(hBox.heightProperty());
        songListView.prefWidthProperty().bind(hBox.widthProperty().multiply(.6));
        songListView.prefHeightProperty().bind(hBox.heightProperty());
        hBox.prefWidthProperty().bind(widthProperty());
        hBox.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {
        songListView.setCellFactory(songListView -> new SongCell());
    }


}
