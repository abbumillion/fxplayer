package com.app.fxplayer.player.visualization;
import com.app.fxplayer.player.audioplayer.Player;
/**
 * AUDIO SPECTRUM DATA CORRECTION
 * CLASS HAS TWO STATIC METHODS
 * FOR CORRECTING PHASES AND MAGNITUDES
 * FOR AUDIO VISUALIZATION
 */
public class AudioSpectrumCorrecter {
    public static float[] correctMagnitude(float[] magnitudes) {
        for (int i = 0; i < magnitudes.length; i++) {
            magnitudes[i] =(magnitudes[i]-Player.getMediaPlayer().getAudioSpectrumThreshold());
            magnitudes[i] = (float) Math.exp(Math.pow(magnitudes[i],.65));
        }
        return magnitudes;
    }
}
