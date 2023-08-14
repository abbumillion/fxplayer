package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.RecentlyAddedView;

import java.io.IOException;

public class RecentlyAddedTabController extends Controller {
    private RecentlyAddedView recentlyAddedView;

    public RecentlyAddedTabController(View view) {
        super(view);
        recentlyAddedView = (RecentlyAddedView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        recentlyAddedView.getRecentlyAddedListView().itemsProperty().set(SongRepository.getRecentAddedSongList());
    }
}
