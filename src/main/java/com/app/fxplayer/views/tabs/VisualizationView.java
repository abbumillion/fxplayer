package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class VisualizationView extends View {
    private Circle circle;
    @Override
    public void init() {
        circle = new Circle(100);
    }

    @Override
    public void build() {
        getChildren().add(circle);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //

//        hBox.prefWidthProperty().bind(widthProperty());
//        hBox.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {

    }

    public Circle getCircle() {
        return circle;
    }
}
