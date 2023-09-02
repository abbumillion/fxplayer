package com.app.fxplayer.views;

import com.app.fxplayer.models.Song;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoaderView extends View {
    private ProgressIndicator progressIndicator;
    @Override
    public void init() {
        progressIndicator = new ProgressIndicator();
//        getStartedButton = new Button("Get Started");
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
        progressIndicator.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
    }
}
