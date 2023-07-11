package com.app.fxplayer.controllers.componentcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControlsView;

public class PlayerControlsController extends Controller {
    private final PlayerControlsView playerControlsView;
    public PlayerControlsController(View view) {
        super(view);
        playerControlsView = (PlayerControlsView) view;
    }

    @Override
    public void init() {
//        player.getMediaPlayer().setOnReady(()->{
            playerControlsView.getNextButton().setOnAction(actionEvent -> System.out.println("next..."));
            playerControlsView.getPauseButton().setOnAction(actionEvent -> System.out.println("pause..."));
            playerControlsView.getPrevButton().setOnAction(actionEvent -> System.out.println("prev..."));
            playerControlsView.getRepeatButton().setOnAction(actionEvent -> System.out.println("repeat..."));
            playerControlsView.getShuffleButton().setOnAction(actionEvent -> System.out.println("shuffle..."));
        //    playerControlsView.getBalanceSlider().valueProperty().bind(player.getMediaPlayer().balanceProperty());
         //   playerControlsView.getRateSlider().valueProperty().bind(player.getMediaPlayer().rateProperty());
         //   playerControlsView.getVolumeSlider().valueProperty().bind(player.getMediaPlayer().volumeProperty());
    //    });

    }


}
