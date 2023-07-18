package com.app.fxplayer.controllers.viewcontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControlsView;

public class PlayerControlsViewController extends Controller {
    private PlayerControlsView playerControlsView ;
    public PlayerControlsViewController(View view) {
        super(view);
        playerControlsView = (PlayerControlsView) view;
    }

    @Override
    public void init() {
        if ( player.getMediaPlayer() != null) {
            playerControlsView.getPauseButton().setOnAction(actionEvent -> play());
            playerControlsView.getPrevButton().setOnAction(actionEvent -> prev());
            playerControlsView.getNextButton().setOnAction(actionEvent -> next());
            playerControlsView.getShuffleButton().setOnAction(actionEvent -> shuffle());
            playerControlsView.getRepeatButton().setOnAction(actionEvent -> repeat());
            playerControlsView.getFullScreenJFXButton().setOnAction(actionEvent -> view.setFullScreen());
//        playerControlsView.getPauseButton().setOnAction(actionEvent -> (pause()));
        }
    }

    private void play() {
        player.play();
    }

    private void prev() {
        player.prev();
    }

    private void next()
    {
        player.next();
    }

    private void shuffle()
    {

    }

    private void repeat() {
    }
}
