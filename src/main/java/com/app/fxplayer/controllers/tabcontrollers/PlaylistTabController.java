package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.PlaylistView;

import java.io.IOException;

public class PlaylistTabController extends Controller {
    private PlaylistView playlistView;

    public PlaylistTabController(View view) {
        super(view);
        playlistView = (PlaylistView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        playlistView.getPlaylistListView().itemsProperty().set(SongRepository.getPlaylistList());
    }
}
