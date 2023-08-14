package com.app.fxplayer.views;

import javafx.geometry.Pos;
import javafx.scene.control.ProgressIndicator;
import lombok.Data;

@Data
public class LoaderView extends View {
    private ProgressIndicator progressIndicator;

    @Override
    public void init() {
        progressIndicator = new ProgressIndicator();
    }

    @Override
    public void build() {
        getChildren().addAll(progressIndicator);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        progressIndicator.prefWidthProperty().bind(widthProperty());
        progressIndicator.prefHeightProperty().bind(heightProperty().multiply(.85));
    }

    @Override
    public void styling() {
    }


}
