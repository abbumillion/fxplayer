package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import lombok.Data;

@Data
public class AudioEqualizerView extends View {
    private HBox hBox1, hBox3, slidersHBox, slidersLabelsHBox;
    private Label slider1Label, slider2Label, slider3Label, slider4Label, slider5Label, slider6Label, slider7Label,
            slider8Label, slider9Label, slider10Label, slider11Label, slider12Label, slider13Label, slider14Label;
    private VBox slidersVBox, centerVBox;
    private Slider slider1, slider2, slider3, slider4, slider5, slider6, slider7, slider8, slider9, slider10, slider11, slider12, slider13, slider14;
    private ComboBox<String> audioEqualizerComboBox, audioDeviceComboBox;
    private Button powerButton;

    @Override
    public void init() {
        //
        slider1Label = new Label("Clarity");
        slider2Label = new Label("Ambience");
        slider3Label = new Label("Surround Sound");
        slider4Label = new Label("Dynamic Boost");
        slider5Label = new Label("Bass Boost");
        slider6Label = new Label("129 HZ");
        slider7Label = new Label("238 HZ");
        slider8Label = new Label("444 HZ");
        slider9Label = new Label("805 HZ");
        slider10Label = new Label("1.62 KHZ");
        slider11Label = new Label("2.52 KHZ");
        slider12Label = new Label("4.4 KHZ");
        slider13Label = new Label("7.9 KHZ");
        slider14Label = new Label("12.57 KHZ");
        //
        slider1 = new Slider();
        slider2 = new Slider();
        slider3 = new Slider();
        slider4 = new Slider();
        slider5 = new Slider();
        slider6 = new Slider();
        slider7 = new Slider();
        slider8 = new Slider();
        slider9 = new Slider();
        slider10 = new Slider();
        slider11 = new Slider();
        slider12 = new Slider();
        slider13 = new Slider();
        slider14 = new Slider();
        //
        String[] audioDevices = {"LENOVO_SPEAKER", "EXTERNAL_SPEAKER"};
        String[] audioEqualizers = {"MUSIC", "TECHNO", "TREBLE_BOOST", "BASS_BOOST", "LATIN", "CLUB", "CAR", "TV"};
        //
        ObservableList<String> audioDevicesList = FXCollections.observableArrayList();
        audioDevicesList.addAll(audioDevices);
        ObservableList<String> audioEqualizersList = FXCollections.observableArrayList();
        audioEqualizersList.addAll(audioEqualizers);
        //
        audioEqualizerComboBox = new ComboBox<>(audioEqualizersList);
        audioDeviceComboBox = new ComboBox<>(audioDevicesList);
        //
        slidersVBox = new VBox(10);
        centerVBox = new VBox(10);
        //
        hBox1 = new HBox(20);
        hBox3 = new HBox(20);
        slidersHBox = new HBox(60);
        slidersLabelsHBox = new HBox(10);
        //
        powerButton = new Button("On");
        //
    }

    @Override
    public void build() {
        hBox1.getChildren().addAll(audioEqualizerComboBox, audioDeviceComboBox);
        slidersVBox.getChildren().addAll(slider1Label, slider1, slider2Label, slider2, slider3Label, slider3, slider4Label, slider4, slider5Label, slider5);
        slidersLabelsHBox.getChildren().addAll(slider6Label, slider7Label, slider8Label, slider9Label, slider10Label, slider11Label, slider12Label, slider13Label, slider14Label);
        slidersHBox.getChildren().addAll(slider6, slider7, slider8, slider9, slider10, slider11, slider12, slider13, slider14);
        centerVBox.getChildren().addAll(slidersHBox, slidersLabelsHBox);
        hBox3.getChildren().addAll(slidersVBox, centerVBox);
        getChildren().addAll(hBox1, hBox3, powerButton);
    }

    @Override
    public void align() {

        //
        hBox1.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        centerVBox.setAlignment(Pos.CENTER);
        slidersLabelsHBox.setAlignment(Pos.CENTER);
        //
        slider6.setOrientation(Orientation.VERTICAL);
        slider7.setOrientation(Orientation.VERTICAL);
        slider8.setOrientation(Orientation.VERTICAL);
        slider9.setOrientation(Orientation.VERTICAL);
        slider10.setOrientation(Orientation.VERTICAL);
        slider11.setOrientation(Orientation.VERTICAL);
        slider12.setOrientation(Orientation.VERTICAL);
        slider13.setOrientation(Orientation.VERTICAL);
        slider14.setOrientation(Orientation.VERTICAL);
    }

    @Override
    public void bind() {
        //
        powerButton.prefWidthProperty().bind(widthProperty().multiply(0.12f));
        powerButton.prefHeightProperty().bind(heightProperty().multiply(0.06f));
        //
        audioDeviceComboBox.prefWidthProperty().bind(hBox1.widthProperty().multiply(.45));
        audioDeviceComboBox.prefHeightProperty().bind(hBox1.heightProperty());
        audioEqualizerComboBox.prefWidthProperty().bind(hBox1.widthProperty().multiply(.45));
        audioEqualizerComboBox.prefHeightProperty().bind(hBox1.heightProperty());
        //
        slider1.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider2.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider3.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider4.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider5.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        //
        slider1.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider2.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider3.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider4.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider5.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        //
        slider6.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider7.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider8.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider9.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider10.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider11.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider12.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider13.prefHeightProperty().bind(slidersHBox.heightProperty());
        slider14.prefHeightProperty().bind(slidersHBox.heightProperty());
        //
        slider1Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider2Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider3Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider4Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider5Label.prefWidthProperty().bind(slidersVBox.widthProperty().multiply(.85));
        slider1Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider2Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider3Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider4Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider5Label.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        //
        slider6Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider7Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider8Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider9Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider10Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider11Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider12Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider13Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        slider14Label.prefWidthProperty().bind(slidersLabelsHBox.widthProperty().multiply(.0711));
        //
        slidersVBox.prefWidthProperty().bind(hBox3.widthProperty().multiply(.15));
        slidersVBox.prefHeightProperty().bind(hBox3.heightProperty());
        //
        slidersHBox.prefWidthProperty().bind(centerVBox.widthProperty());
        slidersHBox.prefHeightProperty().bind(centerVBox.heightProperty().multiply(.85));
        //
        slidersLabelsHBox.prefWidthProperty().bind(centerVBox.widthProperty());
        slidersLabelsHBox.prefHeightProperty().bind(centerVBox.heightProperty().multiply(.2));
        //
        centerVBox.prefWidthProperty().bind(hBox3.widthProperty().multiply(.7));
        centerVBox.prefHeightProperty().bind(hBox3.heightProperty());
        //
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox3.prefWidthProperty().bind(widthProperty());
        //
        hBox1.prefHeightProperty().bind(heightProperty().multiply(.095));
        hBox3.prefHeightProperty().bind(heightProperty().multiply(.66));
        //
    }

    @Override
    public void styling() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        //
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        //
        slidersVBox.setPadding(new Insets(2.5, 5, 10, 5));
        slidersVBox.setAlignment(Pos.CENTER);
        //
        slidersHBox.setPadding(new Insets(2.5, 5, 10, 5));
        slidersHBox.setAlignment(Pos.CENTER);
        //
        centerVBox.setPadding(new Insets(2.5, 5, 10, 5));
        centerVBox.setAlignment(Pos.CENTER);
        //
        slider1Label.setAlignment(Pos.CENTER);
        slider2Label.setAlignment(Pos.CENTER);
        slider3Label.setAlignment(Pos.CENTER);
        slider4Label.setAlignment(Pos.CENTER);
        slider5Label.setAlignment(Pos.CENTER);
        //
        slider6Label.setAlignment(Pos.CENTER);
        slider7Label.setAlignment(Pos.CENTER);
        slider8Label.setAlignment(Pos.CENTER);
        slider9Label.setAlignment(Pos.CENTER);
        slider10Label.setAlignment(Pos.CENTER);
        slider11Label.setAlignment(Pos.CENTER);
        slider12Label.setAlignment(Pos.CENTER);
        slider13Label.setAlignment(Pos.CENTER);
        slider14Label.setAlignment(Pos.CENTER);
        //
        slider1Label.setAlignment(Pos.CENTER_LEFT);
        slider2Label.setAlignment(Pos.CENTER_LEFT);
        slider3Label.setAlignment(Pos.CENTER_LEFT);
        slider4Label.setAlignment(Pos.CENTER_LEFT);
        slider5Label.setAlignment(Pos.CENTER_LEFT);
        slider6Label.setAlignment(Pos.CENTER);
        slider7Label.setAlignment(Pos.CENTER);
        slider8Label.setAlignment(Pos.CENTER);
        slider9Label.setAlignment(Pos.CENTER);
        slider10Label.setAlignment(Pos.CENTER);
        slider11Label.setAlignment(Pos.CENTER);
        slider12Label.setAlignment(Pos.CENTER);
        slider13Label.setAlignment(Pos.CENTER);
        slider14Label.setAlignment(Pos.CENTER);
        //
        slider6Label.setFont(Font.font(8.7));
        slider7Label.setFont(Font.font(8.7));
        slider8Label.setFont(Font.font(8.7));
        slider9Label.setFont(Font.font(8.7));
        slider10Label.setFont(Font.font(8.7));
        slider11Label.setFont(Font.font(8.7));
        slider12Label.setFont(Font.font(8.7));
        slider13Label.setFont(Font.font(8.7));
        slider14Label.setFont(Font.font(8.7));
        //
    }

}
