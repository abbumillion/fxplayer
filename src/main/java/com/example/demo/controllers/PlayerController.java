package com.example.demo.controllers;

import views.PlayerView;
import views.View;

public class PlayerController extends Controller{
    PlayerView playerView;
    public PlayerController(View view) {
        super(view);
        playerView = (PlayerView) view;
    }

    @Override
    public void register() {

    }

    @Override
    public void start() {
        playerView.show();
    }
}
