package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.controlsfx.control.ToggleSwitch;

import java.io.File;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToolBarView extends View {
    private ImageView softwareIconImage;
    private ToggleSwitch nightModeToggleSwitchButton;
    private Button signInButton, signUpButton;
    private TextField searchTextField;
    private Label logoLabel, dateLabel;
    private HBox rootHbox;

    @Override
    public void init() {
        softwareIconImage = new ImageView(new File("src/main/resources/icons/tabicons/istockphoto-1367611853-640x640.jpg").toURI().toASCIIString());
        searchTextField = new TextField("search something here");
        logoLabel = new Label("Fx-Player", softwareIconImage);
        dateLabel = new Label(new Date().toString());
        signInButton = new Button("Sign In");
        signUpButton = new Button("Sign Up");
        nightModeToggleSwitchButton = new ToggleSwitch();
        rootHbox = new HBox(0);
    }

    @Override
    public void build() {
        rootHbox.getChildren().addAll(logoLabel, dateLabel, searchTextField, signInButton, signUpButton, nightModeToggleSwitchButton);
        getChildren().addAll(rootHbox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER_LEFT);
        dateLabel.setAlignment(Pos.CENTER);
        rootHbox.setAlignment(Pos.CENTER);
        softwareIconImage.setPreserveRatio(true);
        logoLabel.setGraphicTextGap(7.5);
        logoLabel.setAlignment(Pos.CENTER_LEFT);
    }

    @Override
    public void bind() {
        softwareIconImage.fitWidthProperty().bind(logoLabel.widthProperty().multiply(.4680));
        softwareIconImage.fitHeightProperty().bind(logoLabel.heightProperty().multiply(.860));
        logoLabel.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0514));
        logoLabel.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.15));
        dateLabel.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.214));
        dateLabel.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.1));
        searchTextField.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.3544));
        searchTextField.prefHeightProperty().bind(rootHbox.heightProperty());
        signInButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0544));
        signInButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.5));
        signUpButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0544));
        signUpButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.5));
        nightModeToggleSwitchButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0544));
        nightModeToggleSwitchButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.65));
        rootHbox.prefWidthProperty().bind(widthProperty());
        rootHbox.prefHeightProperty().bind(heightProperty().multiply(.075));

    }

    @Override
    public void styling() {
        nightModeToggleSwitchButton.setAlignment(Pos.CENTER_RIGHT);
        searchTextField.setAlignment(Pos.CENTER);
        searchTextField.setFont(Font.font(16));
        dateLabel.setFont(Font.font(26));
    }

}
