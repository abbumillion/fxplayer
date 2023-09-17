package com.app.fxplayer.player.visualization;

import com.app.fxplayer.player.audioplayer.Player;

/**
 * AUDIO SPECTRUM DATA CORRECTION
 * CLASS HAS TWO STATIC METHODS
 * FOR CORRECTING PHASES AND MAGNITUDES
 * FOR AUDIO VISUALIZATION
 * AUTHOR MILLA NW FROM ZIWAY ABATE
 */

public class AudioSpectrumCorrecter {
    public static float[] correctPhase(float[] phases) {
        for (int i = 0; i < phases.length; i++) {
            if (phases[i] < 0)
                phases[i] = phases[i] * -1;
            phases[i] = (float) (phases[i] * Math.sqrt(22222));
        }
        return phases;
    }

    public static FFT.Complex[] correctMagnitude(float[] phases , float[] magnitudes) {
        FFT.Complex[] x = new FFT.Complex[magnitudes.length];
        for (int i = 0; i < magnitudes.length; i++) {
            if (phases[i] < 0)
                phases[i] = phases[i] * -1;
            magnitudes[i] =(magnitudes[i]-Player.getMediaPlayer().getAudioSpectrumThreshold());
            x[i] = new FFT.Complex(i,magnitudes[i]);
        }
        return FFT.Complex.fft(x);
    }
}
