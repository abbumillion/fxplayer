package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import com.jfoenix.controls.JFXListView;
import javafx.geometry.Pos;

public class RecentPlaysView extends View {
    private JFXListView recentPlaysJFXListView;
    @Override
    public void init() {
        recentPlaysJFXListView = new JFXListView<>();
    }

    @Override
    public void build() {
        getChildren().add(recentPlaysJFXListView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        recentPlaysJFXListView.prefWidthProperty().bind(widthProperty());
        recentPlaysJFXListView.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {

    }

    public JFXListView getRecentPlaysJFXListView() {
        return recentPlaysJFXListView;
    }
}
