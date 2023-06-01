package com.example.demo.views;

import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Viewable {
    // main windows stage
    Stage STAGE = new Stage();
    // screen width
    double WIDTH  = Screen.getPrimary().getBounds().getWidth();
    // screen height
    double HEIGHT  = Screen.getPrimary().getBounds().getHeight();
    //
    void init();
    void build();
    void align();
    void bind();

}
