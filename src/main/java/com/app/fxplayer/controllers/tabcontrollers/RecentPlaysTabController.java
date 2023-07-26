package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.RecentPlaysView;

public class RecentPlaysTabController extends Controller {
    /**
     * RECENT PLAYS VIEW INSTANCE
     */
    private RecentPlaysView recentPlaysView;
    public RecentPlaysTabController(View view) {
        super(view);
        recentPlaysView = (RecentPlaysView) view;
    }

    @Override
    public void init() {
        recentPlaysView.getRecentPlaysJFXListView().itemsProperty().bind(ModelRepository.getSongList().itemsProperty());
    }
}
