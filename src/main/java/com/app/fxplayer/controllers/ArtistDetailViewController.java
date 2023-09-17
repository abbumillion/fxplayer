package com.app.fxplayer.controllers;

import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.ArtistDetailView;
import com.app.fxplayer.views.View;

import java.io.IOException;


public class ArtistDetailViewController extends Controller {
    private final ArtistDetailView artistDetailView;

    public ArtistDetailViewController(View view) {
        super(view);
        artistDetailView = (ArtistDetailView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        artistDetailView.getAlbumListView().itemsProperty().set(SongRepository.getAlbumList());
        artistDetailView.getArtistImageImageView().setImage(Player.getCurrentSong().getSongImage());
        artistDetailView.changeScene(artistDetailView);
    }
}
