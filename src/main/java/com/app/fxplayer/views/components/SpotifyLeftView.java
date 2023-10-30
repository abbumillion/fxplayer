package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import lombok.Data;

@Data
public class SpotifyLeftView extends View {
    Label topLabel,artistNameLabel,songTitleLabel;
    ImageView leftSideImageView;
    Button closeButton;
    ScrollPane scrollPane;
    @Override
    public void init() {
        topLabel = new Label("Liked Songs");
        artistNameLabel= new Label("Liked Songs");
        songTitleLabel = new Label("Liked Songs");
        leftSideImageView = new ImageView();
        closeButton = new Button("X");
        scrollPane = new ScrollPane();
    }

    @Override
    public void build() {
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        scrollPane.prefWidthProperty().bind(widthProperty());
        scrollPane.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        setPadding(new Insets(12.5));
        setMargin(this,new Insets(6.28));
    }
}
