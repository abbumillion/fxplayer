package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.scene.control.Label;
import lombok.Data;

@Data
public class PlaylistView extends View {
    private Label label;
    @Override
    public void init() {
        label = new Label("playlists");
    }

    @Override
    public void build() {
        getChildren().add(label);
    }

    @Override
    public void align() {

    }

    @Override
    public void bind() {

    }
    @Override
    public void styling() {

    }
}
