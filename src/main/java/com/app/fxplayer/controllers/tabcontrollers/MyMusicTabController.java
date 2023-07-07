package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.MyMusicView;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;
    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void init() {
//        myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
        myMusicView.getSongListView().itemsProperty().bind(Collector.getSongListView().itemsProperty());
    }
}
