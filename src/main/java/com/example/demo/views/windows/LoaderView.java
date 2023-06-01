package com.example.demo.views.windows;

import com.example.demo.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

import java.io.File;
import java.net.MalformedURLException;

public class LoaderView extends View {
    private Label progressMessageLabel,loaderTitleLabel;
    private ProgressBar progressBar;
    private ImageView imageView;
    @Override
    public void init() {
        progressBar = new ProgressBar();
        progressMessageLabel = new Label("Starting the application...");
        loaderTitleLabel = new Label("progress message");
        try {
            imageView = new ImageView(new Image(new File("images/mixer@2x.png").toURI().toURL().toExternalForm()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void build() {
        getChildren().addAll(loaderTitleLabel,imageView,progressMessageLabel,progressBar);

    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        loaderTitleLabel.setTextAlignment(TextAlignment.CENTER);
        progressMessageLabel.setTextAlignment(TextAlignment.CENTER);
        imageView.setPreserveRatio(true);
    }

    @Override
    public void bind() {
        //
        loaderTitleLabel.prefWidthProperty().bind(widthProperty());
        loaderTitleLabel.prefHeightProperty().bind(heightProperty().multiply(.1));
        //
        progressMessageLabel.prefWidthProperty().bind(widthProperty());
        progressMessageLabel.prefHeightProperty().bind(heightProperty().multiply(.1));
        //
        progressBar.prefWidthProperty().bind(widthProperty());
        progressBar.prefHeightProperty().bind(heightProperty().multiply(.1));
        //
        imageView.fitWidthProperty().bind(widthProperty());
        imageView.fitHeightProperty().bind(heightProperty().multiply(.6));
    }

    public Label getProgressMessageLabel() {
        return progressMessageLabel;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Label getLoaderTitleLabel() {
        return loaderTitleLabel;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}
