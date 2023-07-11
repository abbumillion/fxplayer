package com.app.fxplayer.views;

import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Viewable {
    Stage STAGE = new Stage();
    double WIDTH  = Screen.getPrimary().getBounds().getWidth() * .880;
    double HEIGHT  = Screen.getPrimary().getBounds().getHeight() * .760;
    void init();
    void build();
    void align();
    void bind();
    void styling();
}
