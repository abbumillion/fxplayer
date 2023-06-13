package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.NowPlayingView;

public class NowPlayingTabController extends Controller {
    private NowPlayingView nowPlayingView;
    public NowPlayingTabController(View view) {
        super(view);
        nowPlayingView = (NowPlayingView) view;
    }

    @Override
    public void register() {

    }

    @Override
    public void start() {

    }
}
