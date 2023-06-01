package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class VisualizationView extends View {
    private Circle circle1,circle2;
    private HBox hBox;
    @Override
    public void init() {
        circle1 = new Circle();
        circle2 = new Circle();
        hBox = new HBox();
    }

    @Override
    public void build() {
        hBox.getChildren().addAll(circle1,circle2);
        getChildren().add(hBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        hBox.prefWidthProperty().bind(widthProperty());
        hBox.prefHeightProperty().bind(heightProperty());
    }
}
