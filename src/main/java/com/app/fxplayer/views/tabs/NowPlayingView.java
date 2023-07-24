package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.PlayerControlsView;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class NowPlayingView extends View {
    // image view
    private ImageView imageView;
    private PlayerControlsView playerControlsView;
    //

    @Override
    public void init() {
        playerControlsView = new PlayerControlsView();
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

    public ImageView getImageView() {
        return imageView;
    }

    public PlayerControlsView getPlayerControlsView() {
        return playerControlsView;
    }
}
