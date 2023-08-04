package com.app.fxplayer.player.visualization;

import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.tabs.VisualizationView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.paint.Color;

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
        ObservableList<XYChart.Data<String,Float>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String,Float>> data = FXCollections.observableArrayList();
        for (int i = 0 ; i < magnitudes.length ; i++)
        {
            if (phases[i] < 0)
                phases[i] = phases[i] * -1;
//            if (magnitudes[i] < 0 )
//                magnitudes[i] = magnitudes[i] * -1 *  14f;
//            float correctedMagnitude = magnitudes[i] * 3.14f;
//            float correctPhase = phases[i] * 256 * 3.14f;
//            seriesData.add(new XYChart.Data<>(i + "",64 * magnitudes[i] - Player.getMediaPlayer().getAudioSpectrumThreshold()));
            float v = 127 * magnitudes[i] - Player.getMediaPlayer().getAudioSpectrumThreshold();
            visualizationView.getCircle().setRadius(v);
            visualizationView.getCircle().setFill(Color.rgb((int) (phases[i] * 1000 % 255), (int) (phases[i] * 1000 % 255), (int) (phases[i] * 1000 % 255)));
        }
//        data.add(new XYChart.Series<>(seriesData));
//        visualizationView.getBarChart().setData(data);
    }
}
