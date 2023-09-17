package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import lombok.*;

import java.io.File;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class NowPlayingView extends View {
    private ImageView imageView;
    private BackgroundImage backgroundImage;

    @Override
    public void init() {
        imageView = new ImageView(new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString()));
        backgroundImage = new BackgroundImage(
                new Image(new File("src/main/resources/images/sample.jpg").toURI().toASCIIString(), widthProperty().get(), heightProperty().get(), true, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
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
        imageView.fitWidthProperty().bind(widthProperty().multiply(.48));
        imageView.fitHeightProperty().bind(heightProperty().multiply(.42));
    }

    @Override
    public void styling() {
        setBackground(new Background(backgroundImage));
    }

    public ImageView getImageView() {
        return imageView;
    }


}
