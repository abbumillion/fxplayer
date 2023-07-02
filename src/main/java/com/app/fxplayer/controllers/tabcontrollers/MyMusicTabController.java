package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.models.collectors.Collector;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MyMusicView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;
    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void init() {
//        myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("title"));

    }
}
