package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.audiovirtualizationview.WaveVisualization;
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

public class PlayerControlsView extends View {
    private Label startDurationLabel,endDurationLabel,volumeLevelLabel,balanceLevelLabel,rateLevelLabel;
    private JFXButton pauseButton,prevButton,nextButton,shuffleButton,repeatButton,fullScreenJFXButton;
    private JFXSlider durationSlider,volumeSlider,balanceSlider,rateSlider;
    private ImageView nextImage,prevImage,pauseImage,repeatImage,shuffleImage,fullscreenImage;
    private ImageView songImageView;
    private HBox hBox1,hBox2;
    @Override
    public void init() {
        // wave visualization
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
        shuffleButton = new JFXButton("shuffle");
        repeatButton = new JFXButton("repeat");
//        fullScreenButton = new Button("*");
        //sliders
        durationSlider = new JFXSlider();
        volumeSlider = new JFXSlider(0,1,.10);
        balanceSlider = new JFXSlider(-1,1,.1);
        rateSlider = new JFXSlider(0,8,.25);
        //imageview
        nextImage = new ImageView( new Image(new File("src/main/resources/icons/next-arrow-button-icon-vector-14566227.jpg").toURI().toASCIIString()));
        prevImage = new ImageView( new Image(new File("src/main/resources/icons/37111642-previous-red-flat-icon.webp").toURI().toASCIIString()));
        pauseImage = new ImageView( new Image(new File("src/main/resources/icons/download (8).png").toURI().toASCIIString()));
        repeatImage = new ImageView( new Image(new File("src/main/resources/icons/playercontrolsicons/repeat-button-red-icon.webp").toURI().toASCIIString()));
        shuffleImage = new ImageView( new Image(new File("src/main/resources/icons/playercontrolsicons/shuffle.png").toURI().toASCIIString()));
        fullscreenImage = new ImageView( new Image(new File("src/main/resources/icons/playercontrolsicons/fullscreen.png").toURI().toASCIIString()));
        //hboxs
        hBox1 = new HBox();
        hBox2 =new HBox();
        //
        fullScreenJFXButton = new JFXButton("*");
        //
        songImageView = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll( songImageView , startDurationLabel , durationSlider , endDurationLabel );
        hBox2.getChildren().addAll( shuffleButton , repeatButton , prevButton , pauseButton ,
                nextButton , fullScreenJFXButton ,
                volumeSlider , volumeLevelLabel ,
                balanceSlider , balanceLevelLabel ,
                rateSlider , rateLevelLabel );
        getChildren().addAll(hBox1,hBox2);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox1.setSpacing(2.0);
        hBox2.setSpacing(4.275);
        //
        songImageView.setFitHeight(44);
        songImageView.setFitWidth(50);
        //
    }

    @Override
    public void bind() {
        //hbox1
        startDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.04));
        endDurationLabel.prefWidthProperty().bind(hBox1.widthProperty().multiply(.04));
        durationSlider.prefWidthProperty().bind(hBox1.widthProperty().multiply(.9));
        durationSlider.prefHeightProperty().bind(hBox1.heightProperty());
        //buttons in hbox2
        shuffleButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.111025));
        repeatButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.11025));
        prevButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.11025));
        pauseButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.11025));
        nextButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.111025));
        fullScreenJFXButton.prefWidthProperty().bind(hBox2.widthProperty().multiply(.111025));
        // sliders in hbox2
        volumeLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.1125));
        volumeSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));
        //----------------------------------------------------------------------------------//
        balanceLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.091125));
        balanceSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));
        // rate level label
        rateLevelLabel.prefWidthProperty().bind(hBox2.widthProperty().multiply(.091125));
        rateSlider.prefWidthProperty().bind(hBox2.widthProperty().multiply(.2125));
        //
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox2.prefWidthProperty().bind(widthProperty());
        //
        prevImage.setFitWidth(32);
        prevImage.setFitHeight(26);

        pauseImage.setFitWidth(32);
        pauseImage.setFitHeight(26);

        nextImage.setFitWidth(32);
        nextImage.setFitHeight(26);

        shuffleImage.setFitWidth(32);
        shuffleImage.setFitHeight(26);

        repeatImage.setFitWidth(32);
        repeatImage.setFitHeight(26);

        fullscreenImage.setFitWidth(32);
        fullscreenImage.setFitHeight(26);

    }

    @Override
    public void styling() {
        //
        nextButton.setGraphic(nextImage);
        prevButton.setGraphic(prevImage);
        pauseButton.setGraphic(pauseImage);
        repeatButton.setGraphic(repeatImage);
        shuffleButton.setGraphic(shuffleImage);
        fullScreenJFXButton.setGraphic(fullscreenImage);
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

    public JFXButton getFullScreenJFXButton() {
        return fullScreenJFXButton;
    }

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

    public ImageView getSongImageView() {
        return songImageView;
    }

}
