package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class SearchBarView extends View {
    private TextField searchTextField;
    @Override
    public void init() {
        searchTextField = new TextField("search something here");
    }

    @Override
    public void build() {
        getChildren().addAll(searchTextField);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
//        searchTextField.prefWidthProperty().bind(widthProperty().multiply(.6));
    }
}
