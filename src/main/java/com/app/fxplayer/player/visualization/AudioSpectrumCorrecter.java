package com.app.fxplayer.player.visualization;

import com.app.fxplayer.player.audioplayer.Player;

/**
 * AUDIO SPECTRUM DATA CORRECTION
 * CLASS HAS TWO STATIC METHODS
 * FOR CORRECTING PHASES AND MAGNITUDES
 * AUTHOR MILLA NW FROM ZIWAY ABATE
 */
public class AudioSpectrumCorrecter {
    public static float[] correctPhase(float[] phases) {
        for (int i = 0; i < phases.length; i++) {
            if (phases[i] < 0)
                phases[i] =phases[i]* -1;
            phases[i] = (float) (phases[i] * Math.sqrt(Math.PI));
        }
        return phases;
    }

    public static float[] correctMagnitude(float[] magnitudes) {
        for (int i = 0; i < magnitudes.length; i++) {
            if (magnitudes[i] < 0)
                magnitudes[i] = magnitudes[i] - Player.getMediaPlayer().getAudioSpectrumThreshold();
            magnitudes[i] = (float) (magnitudes[i]);
        }
        return magnitudes;
    }
}
