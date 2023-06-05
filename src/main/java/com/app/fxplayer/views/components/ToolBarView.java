package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import org.controlsfx.control.ToggleSwitch;

import java.util.Date;

public class ToolBarView extends View {
    // theme toggle button for night/light mode
    private ToggleSwitch nightModeToggleSwitchButton;
    //sign in button
    private JFXButton signInButton,signUpButton,fullScreenButton;
    //
    private TextField searchTextField;
    /**
     * date label
     */
    private Label dateLabel;
    /**
     * hbox search text field container
     */
    private HBox hBox;
    @Override
    public void init() {
        searchTextField = new TextField("search something here");
        dateLabel = new Label(new Date().toGMTString());
        signInButton = new JFXButton("Sign In");
        signUpButton = new JFXButton("Sign Up");
        nightModeToggleSwitchButton = new ToggleSwitch("Night Mode");
        fullScreenButton = new JFXButton("Full Screen");
        hBox = new HBox(20);
    }

    @Override
    public void build() {
        // create a layout for this toolbar
        hBox.getChildren().addAll(dateLabel,searchTextField,fullScreenButton,signInButton,signUpButton,nightModeToggleSwitchButton);
        getChildren().addAll(hBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //
        dateLabel.prefWidthProperty().bind(hBox.widthProperty().multiply(.114));
        dateLabel.prefHeightProperty().bind(hBox.heightProperty().multiply(.75));
        //
        searchTextField.prefWidthProperty().bind(hBox.widthProperty().multiply(.3444));
        searchTextField.prefHeightProperty().bind(hBox.heightProperty());
        //
        signInButton.prefWidthProperty().bind(hBox.widthProperty().multiply(.0844));
        signInButton.prefHeightProperty().bind(hBox.heightProperty().multiply(.75));
        //
        signUpButton.prefWidthProperty().bind(hBox.widthProperty().multiply(.0844));
        signUpButton.prefHeightProperty().bind(hBox.heightProperty().multiply(.75));
        //
        hBox.prefWidthProperty().bind(widthProperty().multiply(.65));
        hBox.prefHeightProperty().bind(heightProperty().multiply(.3656));
        //

    }
    @Override
    public void styling() {
        // search text field styling operations
        searchTextField.setAlignment(Pos.CENTER);
        searchTextField.setFont(Font.font(14));
        //
    }

    /**
     *
     * @return full screen button
     */
    public Button getFullScreenButton() {
        return fullScreenButton;
    }

    /**
     *
     * @return sign in button
     */
    public Button getSignInButton() {
        return signInButton;
    }

    /**
     *
     * @return sign up button
     */
    public Button getSignUpButton() {
        return signUpButton;
    }

    /**
     *
     * @return date label
     */
    public Label getDateLabel() {
        return dateLabel;
    }

    /**
     *
     * @return search text field
     */
    public TextField getSearchTextField() {
        return searchTextField;
    }

    /**
     *
     * @return night mode toggle switch
     */
    public ToggleSwitch getNightModeToggleSwitchButton() {
        return nightModeToggleSwitchButton;
    }
}
