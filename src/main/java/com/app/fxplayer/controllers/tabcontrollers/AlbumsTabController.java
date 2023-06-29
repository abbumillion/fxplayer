package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.models.collectors.Collector;
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

    }
}
