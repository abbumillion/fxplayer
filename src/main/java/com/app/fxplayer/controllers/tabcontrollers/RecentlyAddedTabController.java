package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.RecentlyAddedView;

import java.io.IOException;
import java.util.Date;

public class RecentlyAddedTabController extends Controller {
    private final RecentlyAddedView recentlyAddedView;

    public RecentlyAddedTabController(View view) {
        super(view);
        recentlyAddedView = (RecentlyAddedView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        recentlyAddedView.getRecentlyAddedListView().itemsProperty().set(SongRepository.getSongList());
        recentlyAddedView.getRecentlyAddedListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
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
