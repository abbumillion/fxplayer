package com.app.fxplayer.views;

import com.app.fxplayer.helpers.StringConstants;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.io.File;

public class LoaderView extends View{
    private ListView loaderListView;
    @Override
    public void init() {
        loaderListView = new ListView<>();
    }

    @Override
    public void build() {
        getChildren().addAll(loaderListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        loaderListView.prefWidthProperty().bind(widthProperty());
        loaderListView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        loaderListView.setCellFactory(songListView -> new SongCell());
    }
@Override
    public void showView()
{
        Scene scene = new Scene(this,WIDTH,HEIGHT);
        STAGE.setScene(scene);
        STAGE.setTitle(StringConstants.getSystemTitle());
        STAGE.getIcons().add(new Image(new File(StringConstants.getSystemIcon()).toURI().toASCIIString()));
        STAGE.setFullScreen(true);
        STAGE.initStyle(StageStyle.UNDECORATED);
        STAGE.show();
    }

    public ListView getLoaderListView() {
        return loaderListView;
    }

}
