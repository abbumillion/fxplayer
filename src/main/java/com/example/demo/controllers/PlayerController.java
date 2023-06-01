package com.example.demo.controllers;


import com.example.demo.views.View;
import com.example.demo.views.windows.PlayerView;

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
        playerView.showView();
    }
}
