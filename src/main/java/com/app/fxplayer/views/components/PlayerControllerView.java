package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;

/**
 * PLAYER CONTROLLER VIEW
 */
public class PlayerControllerView extends View {
    private Label startDurationLabel,endDurationLabel,volumeLevelLabel;
    private Button pauseButton,prevButton,nextButton,shuffleButton,repeatButton,
            fullScreenButton,playlistButton,forwardButton,backwardButton;
    private Slider durationSlider,volumeSlider;
    private Image nextImage,prevImage,pauseImage,playlistImage,repeatImage,shuffleImage,forwardImage,backwardImage;
    private HBox hBox1,hBox2;
    @Override
    public void init() {
        // labels
        startDurationLabel = new Label("start");
        endDurationLabel = new Label("end");
        volumeLevelLabel = new Label("vol");
        // buttons
        pauseButton = new Button();
        prevButton = new Button();
        nextButton = new Button();
        forwardButton = new Button();
        backwardButton = new Button();
        playlistButton = new Button();
        shuffleButton = new Button();
        repeatButton = new Button();
        fullScreenButton = new Button("*");
        //sliders
        durationSlider = new Slider();
        volumeSlider = new Slider();
        //imageview
        nextImage = new Image(new File("src/main/resources/images/next.png").toURI().toASCIIString());
        prevImage = new Image(new File("src/main/resources/images/previous.png").toURI().toASCIIString());
        pauseImage = new Image(new File("src/main/resources/images/play.png").toURI().toASCIIString());
        forwardImage = new Image(new File("src/main/resources/images/forward.png").toURI().toASCIIString());
        backwardImage = new Image(new File("src/main/resources/images/backward.png").toURI().toASCIIString());
        repeatImage = new Image(new File("src/main/resources/images/replay.png").toURI().toASCIIString());
        shuffleImage = new Image(new File("src/main/resources/images/next.png").toURI().toASCIIString());
        playlistImage = new Image(new File("src/main/resources/images/playlist.png").toURI().toASCIIString());
        //hboxs
        hBox1 = new HBox();
        hBox2 =new HBox();
        //
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(startDurationLabel,durationSlider,endDurationLabel);
        hBox2.getChildren().addAll(shuffleButton,repeatButton,backwardButton,prevButton,pauseButton,
                nextButton,forwardButton,playlistButton,fullScreenButton,volumeSlider,volumeLevelLabel);
        getChildren().addAll(hBox1,hBox2);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setSpacing(0);
        hBox2.setSpacing(12.5);
    }

    @Override
    public void bind() {
        //hbox1
        startDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.05));
        endDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.05));
        durationSlider.prefWidthProperty().bind(hBox1.widthProperty().multiply(.9));
        //hbox2
        shuffleButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        repeatButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        prevButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        pauseButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        nextButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        fullScreenButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.15));
        volumeSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.25));
        volumeLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.5));
        //
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox2.prefWidthProperty().bind(widthProperty());

    }

    @Override
    public void styling() {
        //
        nextButton.setGraphic(new ImageView(nextImage));
        prevButton.setGraphic(new ImageView(prevImage));
        pauseButton.setGraphic(new ImageView(pauseImage));
        repeatButton.setGraphic(new ImageView(repeatImage));
        forwardButton.setGraphic(new ImageView(forwardImage));
        backwardButton.setGraphic(new ImageView(backwardImage));
        playlistButton.setGraphic(new ImageView(playlistImage));
        shuffleButton.setGraphic(new ImageView(shuffleImage));

        //
    }

    public Button getNextButton() {
        return nextButton;
    }

    public Label getEndDurationLabel() {
        return endDurationLabel;
    }

    public Button getPauseButton() {
        return pauseButton;
    }

    public Label getStartDurationLabel() {
        return startDurationLabel;
    }

    public Label getVolumeLevelLabel() {
        return volumeLevelLabel;
    }

    public Button getPrevButton() {
        return prevButton;
    }


    public Button getRepeatButton() {
        return repeatButton;
    }

    public Button getShuffleButton() {
        return shuffleButton;
    }

    public Button getFullScreenButton() {
        return fullScreenButton;
    }

    public Button getBackwardButton() {
        return backwardButton;
    }

    public Button getForwardButton() {
        return forwardButton;
    }

    public Button getPlaylistButton() {
        return playlistButton;
    }

    public Slider getDurationSlider() {
        return durationSlider;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

}
