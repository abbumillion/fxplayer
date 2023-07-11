package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repository.SongRepository;
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
//        myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
        myMusicView.getSongListView().itemsProperty().bind(SongRepository.getSongList().itemsProperty());
        myMusicView.getSongListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1,
                                                                                              song2) ->
        {
            if (song2 != null)
            {
                player.play(new Media(new File(song2.getSource()).toURI().toASCIIString()));
            }
        });
    }
}
