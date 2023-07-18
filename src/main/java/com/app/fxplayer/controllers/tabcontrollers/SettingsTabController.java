package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.SettingsView;
import javafx.geometry.Side;

public class SettingsTabController extends Controller {
    private  SettingsView settingsView;
    private PlayerView playerView;
    public SettingsTabController(View view) {
        super(view);
        settingsView = (SettingsView) view;
    }

    @Override
    public void init() {
        settingsView.getTabSideSyleComboBox().getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->
        {
            playerView.getTabPane().setSide(Side.valueOf(t1));
        });
    }

    public void setPlayerView(PlayerView playerView) {
        this.playerView = playerView;
    }
}
