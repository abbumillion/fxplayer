package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;

import java.io.File;

@Data
public class PlayerControlsView extends View {
    private Label startDurationLabel, endDurationLabel, songTitleLabel;
    private Button pauseButton, prevButton, nextButton, shuffleButton, repeatButton, fullScreenJFXButton, volumeButton, rateButton, balanceButton;
    private Slider durationSlider;
    private ImageView nextImage, prevImage, pauseImage, repeatImage, shuffleImage, fullscreenImage;
    private HBox hBox1, hBox2, hBox3, hBox4;
    private VBox vBox;

    @Override
    public void init() {
        startDurationLabel = new Label("strt");
        endDurationLabel = new Label("end");
        songTitleLabel = new Label("song title label");
        pauseButton = new Button("pause");
        prevButton = new Button("prev");
        nextButton = new Button("next");
        shuffleButton = new Button("shuffle");
        repeatButton = new Button("repeat");
        fullScreenJFXButton = new Button("[]");
        volumeButton = new Button("volume");
        rateButton = new Button("rate");
        balanceButton = new Button("balance");
        durationSlider = new Slider();
        nextImage = new ImageView(new Image(new File("src/main/resources/icons/next-arrow-button-icon-vector-14566227.jpg").toURI().toASCIIString()));
        prevImage = new ImageView(new Image(new File("src/main/resources/icons/37111642-previous-red-flat-icon.webp").toURI().toASCIIString()));
        pauseImage = new ImageView(new Image(new File("src/main/resources/icons/download (8).png").toURI().toASCIIString()));
        repeatImage = new ImageView(new Image(new File("src/main/resources/icons/playercontrolsicons/repeat-button-red-icon.webp").toURI().toASCIIString()));
        shuffleImage = new ImageView(new Image(new File("src/main/resources/icons/playercontrolsicons/shuffle.png").toURI().toASCIIString()));
        fullscreenImage = new ImageView(new Image(new File("src/main/resources/icons/playercontrolsicons/fullscreen.png").toURI().toASCIIString()));
        hBox1 = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox();
        hBox4 = new HBox();
        vBox = new VBox();
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(shuffleButton, repeatButton, prevButton, pauseButton, nextButton);
        hBox2.getChildren().addAll(volumeButton, rateButton, balanceButton, fullScreenJFXButton);
        hBox3.getChildren().addAll(hBox1, hBox2);
        hBox4.getChildren().addAll(startDurationLabel, durationSlider, endDurationLabel);
        getChildren().addAll(hBox4, hBox3);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        songTitleLabel.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        startDurationLabel.prefWidthProperty().bind(hBox4.widthProperty().multiply(.04));
        endDurationLabel.prefWidthProperty().bind(hBox4.widthProperty().multiply(.04));
        durationSlider.prefWidthProperty().bind(hBox4.widthProperty().multiply(.9));
        durationSlider.prefHeightProperty().bind(hBox4.heightProperty());
        shuffleButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.111025));
        repeatButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.11025));
        prevButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.11025));
        pauseButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.11025));
        nextButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.111025));
        fullScreenJFXButton.prefWidthProperty().bind(hBox1.widthProperty().multiply(.111025));
        songTitleLabel.prefWidthProperty().bind(vBox.widthProperty());
        songTitleLabel.prefHeightProperty().bind(vBox.heightProperty().multiply(.1));
        vBox.prefWidthProperty().bind(hBox3.widthProperty().multiply(.2));
        vBox.prefHeightProperty().bind(hBox3.heightProperty());
        hBox1.prefWidthProperty().bind(hBox3.widthProperty().multiply(.4));
        hBox2.prefWidthProperty().bind(hBox3.widthProperty().multiply(.4));
        hBox4.prefWidthProperty().bind(widthProperty());
        hBox4.prefHeightProperty().bind(heightProperty().multiply(.05));
        hBox3.prefWidthProperty().bind(widthProperty());
        hBox3.prefHeightProperty().bind(heightProperty().multiply(.995));
    }

    @Override
    public void styling() {
    }

}
