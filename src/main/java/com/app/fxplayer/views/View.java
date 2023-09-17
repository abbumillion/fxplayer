package com.app.fxplayer.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import java.io.File;

public abstract class View extends VBox implements Viewable {

    public View() {
        getReady();
        setAlignment(Pos.CENTER);
        setSpacing(6.28);
        setPadding(new Insets(2.25));
    }

    public void getReady() {
        init();
        build();
        bind();
        align();
        styling();
    }


    public void setFullScreen() {
        STAGE.setFullScreen(!STAGE.isFullScreen());
    }

    public void showView() {
        Scene scene = new Scene(this, WIDTH, HEIGHT);
        String StringConstants = "src/main/resources/stylesheets/dark.css";
        scene.getStylesheets().add(new File(StringConstants).toURI().toASCIIString());
        STAGE.setScene(scene);
//        STAGE.setTitle(StringConstants.getSystemTitle());
//        STAGE.getIcons().add(new Image(new File(StringConstants.getSystemIcon()).toURI().toASCIIString()));
        STAGE.show();
    }

    public void hideView() {
        STAGE.close();
    }
}
