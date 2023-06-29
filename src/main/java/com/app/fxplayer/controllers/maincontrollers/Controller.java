package com.app.fxplayer.controllers.maincontrollers;


import com.app.fxplayer.views.View;

/**
 * this interface will be the
 * controller for the application
 *
 */

public abstract class Controller {
    protected View view;
    public Controller(View view)
    {
        this.view = view;
    }

    public abstract void init();
}
