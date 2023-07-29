package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;

public class LoaderView extends View{
    private ListView loaderListView;
    @Override
    public void init() {
        loaderListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(loaderListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //
//        playerControlsView.prefWidthProperty().bind(widthProperty());
//        playerControlsView.prefHeightProperty().bind(heightProperty().multiply(.15));
        //
        loaderListView.prefWidthProperty().bind(widthProperty());
        loaderListView.prefHeightProperty().bind(heightProperty().multiply(.85));
        //
    }

    @Override
    public void styling() {
        loaderListView.setCellFactory(songListView -> new SongCell());
    }


    public ListView getLoaderListView() {
        return loaderListView;
    }

//    public PlayerControlsView getPlayerControlsView() {
//        return playerControlsView;
//    }
}
