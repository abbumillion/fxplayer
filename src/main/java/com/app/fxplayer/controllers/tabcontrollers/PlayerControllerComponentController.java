package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControllerView;

public class PlayerControllerComponentController extends Controller {
    private final PlayerControllerView playerControllerView;
    public PlayerControllerComponentController(View view) {
        super(view);
        playerControllerView = (PlayerControllerView) view;
    }

    @Override
    public void register() {
//        playerControllerView.getFullScreenButton().setOnAction(actionEvent -> {
//            playerControllerView.setFullScreen();
//        });
        playerControllerView.getNextButton().setOnAction(actionEvent -> System.out.println("next"));
        playerControllerView.getPauseButton().setOnAction(actionEvent -> System.out.println("pause"));
        playerControllerView.getPrevButton().setOnAction(actionEvent -> System.out.println("prev"));
        playerControllerView.getRepeatButton().setOnAction(actionEvent -> System.out.println("repeat"));
        playerControllerView.getShuffleButton().setOnAction(actionEvent -> System.out.println("shuffle"));
//        playerControllerView.getBackwardButton().setOnAction(actionEvent -> {System.out.println("backward");});
//        playerControllerView.getForwardButton().setOnAction(actionEvent -> {System.out.println("forward");});
    }

    @Override
    public void start() {

    }
}
