package com.app.fxplayer.views;

import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Viewable {
    // main windows stage
    Stage STAGE = new Stage();
    // screen width
    double WIDTH  = Screen.getPrimary().getBounds().getWidth() * .480;
    // screen height
    double HEIGHT  = Screen.getPrimary().getBounds().getHeight() * .360;
    // initialization
    void init();
    // building layout
    void build();
    // elements alignment
    void align();
    // binding elements
    void bind();

}
