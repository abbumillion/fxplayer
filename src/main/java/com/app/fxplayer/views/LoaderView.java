package com.app.fxplayer.views;

import com.app.fxplayer.helpers.StringConstants;
import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.listcells.SongCell;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

import java.io.File;

public class LoaderView extends View{
    private  Label loaderTitleLabel , numberOfSongsLabel , checkedNumberOfFilesLabel;
    private ListView loaderListView;
    private PlayerControlsView playerControlsView;
    private HBox bottomHBox;
    @Override
    public void init() {
        //
        bottomHBox = new HBox();
        loaderTitleLabel = new Label("loader title");
        numberOfSongsLabel = new Label("loader Message");
        checkedNumberOfFilesLabel = new Label("loader Message");
        loaderListView = new ListView<>();
        //
        playerControlsView = new PlayerControlsView();
        //
    }

    @Override
    public void build() {
        bottomHBox.getChildren().addAll(numberOfSongsLabel,checkedNumberOfFilesLabel);
        getChildren().addAll( loaderTitleLabel , loaderListView , playerControlsView );
    }

    @Override
    public void align() {
        loaderTitleLabel.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        playerControlsView.prefWidthProperty().bind(widthProperty());
        playerControlsView.prefHeightProperty().bind(heightProperty().multiply(.1));
        loaderListView.prefWidthProperty().bind(widthProperty());
        loaderListView.prefHeightProperty().bind(heightProperty().multiply(.9));
    }

    @Override
    public void styling() {
        loaderTitleLabel.setFont(Font.font(20));
        loaderListView.setCellFactory(songListView -> new SongCell());
    }
@Override
    public void showView()
{
        Scene scene = new Scene(this,WIDTH,HEIGHT);
        STAGE.setScene(scene);
        STAGE.setTitle(StringConstants.getSystemTitle());
        STAGE.getIcons().add(new Image(new File(StringConstants.getSystemIcon()).toURI().toASCIIString()));
        STAGE.setFullScreen(true);
        STAGE.initStyle(StageStyle.UNDECORATED);
        STAGE.show();
    }

    public Label getLoaderTitleLabel() {
        return loaderTitleLabel;
    }

    public Label getCheckedNumberOfFilesLabel() {
        return checkedNumberOfFilesLabel;
    }

    public ListView getLoaderListView() {
        return loaderListView;
    }

    public Label getNumberOfSongsLabel() {
        return numberOfSongsLabel;
    }

    public PlayerControlsView getPlayerControlsView() {
        return playerControlsView;
    }
}
