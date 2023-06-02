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

import java.io.File;

/**
 * PLAYER CONTROLLER VIEW
 */
public class PlayerControllerView extends View {
    private Label startDurationLabel,endDurationLabel,volumeLevelLabel;
    private Button pauseButton,prevButton,nextButton,shuffleButton,repeatButton,fullScreenButton;
    private Slider durationSlider,volumeSlider;
    private HBox hBox1,hBox2;
    @Override
    public void init() {
        // labels
        startDurationLabel = new Label("start");
        endDurationLabel = new Label("end");
        volumeLevelLabel = new Label("vol");
        // buttons
        pauseButton = new Button("pause");
        prevButton = new Button("prev");
        nextButton = new Button("next");
        shuffleButton = new Button("shuffle");
        repeatButton = new Button("repeat");
        fullScreenButton = new Button("Full Screen");
        //sliders
        durationSlider = new Slider();
        volumeSlider = new Slider();
        //imageview
        //hboxes
        hBox1 = new HBox();
        hBox2 =new HBox();
        //
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(startDurationLabel,durationSlider,endDurationLabel);
        hBox2.getChildren().addAll(shuffleButton,repeatButton,prevButton,pauseButton,nextButton,fullScreenButton,volumeSlider,volumeLevelLabel);
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

    public Slider getDurationSlider() {
        return durationSlider;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

}
