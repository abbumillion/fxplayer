package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MyMusicView;

import java.util.Date;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;

    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void init() {
        myMusicView.getSongListView().itemsProperty().set(SongRepository.getSongList());
        myMusicView.getSongListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
        {
            if (song2 != null) {
                Player.setCurrentSong(song2);
                song2.setLastPlayedDate(new Date());
                song2.setNumberOfPlays(song2.getNumberOfPlays() + 1);
                Player.play();
            }
        });
    }
}
