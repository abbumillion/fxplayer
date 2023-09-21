package com.app.fxplayer.player.visualization;

import com.app.fxplayer.views.PlayerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.media.AudioSpectrumListener;

public class AudioPlayerSpectrumListener implements AudioSpectrumListener {
    private final PlayerView playerView;

    public AudioPlayerSpectrumListener(PlayerView playerView) {
        this.playerView = playerView;
    }

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] phases, float[] magnitudes) {
        barChartVisualization(AudioSpectrumCorrecter.correctMagnitude(magnitudes));
        lineChartVisualization(AudioSpectrumCorrecter.correctMagnitude(magnitudes));
    }

    private void lineChartVisualization(float[] magnitudes) {
        ObservableList<XYChart.Data<Number, Number>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<Number, Number>> data = FXCollections.observableArrayList();
        for (int i = 0;i< magnitudes.length; i++) {
            seriesData.add(new XYChart.Data<>(i, magnitudes[i]));
        }
        data.add(new XYChart.Series<>(seriesData));
        playerView.getLineChartVisualizationView().getScatterChart().setData(data);
    }

    private void barChartVisualization(float[] magnitudes) {
        ObservableList<XYChart.Data<String, Number>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        for (int i = 0;i< magnitudes.length; i++) {
            seriesData.add(new XYChart.Data<>(String.valueOf(i), magnitudes[i]));
        }
        data.add(new XYChart.Series<>(seriesData));
        playerView.getBarChartVisualizationView().getBarChart().setData(data);
    }
}
