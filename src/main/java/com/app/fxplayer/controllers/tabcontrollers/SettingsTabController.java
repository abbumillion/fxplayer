package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.SettingsView;

public class SettingsTabController extends Controller {
    private final SettingsView settingsView;
    public SettingsTabController(View view) {
        super(view);
        settingsView = (SettingsView) view;
    }

    @Override
    public void register() {

    }

    @Override
    public void start() {

    }
}
