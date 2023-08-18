package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MostPlayedView;

import java.io.IOException;

public class MostPlayedTabController extends Controller {
    private MostPlayedView mostPlayedView;

    public MostPlayedTabController(View view) {
        super(view);
        mostPlayedView = (MostPlayedView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
//        mostPlayedView.getMostPlayedListView().itemsProperty().set(SongRepository.getMostPlayedSongList());
    }
}
