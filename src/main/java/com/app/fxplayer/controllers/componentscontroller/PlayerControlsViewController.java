package com.app.fxplayer.controllers.componentscontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControlsView;

public class PlayerControlsViewController extends Controller {
    private PlayerControlsView playerControlsView;

    public PlayerControlsViewController(View view) {
        super(view);
        playerControlsView = (PlayerControlsView) view;
    }

    @Override
    public void init() {
        playerControlsView.getFullScreenJFXButton().setOnAction(event -> {
            view.setFullScreen();
        });
    }

    private void play() {
        Player.play();
//        player.play();
    }

    private void prev() {
//        System.out.println("prev");
        Player.prev();
//        player.prev();
    }

    private void next() {
//        System.out.println("next");
        Player.next();
//        player.next();
    }

    private void shuffle() {
        System.out.println("shuffle");
    }

    private void repeat() {
        System.out.println("repeat");
    }
}
