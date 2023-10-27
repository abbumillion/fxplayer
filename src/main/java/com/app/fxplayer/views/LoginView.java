package com.app.fxplayer.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginView extends View{
    Button loginButton;
    @Override
    public void init() {

        loginButton = new Button("login");
    }

    @Override
    public void build() {
        getChildren().addAll(loginButton);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        setSpacing(36);
    }

    @Override
    public void bind() {
        loginButton.prefWidthProperty().bind(widthProperty().multiply(.1));
        loginButton.prefHeightProperty().bind(heightProperty().multiply(.012));
    }

    @Override
    public void styling() {
        setPadding(new Insets(12,12,12,12));
        setMargin(this,new Insets(7,7,7,7));
    }
}
