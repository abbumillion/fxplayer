package com.app.fxplayer.views;

import com.app.fxplayer.helpers.StringConstants;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.File;

public abstract class View extends VBox implements Viewable {

    public View(){
        getReady();
    }
    public void getReady()
    {
        init();
        build();
        bind();
        align();
    }

    public void showView()
    {
        Scene scene = new Scene(this,WIDTH,HEIGHT);
        scene.getStylesheets().add(new File(StringConstants.getSystemTheme()).toURI().toASCIIString());
        STAGE.setScene(scene);
        STAGE.show();
    }
}
