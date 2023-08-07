package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class VisualizationView extends View {
    private BarChart barChart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    @Override
    public void init() {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        barChart = new BarChart(xAxis,yAxis);
    }

    @Override
    public void build() {
        getChildren().add(barChart);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        barChart.setLegendVisible(false);
        barChart.setAnimated(false);

    }

    @Override
    public void bind() {
        //

        barChart.prefWidthProperty().bind(widthProperty());
        barChart.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {

    }

    public CategoryAxis getxAxis() {
        return xAxis;
    }

    public BarChart getBarChart() {
        return barChart;
    }

    public NumberAxis getyAxis() {
        return yAxis;
    }
}
