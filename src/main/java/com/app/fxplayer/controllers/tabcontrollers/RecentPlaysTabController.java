package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.RecentPlaysView;

public class RecentPlaysTabController extends Controller {
    private RecentPlaysView recentPlaysView;

    public RecentPlaysTabController(View view) {
        super(view);
        recentPlaysView = (RecentPlaysView) view;
    }

    @Override
    public void init() {
        recentPlaysView.getRecentPlaysListView().itemsProperty().set(SongRepository.getRecentPlaysSongList());
    }
}
