package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.player.visualization.AudioPlayerSpectrumListener;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.VisualizationView;

public class VisualizationTabController extends Controller {
    private VisualizationView visualizationView;
    public VisualizationTabController(View view) {
        super(view);
        visualizationView = (VisualizationView) view;
    }

    @Override
    public void init() {
        // passing visualization to audio spectrum listner for updating the view


    }
}
