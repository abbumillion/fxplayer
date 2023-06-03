package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchBarView extends View {
    private TextField searchTextField;
    private HBox hBox;
    @Override
    public void init() {
        searchTextField = new TextField("search something here");
        hBox = new HBox();
    }

    @Override
    public void build() {
        hBox.getChildren().add(searchTextField);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        searchTextField.prefWidthProperty().bind(hBox.widthProperty().multiply(.665));
        searchTextField.prefHeightProperty().bind(hBox.heightProperty().multiply(.65));
        hBox.prefWidthProperty().bind(widthProperty().multiply(.75));

    }
}
