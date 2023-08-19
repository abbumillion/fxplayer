package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MostPlayedView;

import java.io.IOException;
import java.util.Date;

public class MostPlayedTabController extends Controller {
    private final MostPlayedView mostPlayedView;

    public MostPlayedTabController(View view) {
        super(view);
        mostPlayedView = (MostPlayedView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        mostPlayedView.getMostPlayedListView().itemsProperty().set(SongRepository.getSongList());
        mostPlayedView.getMostPlayedListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
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
