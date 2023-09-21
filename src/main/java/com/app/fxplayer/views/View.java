package com.app.fxplayer.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.io.File;

public abstract class View extends VBox implements Viewable {

    public View() {
        getReady();
        setAlignment(Pos.CENTER);
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
    // change the scene of the applications view
    public void changeScene(View root) {
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        String StringConstants = "src/main/resources/stylesheets/style.css";
        scene.getStylesheets().add(new File(StringConstants).toURI().toASCIIString());
        STAGE.setScene(scene);
    }


    public void showView() {
        Scene scene = new Scene(this, WIDTH, HEIGHT);
        String StringConstants = "src/main/resources/stylesheets/dark.css";
//        scene.getStylesheets().add(new File(StringConstants).toURI().toASCIIString());
        STAGE.setScene(scene);
//        STAGE.initStyle(StageStyle.UNDECORATED);
//        STAGE.setTitle(StringConstants.getSystemTitle());
//        STAGE.getIcons().add(new Image(new File(StringConstants.getSystemIcon()).toURI().toASCIIString()));
        STAGE.show();
    }

    public void hideView() {
        STAGE.close();
    }
}
