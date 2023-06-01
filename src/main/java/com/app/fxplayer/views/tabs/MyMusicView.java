package com.app.fxplayer.views.tabs;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControllerView;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MyMusicView extends View {
    private PlayerControllerView playerControllerView;
    private TableView<Song> tableView;
    private TableColumn<Song,String> indexColumn,titleColumn,sizeColumn,artistsColumn,albumColumn;
    @Override
    public void init() {
        //
        tableView = new TableView<>();
        //
        indexColumn = new TableColumn<>("index");
        titleColumn = new TableColumn<>("Title");
        sizeColumn = new TableColumn<>("Size");
        artistsColumn = new TableColumn<>("Artist");
        albumColumn = new TableColumn<>("Album");
        //
        playerControllerView = new PlayerControllerView();
        //
    }

    @Override
    public void build() {
        tableView.getColumns().addAll(indexColumn,titleColumn,sizeColumn,artistsColumn,albumColumn);
        getChildren().add(tableView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        tableView.prefWidthProperty().bind(widthProperty());
        tableView.prefHeightProperty().bind(heightProperty());
    }

    public PlayerControllerView getPlayerControllerView() {
        return playerControllerView;
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

    public TableColumn<Song, String> getArtistsColumn() {
        return artistsColumn;
    }

    public TableColumn<Song, String> getSizeColumn() {
        return sizeColumn;
    }

}
