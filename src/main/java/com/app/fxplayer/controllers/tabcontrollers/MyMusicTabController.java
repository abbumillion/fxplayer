package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MyMusicView;
import javafx.scene.media.Media;

import java.io.File;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;
    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void init() {
//        myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
////        myMusicView.getIndexColumn().setCellValueFactory(new PropertyValueFactory<>("size"));
//        myMusicView.getAlbumColumn().setCellValueFactory(new PropertyValueFactory<>("album"));
//        myMusicView.getArtistColumn().setCellValueFactory(new PropertyValueFactory<>("artist"));
        myMusicView.getSongListView().itemsProperty().bind(Collector.getSongListView().itemsProperty());
        myMusicView.getSongListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
        {
            if (song2 != null)
            {
                player.getMediaQueue().add(new Media(new File(song2.getSource()).toURI().toASCIIString()));
                player.play();
            }
        });
    }
}
