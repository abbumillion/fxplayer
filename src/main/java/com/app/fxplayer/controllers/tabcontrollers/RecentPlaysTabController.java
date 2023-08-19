package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.RecentPlaysView;
import java.util.Date;

public class RecentPlaysTabController extends Controller {
    private final RecentPlaysView recentPlaysView;

    public RecentPlaysTabController(View view) {
        super(view);
        recentPlaysView = (RecentPlaysView) view;
    }

    @Override
    public void init() {
        recentPlaysView.getRecentPlaysListView().itemsProperty().set(SongRepository.getSongList());
        recentPlaysView.getRecentPlaysListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
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
