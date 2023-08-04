package com.app.fxplayer.soundrecorder;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.audiovirtualizationview.WaveVisualization;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.File;

public class SoundRecorderView extends View {
    ListView listView;
    Label messageLabel , timeLabel;
    TextField textField;
    Button startButton,stopButton,saveButton;
    private WaveVisualization waveVisualization;

    File recordedFile = new File("D:/"+ "recordingt"+ ".wav");
    VBox vBox ;
    HBox hBox1 ;
    HBox hBox2 ;

    @Override
    public void init() {
        textField = new TextField("10");
        listView = new ListView<>();
        messageLabel = new Label();
        timeLabel = new Label();
        startButton = new Button("start");
        stopButton = new Button("stop");
        saveButton = new Button("save");
         vBox = new VBox(10);
         hBox1 = new HBox(20);
         hBox2 = new HBox(20);
         //
        waveVisualization = new WaveVisualization(720,480);

    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(messageLabel,timeLabel);
        hBox2.getChildren().addAll(startButton,stopButton,saveButton);
        vBox.getChildren().addAll(hBox1,textField,hBox2,listView,waveVisualization);
        getChildren().addAll(vBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        textField.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        waveVisualization.widthProperty().bind(widthProperty());
        waveVisualization.heightProperty().bind(heightProperty().multiply(.2));
        listView.prefWidthProperty().bind(widthProperty());
        listView.prefHeightProperty().bind(heightProperty().multiply(.6));

    }

    @Override
    public void styling() {

    }

    public TextField getTextField() {
        return textField;
    }

    public Button getStopButton() {
        return stopButton;
    }

    public ListView getListView() {
        return listView;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public File getRecordedFile() {
        return recordedFile;
    }

    public WaveVisualization getWaveVisualization() {
        return waveVisualization;
    }
}
