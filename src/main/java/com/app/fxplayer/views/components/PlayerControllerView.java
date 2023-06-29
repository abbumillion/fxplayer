package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
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
    private Label startDurationLabel,endDurationLabel,volumeLevelLabel,balanceLevelLabel,rateLevelLabel;
    private JFXButton pauseButton,prevButton,nextButton,shuffleButton,repeatButton;
    private JFXSlider durationSlider,volumeSlider,balanceSlider,rateSlider;
    private Image nextImage,prevImage,pauseImage,playlistImage,repeatImage,shuffleImage;
    private HBox hBox1,hBox2;
    @Override
    public void init() {
        // labels
        startDurationLabel = new Label("strt");
        endDurationLabel = new Label("end");
        volumeLevelLabel = new Label("vol:");
        balanceLevelLabel = new Label("balnc:");
        rateLevelLabel = new Label("rate:");
        // buttons
        pauseButton = new JFXButton("pause");
        prevButton = new JFXButton("prev");
        nextButton = new JFXButton("next");
//        forwardButton = new Button();
//        backwardButton = new Button();
        shuffleButton = new JFXButton("shuffle");
        repeatButton = new JFXButton("repeat");
//        fullScreenButton = new Button("*");
        //sliders
        durationSlider = new JFXSlider();
        volumeSlider = new JFXSlider(0,100,10);
        balanceSlider = new JFXSlider(-1,1,.1);
        rateSlider = new JFXSlider(0,8,.25);
        //imageview
        nextImage = new Image(new File("src/main/resources/images/next.png").toURI().toASCIIString());
        prevImage = new Image(new File("src/main/resources/images/previous.png").toURI().toASCIIString());
        pauseImage = new Image(new File("src/main/resources/images/play.png").toURI().toASCIIString());
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
        hBox2.getChildren().addAll(shuffleButton,repeatButton,prevButton,pauseButton,
                nextButton,
                volumeSlider,volumeLevelLabel,
                balanceSlider,balanceLevelLabel,
                rateSlider,rateLevelLabel);
        getChildren().addAll(hBox1,hBox2);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setSpacing(2.0);
        hBox2.setSpacing(2.275);
    }

    @Override
    public void bind() {
        //hbox1
        startDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.02));
        endDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.02));
        durationSlider.prefWidthProperty().bind(hBox1.widthProperty().multiply(.96));
        //buttons in hbox2
        shuffleButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        repeatButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        prevButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        pauseButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        nextButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        // sliders in hbox2
        volumeLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        volumeSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));

        balanceLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        balanceSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));

        rateLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        rateSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));

        //
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox2.prefWidthProperty().bind(widthProperty());

    }

    @Override
    public void styling() {
        //
//        nextButton.setGraphic(new ImageView(nextImage));
//        prevButton.setGraphic(new ImageView(prevImage));
//        pauseButton.setGraphic(new ImageView(pauseImage));
//        repeatButton.setGraphic(new ImageView(repeatImage));
////        forwardButton.setGraphic(new ImageView(forwardImage));
////        backwardButton.setGraphic(new ImageView(backwardImage));
//        playlistButton.setGraphic(new ImageView(playlistImage));
//        shuffleButton.setGraphic(new ImageView(shuffleImage));

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

//    public Button getFullScreenButton() {
//        return fullScreenButton;
//    }

//    public Button getBackwardButton() {
//        return backwardButton;
//    }
//
//    public Button getForwardButton() {
//        return forwardButton;
//    }

    public Slider getDurationSlider() {
        return durationSlider;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public Label getBalanceLevelLabel() {
        return balanceLevelLabel;
    }

    public Label getRateLevelLabel() {
        return rateLevelLabel;
    }

    public Slider getBalanceSlider() {
        return balanceSlider;
    }

    public Slider getRateSlider() {
        return rateSlider;
    }
}
