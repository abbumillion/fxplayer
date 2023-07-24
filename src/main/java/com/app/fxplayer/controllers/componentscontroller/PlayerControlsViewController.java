package com.app.fxplayer.controllers.componentscontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControlsView;

public class PlayerControlsViewController extends Controller {
    private final PlayerControlsView playerControlsView ;
    public PlayerControlsViewController(View view) {
        super(view);
        playerControlsView = (PlayerControlsView) view;
    }

    @Override
    public void init() {
        Player.getMediaPlayer().setOnReady( () -> {
            playerControlsView.getPauseButton().setOnAction(actionEvent -> play());
            playerControlsView.getPrevButton().setOnAction(actionEvent -> prev());
            playerControlsView.getNextButton().setOnAction(actionEvent -> next());
            playerControlsView.getShuffleButton().setOnAction(actionEvent -> shuffle());
            playerControlsView.getRepeatButton().setOnAction(actionEvent -> repeat());
            playerControlsView.getFullScreenJFXButton().setOnAction(actionEvent -> view.setFullScreen());
            playerControlsView.getVolumeSlider().valueProperty().bind(Player.getMediaPlayer().volumeProperty());
            playerControlsView.getBalanceSlider().valueProperty().bind(Player.getMediaPlayer().balanceProperty());
        });

    }

    private void play() {
        Player.play();
    }

    private void prev() {
        Player.prev();
    }

    private void next()
    {
        Player.next();
    }

    private void shuffle()
    {
        System.out.println("shuffle");
    }

    private void repeat() {
        System.out.println("repeat");
    }
}
