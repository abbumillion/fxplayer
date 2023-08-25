package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.HBox;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BarChartVisualizationView extends View {
    private NumberAxis barChartYAxis;
    private CategoryAxis barChartXAxis;
    private BarChart<String, Number> barChart;
    private HBox hBox2;

    @Override
    public void init() {
        hBox2 = new HBox(20);
        barChartXAxis = new CategoryAxis();
        barChartYAxis = new NumberAxis();
        barChart = new BarChart<>(barChartXAxis, barChartYAxis);
    }

    @Override
    public void build() {
        hBox2.getChildren().addAll(barChart);
        getChildren().addAll(hBox2);
    }

    @Override
    public void align() {
        //
        hBox2.setAlignment(Pos.CENTER);
        //
    }

    @Override
    public void bind() {

        barChart.prefWidthProperty().bind(hBox2.widthProperty());
        barChart.prefHeightProperty().bind(hBox2.heightProperty());
        //
        hBox2.prefWidthProperty().bind(widthProperty());
        //
        hBox2.prefHeightProperty().bind(heightProperty().multiply(.85));
        //
    }

    @Override
    public void styling() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        barChart.setLegendVisible(false);
        barChart.getYAxis().setTickLabelsVisible(false);
        barChart.getYAxis().setTickMarkVisible(false);
    }
}