package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.controllers.componentscontroller.PlayerControlsViewController;
import com.app.fxplayer.player.audioplayer.MediaQueue;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.NowPlayingView;

public class NowPlayingTabController extends Controller {
    private final NowPlayingView nowPlayingView;
    public NowPlayingTabController(View view) {
        super(view);
        nowPlayingView = (NowPlayingView) view;
    }

    @Override
    public void init() {
        nowPlayingView.getImageView().imageProperty().bind(MediaQueue.getCurrentSong().getImage().imageProperty());
        PlayerControlsViewController playerControlsViewController = new PlayerControlsViewController(nowPlayingView.getPlayerControlsView());
        playerControlsViewController.init();
    }

}
