package com.app.fxplayer.controllers;


import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.View;

public abstract class Controller {
    protected View view;
    protected Player player;
    public Controller(View view)
    {
        this.view = view;
        player = new Player();
    }
    public abstract void init();
}
