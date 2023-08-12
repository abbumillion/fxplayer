package com.app.fxplayer.player.visualization;

import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.tabs.VisualizationView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.media.AudioSpectrumListener;

public class AudioPlayerSpectrumListener implements AudioSpectrumListener {
    private VisualizationView visualizationView;


    public AudioPlayerSpectrumListener(VisualizationView visualizationView)
    {
        this.visualizationView = visualizationView;
    }

    /**
     *
     * @param timestamp
     * @param duration
     * @param phases
     * @param magnitudes
     */
    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] phases, float[] magnitudes) {
        ObservableList<XYChart.Data<String,Number>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String,Number>> data = FXCollections.observableArrayList();
        for (int i = 0 ; i < magnitudes.length ; i++)
        {
            seriesData.add(new XYChart.Data<>(i + "", magnitudes[i] - Player.getMediaPlayer().getAudioSpectrumThreshold()));
        }
        data.add(new XYChart.Series<>(seriesData));
        visualizationView.getBarChart().setData(data);
    }
}
