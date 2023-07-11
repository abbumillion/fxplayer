package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class SettingsView extends View {
    private Label titleLabel , themeLabel , fullScreenLabel , windowStyleLabel;

    @Override
    public void init() {
        titleLabel = new Label("System Settings");
        themeLabel = new Label("Themes");
        fullScreenLabel = new Label("Full Screen");
        windowStyleLabel = new Label("Window Style");
    }

    @Override
    public void build() {
        getChildren().addAll(titleLabel,themeLabel,fullScreenLabel,windowStyleLabel);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {

    }
    @Override
    public void styling() {

    }
}
