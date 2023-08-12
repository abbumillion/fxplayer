package com.app.fxplayer.controllers.viewcontroller;


import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.controllers.tabcontrollers.*;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

public class PlayerViewController extends Controller {
    private final PlayerView playerView;

    public PlayerViewController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void init() {
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
        Player.setPlayerView(playerView);
        playerView.showView();
    }


}
