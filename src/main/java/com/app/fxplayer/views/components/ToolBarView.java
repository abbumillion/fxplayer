package com.app.fxplayer.views.components;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

import java.util.Date;

public class ToolBarView extends View {
    // theme toggle button for night/light mode
    private ToggleButton nightModeButton;
    //sign in button
    private Button signInButton;
    // sign up button
    private Button signUpButton;
    // full screen button
    private Button fullScreenButton;
    // search text field
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
        signInButton = new Button("Sign In");
        signUpButton = new Button("Sign Up");
        nightModeButton = new ToggleButton("Night Mode");
        fullScreenButton = new Button("Full Screen");
        hBox = new HBox(20);
    }

    @Override
    public void build() {
        // create a layout for this toolbar
        hBox.getChildren().addAll(dateLabel,searchTextField,fullScreenButton,signInButton,signUpButton,nightModeButton);
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
     * @return night mode button
     */
    public ToggleButton getNightModeButton() {
        return nightModeButton;
    }


}
