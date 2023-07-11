package com.app.fxplayer.controllers.viewcontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.View;

public class LoaderController extends Controller {
    // loader view instance
    private LoaderView loaderView;
    //
    public LoaderController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() {

    }
}
