package com.app.fxplayer.player.visualization;

import com.app.fxplayer.views.tabs.VisualizationView;
import javafx.scene.media.AudioSpectrumListener;

public class AudioPlayerSpectrumListener implements AudioSpectrumListener {
    private VisualizationView visualizationView;

    /**
     *
     * @param timestamp
     * @param duration
     * @param phases
     * @param magnitudes
     */
    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] phases, float[] magnitudes) {

    }
}
