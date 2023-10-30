package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.SpotifyViewCenterView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;

@Data
public class SpotifyView extends View {
    HBox hBox;
    VBox leftVBox,centerVBox,rightVBox;
    VBox leftVBoxTopVBox,leftVBoxBottomVBox;
    Button homeButton,searchButton,libraryButton,likedSongsButton,closeButton;
    ListView libraryListView;
    //
    SpotifyViewCenterView spotifyViewCenterView;
    //
    Label likedSongsLabel,songTitleLabel,artistNameLabel;
    //
    @Override
    public void init() {
        //
        libraryListView = new ListView<>();
        // buttons
        homeButton = new Button("home");
        searchButton = new Button("search");
        libraryButton = new Button("library");
        likedSongsButton = new Button("liked");
        //
        leftVBoxBottomVBox = new VBox();
        leftVBoxTopVBox = new VBox();
        leftVBox = new VBox();
        centerVBox = new VBox();
        rightVBox = new VBox();
        //
        spotifyViewCenterView = new SpotifyViewCenterView();
        //
    }

    @Override
    public void build() {
        leftVBoxTopVBox.getChildren().addAll(homeButton,searchButton);
        leftVBoxBottomVBox.getChildren().addAll(libraryButton,likedSongsButton,libraryListView);
        leftVBox.getChildren().addAll(leftVBoxTopVBox,leftVBoxBottomVBox);
        centerVBox.getChildren().addAll(spotifyViewCenterView);
        getChildren().addAll(leftVBox,centerVBox,rightVBox);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //
        leftVBoxTopVBox.prefWidthProperty().bind(leftVBox.widthProperty());
        leftVBoxTopVBox.prefHeightProperty().bind(leftVBox.heightProperty().multiply(.2));
        //
        leftVBoxBottomVBox.prefWidthProperty().bind(leftVBox.widthProperty());
        leftVBoxBottomVBox.prefHeightProperty().bind(leftVBox.heightProperty().multiply(.8));
        //
        leftVBox.prefWidthProperty().bind(widthProperty().multiply(.1));
        leftVBox.prefHeightProperty().bind(heightProperty());
        //
        centerVBox.prefWidthProperty().bind(widthProperty().multiply(.5));
        centerVBox.prefHeightProperty().bind(heightProperty());
        //
        rightVBox.prefWidthProperty().bind(widthProperty().multiply(.35));
        rightVBox.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        setPadding(new Insets(12.5));
        setMargin(this,new Insets(6.28));
    }
}
