package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * PLAYER CONTROLLER VIEW
 */
public class PlayerControllerView extends View {
    private Label startDurationLabel,endDurationLabel,volumeLevelLabel;
    private Button pauseButton,prevButton,nextButton,shuffleButton,repeatButton;
    private Slider durationSlider,volumeSlider;
    private ImageView imageView;
    private HBox hBox1,hBox2,hBox3;
    private VBox vBox;

    @Override
    public void init() {
        // labels
        startDurationLabel = new Label("start");
        endDurationLabel = new Label("end");
        volumeLevelLabel = new Label("vol");
        // buttons
        pauseButton = new Button("pause");
        prevButton = new Button("pause");
        nextButton = new Button("pause");
        shuffleButton = new Button("pause");
        repeatButton = new Button("pause");
        //sliders
        durationSlider = new Slider();
        volumeSlider = new Slider();
        //imageview
        imageView = new ImageView();
        //hboxes
        hBox1 = new HBox();
        hBox2 =new HBox();
        hBox3 =new HBox();
        //vboxes
        vBox = new VBox();
        //
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(startDurationLabel,durationSlider,endDurationLabel);
        hBox2.getChildren().addAll(shuffleButton,repeatButton,prevButton,pauseButton,nextButton,volumeSlider,volumeLevelLabel);
        vBox.getChildren().addAll(hBox1,hBox2);
        hBox3.getChildren().addAll(imageView,vBox);
        getChildren().add(hBox3);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        hBox3.prefWidthProperty().bind(widthProperty());
        hBox3.prefHeightProperty().bind(heightProperty());
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

    public ImageView getImageView() {
        return imageView;
    }

    public Button getRepeatButton() {
        return repeatButton;
    }

    public Button getShuffleButton() {
        return shuffleButton;
    }

    public Slider getDurationSlider() {
        return durationSlider;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

}
