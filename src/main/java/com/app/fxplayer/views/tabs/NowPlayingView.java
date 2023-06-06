package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.time.Duration;

public class NowPlayingView extends View {
    // image view
    private ImageView imageView;
    //

    @Override
    public void init() {
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
    }

    @Override
    public void build() {
        getChildren().addAll(imageView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void bind() {
        //
        imageView.fitWidthProperty().bind(widthProperty().multiply(.8));
        imageView.fitHeightProperty().bind(heightProperty().multiply(.75));
        //
    }
    @Override
    public void styling() {

    }

}
