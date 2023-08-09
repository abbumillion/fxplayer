package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

import java.io.File;

public class VisualizationView extends View {
    private NumberAxis barChartYAxis , lineChartXAxis , lineChartYAxis;
    private CategoryAxis barChartXAxis ;
    private  BarChart<String,Number> barChart;
    private  LineChart<Number,Number> lineChart;
    private  HBox hBox0,hBox1,hBox2,hBox3,hBox4,slidersHBox , slidersLabelsHBox;
    private Label appTitleLabel , slider1Label , slider2Label ,slider3Label,slider4Label,slider5Label ,slider6Label , slider7Label ,
            slider8Label,slider9Label,slider10Label , slider11Label , slider12Label , slider13Label , slider14Label  ;
    private  VBox slidersVBox , centerVBox;
    private Slider slider1,slider2,slider3,slider4,slider5,slider6,slider7,slider8,slider9,slider10,slider11,slider12,slider13,slider14;
    private  ComboBox<String> audioEqualizerComboBox , audioDeviceComboBox;
    private Button menuButton , fullScreenButton , onOffButton , closeButton;
    private ImageView menuButtonIcon,powerButtonIcon,fullScreenButtonIcon , closeButtonIcon , audioVisualizerIcon;



    @Override
    public void init() {
        //
        closeButtonIcon = new ImageView(new File("src/main/resources/icons/red-close-button.png").toURI().toASCIIString());
        menuButtonIcon = new ImageView(new File("src/main/resources/icons/menublackcircularbutton_104737.png").toURI().toASCIIString());
        powerButtonIcon = new ImageView(new File("src/main/resources/icons/redpowerbutton.webp").toURI().toASCIIString());
        fullScreenButtonIcon = new ImageView(new File("src/main/resources/icons/fullscreenbuttonicon1.png").toURI().toASCIIString());
        audioVisualizerIcon = new ImageView(new File("src/main/resources/icons/red-audio-equlizer-icon.jpg").toURI().toASCIIString());
        //
        appTitleLabel = new Label("FXSound");
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
        menuButton = new Button();
        fullScreenButton = new Button();
        onOffButton = new Button("ON");
        closeButton = new Button();
        //
        barChartXAxis = new CategoryAxis();
        barChartYAxis = new NumberAxis();
        //
        lineChartXAxis = new NumberAxis();
        lineChartYAxis = new NumberAxis();
        //
        lineChart = new LineChart<>(lineChartXAxis,lineChartYAxis);
        barChart = new BarChart<>(barChartXAxis,barChartYAxis);
        //
        String[] audioDevices = {"LENOVO_SPEAKER","EXTERNAL_SPEAKER"};
        String[] audioEqualizers = {"MUSIC","TECHNO","TREBLE_BOOST","BASS_BOOST","LATIN","CLUB","CAR","TV"};
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
        hBox0 = new HBox(20);
        hBox1 = new HBox(20);
        hBox2 = new HBox(20);
        hBox3 = new HBox(20);
        hBox4 = new HBox(420);
        slidersHBox = new HBox(60);
        slidersLabelsHBox = new HBox(20);
    }

    @Override
    public void build() {

        //
        hBox0.getChildren().addAll(appTitleLabel,closeButton);
        hBox1.getChildren().addAll(audioEqualizerComboBox,audioDeviceComboBox);
        hBox2.getChildren().addAll(barChart);
        slidersVBox.getChildren().addAll(slider1Label,slider1,slider2Label,slider2,slider3Label,slider3,slider4Label,slider4,slider5Label,slider5);
        slidersLabelsHBox.getChildren().addAll(slider6Label , slider7Label , slider8Label , slider9Label , slider10Label , slider11Label  , slider12Label , slider13Label , slider14Label);
        slidersHBox.getChildren().addAll(slider6,slider7,slider8,slider9,slider10,slider11,slider12,slider13,slider14);
        centerVBox.getChildren().addAll(slidersHBox , slidersLabelsHBox);
        hBox3.getChildren().addAll(slidersVBox , centerVBox);
        hBox4.getChildren().addAll(menuButton,onOffButton,fullScreenButton);
        //
        getChildren().addAll(hBox0,hBox1,hBox2,hBox3,hBox4);
        //
    }

    @Override
    public void align() {

        //
        menuButtonIcon.setPreserveRatio(true);
        menuButtonIcon.setFitWidth(32);
        menuButtonIcon.setFitHeight(28);
        //
        powerButtonIcon.setPreserveRatio(true);
        powerButtonIcon.setFitWidth(52);
        powerButtonIcon.setFitHeight(38);
        //
        //
        audioVisualizerIcon.setPreserveRatio(true);
        audioVisualizerIcon.setFitWidth(32);
        audioVisualizerIcon.setFitHeight(28);
        //
        fullScreenButtonIcon.setPreserveRatio(true);
        fullScreenButtonIcon.setFitWidth(32);
        fullScreenButtonIcon.setFitHeight(28);
        //
        closeButtonIcon.setPreserveRatio(true);
        closeButtonIcon.setFitWidth(22);
        closeButtonIcon.setFitHeight(18);
        //
        fullScreenButtonIcon.setPreserveRatio(true);
        fullScreenButtonIcon.setFitWidth(32);
        fullScreenButtonIcon.setFitHeight(28);
        //
        menuButton.setGraphic(menuButtonIcon);
        onOffButton.setGraphic(powerButtonIcon);
        fullScreenButton.setGraphic(fullScreenButtonIcon);
        closeButton.setGraphic(closeButtonIcon);
        //
        hBox0.setAlignment(Pos.CENTER);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);
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

        appTitleLabel.prefWidthProperty().bind(hBox0.widthProperty().multiply(.99999));
        appTitleLabel.prefHeightProperty().bind(hBox0.heightProperty());
        closeButton.prefWidthProperty().bind(hBox0.widthProperty().multiply(.00001));
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


        slider1.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider2.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider3.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider4.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));
        slider5.prefHeightProperty().bind(slidersVBox.heightProperty().multiply(.1));

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
        menuButton.prefWidthProperty().bind(hBox4.widthProperty().multiply(.032));
        menuButton.prefHeightProperty().bind(hBox4.heightProperty().multiply(.085));
        onOffButton.prefWidthProperty().bind(hBox4.widthProperty().multiply(.08126));
        onOffButton.prefHeightProperty().bind(hBox4.heightProperty().multiply(.26));
        fullScreenButton.prefWidthProperty().bind(hBox4.widthProperty().multiply(.032));
        fullScreenButton.prefHeightProperty().bind(hBox4.heightProperty().multiply(.085));
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
        barChart.prefWidthProperty().bind(hBox2.widthProperty());
        barChart.prefHeightProperty().bind(hBox2.heightProperty());
        //
        hBox0.prefWidthProperty().bind(widthProperty());
        hBox1.prefWidthProperty().bind(widthProperty());
        hBox2.prefWidthProperty().bind(widthProperty());
        hBox3.prefWidthProperty().bind(widthProperty());
        hBox4.prefWidthProperty().bind(widthProperty());
        //
        hBox0.prefHeightProperty().bind(heightProperty().multiply(.04));
        hBox1.prefHeightProperty().bind(heightProperty().multiply(.11));
        hBox2.prefHeightProperty().bind(heightProperty().multiply(.30));
        hBox3.prefHeightProperty().bind(heightProperty().multiply(.35));
        hBox4.prefHeightProperty().bind(heightProperty().multiply(.2));
        //
    }

    @Override
    public void styling() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10.55,10.55,10.55,10.55));
        //
        hBox0.setAlignment(Pos.CENTER);
        hBox0.setPadding(new Insets(10.55,10.55,10.55,10.55));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(10.55,10.55,10.55,10.55));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(10.55,10.55,10.55,10.55));
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setPadding(new Insets(10.55,10.55,10.55,10.55));
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setPadding(new Insets(10.55,10.55,10.55,10.55));
        //
        slidersVBox.setPadding(new Insets(2.5,5,10,5));
        slidersVBox.setAlignment(Pos.CENTER);
        //
        slidersHBox.setPadding(new Insets(2.5,5,10,5));
        slidersHBox.setAlignment(Pos.CENTER);
        //
        centerVBox.setPadding(new Insets(2.5,5,10,5));
        centerVBox.setAlignment(Pos.CENTER);
        //
        appTitleLabel.setGraphic(audioVisualizerIcon);
        appTitleLabel.setFont(Font.font(24));
        appTitleLabel.setAlignment(Pos.CENTER_LEFT);
        //


        barChart.setLegendVisible(false);
        lineChart.setCreateSymbols(false);
        barChart.getYAxis().setTickLabelsVisible(false);
        barChart.getYAxis().setTickMarkVisible(false);
//        ((Path)barChart.getXAxis().lookup(".axis-minor-tick-mark")).setVisible(false);
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

    public BarChart<String, Number> getBarChart() {
        return barChart;
    }

    public NumberAxis getBarChartYAxis() {
        return barChartYAxis;
    }

    public CategoryAxis getBarChartXAxis() {
        return barChartXAxis;
    }

    public Button getFullScreenButton() {
        return fullScreenButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public LineChart<Number, Number> getLineChart() {
        return lineChart;
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getOnOffButton() {
        return onOffButton;
    }

    public ComboBox<String> getAudioDeviceComboBox() {
        return audioDeviceComboBox;
    }

    public ComboBox<String> getAudioEqualizerComboBox() {
        return audioEqualizerComboBox;
    }

    public NumberAxis getLineChartXAxis() {
        return lineChartXAxis;
    }

    public ImageView getAudioVisualizerIcon() {
        return audioVisualizerIcon;
    }

    public NumberAxis getLineChartYAxis() {
        return lineChartYAxis;
    }

    public ImageView getCloseButtonIcon() {
        return closeButtonIcon;
    }

    public Label getAppTitleLabel() {
        return appTitleLabel;
    }

    public Slider getSlider1() {
        return slider1;
    }

    public Slider getSlider2() {
        return slider2;
    }
    public Slider getSlider3() {
        return slider2;
    }
    public Slider getSlider4() {
        return slider2;
    }
    public Slider getSlider5() {
        return slider2;
    }

    public Slider getSlider6() {
        return slider6;
    }
}