package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.layout.HBox;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LineChartVisualizationView extends View {
    private NumberAxis lineChartXAxis, lineChartYAxis;
    private ScatterChart<Number, Number> scatterChart;
    private HBox hBox2;

    @Override
    public void init() {
        hBox2 = new HBox(20);
        lineChartXAxis = new NumberAxis();
        lineChartYAxis = new NumberAxis();
        scatterChart = new ScatterChart<>(lineChartXAxis, lineChartYAxis);
    }

    @Override
    public void build() {
        hBox2.getChildren().addAll(scatterChart);
        getChildren().addAll(hBox2);
    }

    @Override
    public void align() {
        hBox2.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        scatterChart.prefWidthProperty().bind(hBox2.widthProperty());
        scatterChart.prefHeightProperty().bind(hBox2.heightProperty());
        hBox2.prefWidthProperty().bind(widthProperty());
        hBox2.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        scatterChart.setLegendVisible(false);
        scatterChart.getXAxis().setTickLabelsVisible(false);
        scatterChart.getXAxis().setTickMarkVisible(false);
        scatterChart.setVerticalGridLinesVisible(false);
        scatterChart.setHorizontalGridLinesVisible(false);
        scatterChart.getYAxis().setTickLabelsVisible(false);
        scatterChart.getYAxis().setTickMarkVisible(false);
    }
}
