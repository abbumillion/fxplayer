package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.maincontrollers.Controller;
import com.app.fxplayer.models.collectors.Collector;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.listcells.SongCell;
import com.app.fxplayer.views.tabs.MyMusicView;

public class MyMusicTabController extends Controller {
    private final MyMusicView myMusicView;
    public MyMusicTabController(View view) {
        super(view);
        myMusicView = (MyMusicView) view;
    }

    @Override
    public void register() {
//        myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
//        myMusicView.getArtistColumn().setCellValueFactory(new PropertyValueFactory<>("artist"));
//        myMusicView.getAlbumColumn().setCellValueFactory(new PropertyValueFactory<>("album"));
//        myMusicView.getIndexColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
        myMusicView.getSongListView().setCellFactory(e->new SongCell());
    }

    @Override
    public void start() {
        myMusicView.getSongListView().itemsProperty().bind(Collector.getFileListview().itemsProperty());
    }
}
