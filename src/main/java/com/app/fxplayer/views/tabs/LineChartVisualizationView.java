package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.HBox;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LineChartVisualizationView extends View {
    private NumberAxis lineChartXAxis, lineChartYAxis;
    private LineChart<Number, Number> lineChart;
    private HBox hBox2;

    @Override
    public void init() {
        hBox2 = new HBox(20);
        lineChartXAxis = new NumberAxis();
        lineChartYAxis = new NumberAxis();
        lineChart = new LineChart<>(lineChartXAxis, lineChartYAxis);
    }

    @Override
    public void build() {
        hBox2.getChildren().addAll(lineChart);
        getChildren().addAll(hBox2);
    }

    @Override
    public void align() {
        hBox2.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        lineChart.prefWidthProperty().bind(hBox2.widthProperty());
        lineChart.prefHeightProperty().bind(hBox2.heightProperty());
        hBox2.prefWidthProperty().bind(widthProperty());
        hBox2.prefHeightProperty().bind(heightProperty().multiply(.85));
    }

    @Override
    public void styling() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(10.55, 10.55, 10.55, 10.55));
        lineChart.setLegendVisible(false);
        lineChart.getXAxis().setTickLabelsVisible(false);
        lineChart.getXAxis().setTickMarkVisible(false);
        lineChart.setCreateSymbols(false);
        lineChart.setVerticalGridLinesVisible(false);
        lineChart.setHorizontalGridLinesVisible(false);
        lineChart.getYAxis().setTickLabelsVisible(false);
        lineChart.getYAxis().setTickMarkVisible(false);
    }
}
