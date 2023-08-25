package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CanvasVisualizationView extends View {
    private Canvas canvas;
    @Override
    public void init() {
        canvas = new Canvas();
    }

    @Override
    public void build() {
        getChildren().addAll(canvas);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {

    }
}
