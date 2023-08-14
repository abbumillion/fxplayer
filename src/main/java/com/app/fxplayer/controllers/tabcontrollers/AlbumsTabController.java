package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.AlbumsView;

public class AlbumsTabController extends Controller {
    private final AlbumsView albumsView;

    public AlbumsTabController(View view) {
        super(view);
        albumsView = (AlbumsView) view;
    }

    @Override
    public void init() {
        albumsView.getAlbumListView().itemsProperty().set(SongRepository.getAlbumList());
    }
}
