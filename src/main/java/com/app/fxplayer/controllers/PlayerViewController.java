package com.app.fxplayer.controllers;


import com.app.fxplayer.controllers.componentscontroller.ToolbarViewController;
import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

import java.io.IOException;

public class PlayerViewController extends Controller {
    private final PlayerView playerView;

    public PlayerViewController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void init() throws IOException, InterruptedException {
        MyMusicTabController myMusicTabController = new MyMusicTabController(playerView.getMyMusicView());
        myMusicTabController.init();
        NowPlayingTabController nowPlayingTabController = new NowPlayingTabController(playerView.getNowPlayingView());
        nowPlayingTabController.init();
        AlbumsTabController albumsTabController = new AlbumsTabController(playerView.getAlbumsView());
        albumsTabController.init();
        ArtistsTabController artistsTabController = new ArtistsTabController(playerView.getArtistsView());
        artistsTabController.init();
        SettingsTabController settingsTabController = new SettingsTabController(playerView.getSettingsView());
        settingsTabController.setPlayerView(playerView);
        settingsTabController.init();
        RecentPlaysTabController recentPlaysTabController = new RecentPlaysTabController(playerView.getRecentPlaysView());
        recentPlaysTabController.init();
        RecentlyAddedTabController recentlyAddedTabController = new RecentlyAddedTabController(playerView.getRecentlyAddedView());
        recentlyAddedTabController.init();
        PlaylistTabController playlistTabController = new PlaylistTabController(playerView.getPlaylistView());
        playlistTabController.init();
        MostPlayedTabController mostPlayedTabController = new MostPlayedTabController(playerView.getMostPlayedView());
        mostPlayedTabController.init();
        ToolbarViewController toolbarViewController = new ToolbarViewController(playerView.getToolBarView());
        toolbarViewController.init();
//        Player.setPlayerView(playerView);
        playerView.showView();
    }


}
