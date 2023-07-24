package com.app.fxplayer.player.visualization;

import com.app.fxplayer.views.tabs.VisualizationView;
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
        for (int i = 0 ; i < magnitudes.length ; i++)
        {
            float correctedMagnitude = (float) (magnitudes[i] * 3.14);
            visualizationView.getCircle1().radiusProperty().set(correctedMagnitude);
            visualizationView.getCircle2().radiusProperty().set(correctedMagnitude);
        }
    }
}
