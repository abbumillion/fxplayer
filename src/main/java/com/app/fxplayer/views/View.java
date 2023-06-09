package com.app.fxplayer.views;

import com.app.fxplayer.helpers.StringConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.io.File;

/**
 * base abstract class for all
 * view classes
 */
public abstract class View extends VBox implements Viewable {

    public View(){
        getReady();
        setAlignment(Pos.CENTER);
        setSpacing(0.25);
        setPadding(new Insets(0.25));
    }
    public void getReady()
    {
        //
        init();
        //
        build();
        //
        bind();
        //
        align();
        //
        styling();
    }

    /**
     * full screen function here
     */
    public void setFullScreen()
    {
        STAGE.setFullScreen(!STAGE.isFullScreen());
    }

    /**
     * view the app window
     */
    public void showView()
    {
        Scene scene = new Scene(this,WIDTH,HEIGHT);
        scene.getStylesheets().add(new File(StringConstants.getSystemTheme()).toURI().toASCIIString());
        scene.getStylesheets().add("http://fonts.googleapis.com/css?family=Gafata");
        STAGE.setScene(scene);
//        STAGE.initModality(Modality.APPLICATION_MODAL);
        STAGE.setTitle(StringConstants.getSystemTitle());
        STAGE.getIcons().add(new Image(new File(StringConstants.getSystemIcon()).toURI().toASCIIString()));
//        STAGE.setFullScreen(true);
//        STAGE.initStyle(StageStyle.UNDECORATED);
        STAGE.show();
    }
}
