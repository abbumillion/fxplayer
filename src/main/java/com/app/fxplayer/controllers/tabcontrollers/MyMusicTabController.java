package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.MediaQueue;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MyMusicView;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;
    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void init() {
        myMusicView.getSongListView().itemsProperty().bind(ModelRepository.getSongList().itemsProperty());
        myMusicView.getSongListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
        {
            if (song2 != null)
            {
                // current song
                MediaQueue.setCurrentSong(song2);
                Player.play();
                //
            }
        });
    }
}
