package com.app.fxplayer.views.components;

import com.app.fxplayer.helpers.StringConstants;
import com.app.fxplayer.views.View;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import org.controlsfx.control.ToggleSwitch;

import java.io.File;
import java.util.Date;

/**
 * application toolbar view class
 * this view class is used on upper
 * top of the main view
 * will contain
 * application logo
 * search text field
 * sign in button
 * sign up button
 * night mode switch
 * optionals
 * date label
 * some kind of equalizer
 */
public class ToolBarView extends View {
    // icon for the software
    private ImageView softwareIconImage;
    // theme toggle button for night/light mode
    private ToggleSwitch nightModeToggleSwitchButton;
    //sign in button
    private JFXButton signInButton,signUpButton,fullScreenButton;
    //
    private TextField searchTextField;
    /**
     * date label
     */
    private Label logoLabel,dateLabel;
    /**
     * hbox search text field container
     */
    private HBox rootHbox;
    @Override
    public void init() {
        //
        softwareIconImage = new ImageView(new File(StringConstants.getSystemIcon()).toURI().toASCIIString());
        searchTextField = new TextField("search something here");
        // labels
        logoLabel = new Label(StringConstants.getSystemTitle(),softwareIconImage);
        dateLabel = new Label(new Date().toString());
        // buttons
        signInButton = new JFXButton("Sign In");
        signUpButton = new JFXButton("Sign Up");
        // toggle switch
        nightModeToggleSwitchButton = new ToggleSwitch();
        fullScreenButton = new JFXButton("Full Screen");
        // root
        rootHbox = new HBox(0);
        //
    }

    @Override
    public void build() {
        // create a layout for this toolbar
        rootHbox.getChildren().addAll(logoLabel,dateLabel,searchTextField,fullScreenButton,signInButton,signUpButton,nightModeToggleSwitchButton);
        getChildren().addAll(rootHbox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER_LEFT);
        dateLabel.setAlignment(Pos.CENTER);
        rootHbox.setAlignment(Pos.CENTER);
        softwareIconImage.setPreserveRatio(true);
        logoLabel.setGraphicTextGap(7.5);
    }

    @Override
    public void bind() {
        //
        softwareIconImage.fitWidthProperty().bind(logoLabel.widthProperty().multiply(.4680));
        softwareIconImage.fitHeightProperty().bind(logoLabel.heightProperty().multiply(.860));
        //
        logoLabel.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0714));
        logoLabel.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.15));
        //
        dateLabel.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.1214));
        dateLabel.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.1));
        //
        searchTextField.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.3344));
        searchTextField.prefHeightProperty().bind(rootHbox.heightProperty());
        //
        signInButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0844));
        signInButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.5));
        //
        signUpButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0844));
        signUpButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.5));
        // toggle switch
        nightModeToggleSwitchButton.prefWidthProperty().bind(rootHbox.widthProperty().multiply(.0544));
        nightModeToggleSwitchButton.prefHeightProperty().bind(rootHbox.heightProperty().multiply(.65));
        //
        rootHbox.prefWidthProperty().bind(widthProperty());
        rootHbox.prefHeightProperty().bind(heightProperty().multiply(.075));
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
     * @return logo label
     */
    public Label getLogoLabel() {
        return logoLabel;
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
