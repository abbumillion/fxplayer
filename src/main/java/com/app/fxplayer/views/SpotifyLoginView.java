package com.app.fxplayer.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.web.WebView;
import lombok.Getter;

@Getter
public class SpotifyLoginView extends View{
    WebView webView;
    @Override
    public void init() {
        webView = new WebView();
    }

    @Override
    public void build() {
        getChildren().addAll(webView);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        webView.prefWidthProperty().bind(widthProperty());
        webView.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        setPadding(new Insets(12.5));
        setMargin(this,new Insets(6.28));
    }
}
