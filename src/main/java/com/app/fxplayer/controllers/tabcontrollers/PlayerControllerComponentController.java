package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControllerView;

public class PlayerControllerComponentController extends Controller {
    private PlayerControllerView playerControllerView;
    public PlayerControllerComponentController(View view) {
        super(view);
        playerControllerView = (PlayerControllerView) view;
    }

    @Override
    public void register() {
        playerControllerView.getFullScreenButton().setOnAction(actionEvent -> {
            playerControllerView.setFullScreen();
        });
    }

    @Override
    public void start() {

    }
}
