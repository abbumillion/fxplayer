package com.app.fxplayer.controllers;


import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.View;

public abstract class Controller {
    protected View view;
    public Controller(View view)
    {
        this.view = view;
    }
    // event registration behavior for every controller
    public abstract void register();
    // controller initialization behavior
    public abstract void start();
}
