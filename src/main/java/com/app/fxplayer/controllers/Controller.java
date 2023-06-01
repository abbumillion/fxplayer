package com.app.fxplayer.controllers;


import com.app.fxplayer.views.View;

public abstract class Controller {
    private View view;
    public Controller(View view)
    {
        this.view = view;
    }
    // event registration behavior for every controller
    public abstract void register();
    // controller initialization behavior
    public abstract void start();
}
