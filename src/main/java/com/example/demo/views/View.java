package com.example.demo.views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public abstract class View extends VBox implements Viewable {

    public View(){}
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
        STAGE.setScene(scene);
        STAGE.show();
    }
}
