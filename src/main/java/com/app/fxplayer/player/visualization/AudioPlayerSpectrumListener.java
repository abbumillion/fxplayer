package com.app.fxplayer.player.visualization;

import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.views.PlayerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.XYChart;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.paint.Color;

public class AudioPlayerSpectrumListener implements AudioSpectrumListener {
    private final PlayerView playerView;

    public AudioPlayerSpectrumListener(PlayerView playerView) {
        this.playerView = playerView;
    }

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] phases, float[] magnitudes) {
        barChartVisualization(AudioSpectrumCorrecter.correctMagnitude(magnitudes));
        lineChartVisualization(AudioSpectrumCorrecter.correctMagnitude(magnitudes));
//        canvasVisualization(AudioSpectrumCorrecter.correctPhase(phases), AudioSpectrumCorrecter.correctMagnitude(magnitudes));
    }

    private void canvasVisualization(float[] phases, float[] magnitudes) {
        GraphicsContext graphicsContext = playerView.getCanvasVisualizationView().getCanvas().getGraphicsContext2D();
        double width = playerView.getCanvasVisualizationView().getWidth();
        double height = playerView.getCanvasVisualizationView().getHeight();
        for (int i = 0; i < magnitudes.length; i++) {
            magnitudes[i] = magnitudes[i] - Player.getMediaPlayer().getAudioSpectrumThreshold();
            graphicsContext.clearRect(0, 0, playerView.getCanvasVisualizationView().widthProperty().get(),
                    playerView.getCanvasVisualizationView().heightProperty().get());
            Particle particle = new Particle(magnitudes[i] * 13, magnitudes[i] * 14, Color.rgb((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10)));
            graphicsContext.setFill(particle.getColor());
            graphicsContext.fillOval(width / 3, height / 3, particle.getX(), particle.getY());
        }

    }

    private void lineChartVisualization(float[] magnitudes) {
        ObservableList<XYChart.Data<Number, Number>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<Number, Number>> data = FXCollections.observableArrayList();
        for (int i = 0; i < magnitudes.length; i++) {
            seriesData.add(new XYChart.Data<>(i, magnitudes[i]));
        }
        data.add(new XYChart.Series<>(seriesData));
        playerView.getLineChartVisualizationView().getLineChart().setData(data);
    }

    private void barChartVisualization(float[] magnitudes) {
        ObservableList<XYChart.Data<String, Number>> seriesData = FXCollections.observableArrayList();
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        for (int i = 0; i < magnitudes.length; i++) {
            seriesData.add(new XYChart.Data<>(String.valueOf(i), magnitudes[i]));
        }
        data.add(new XYChart.Series<>(seriesData));
        playerView.getBarChartVisualizationView().getBarChart().setData(data);
    }
}
