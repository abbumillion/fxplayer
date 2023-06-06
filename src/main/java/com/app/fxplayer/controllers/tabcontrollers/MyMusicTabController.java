package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.models.Collector;
import com.app.fxplayer.models.Song;
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
    public void register() {
      //  myMusicView.getTitleColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
      //  myMusicView.getArtistColumn().setCellValueFactory(new PropertyValueFactory<>("artist"));
      //  myMusicView.getAlbumColumn().setCellValueFactory(new PropertyValueFactory<>("album"));
//        myMusicView.getIndexColumn().setCellValueFactory(new PropertyValueFactory<>("title"));
    }

    @Override
    public void start() {
        myMusicView.getTableView().itemsProperty().bind(Collector.getFileListview().itemsProperty());
    }
}
