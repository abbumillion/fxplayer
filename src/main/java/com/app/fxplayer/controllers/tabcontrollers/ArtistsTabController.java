package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.ArtistsView;

public class ArtistsTabController extends Controller {
    private final ArtistsView artistsView;
    public ArtistsTabController(View view) {
        super(view);
        artistsView = (ArtistsView) view;
    }

    @Override
    public void init() {

    }
}
