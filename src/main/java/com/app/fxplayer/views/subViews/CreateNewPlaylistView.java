package com.app.fxplayer.views.subViews;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateNewPlaylistView extends View {
    private Label playListNameLabel;
    private Button savePlaylistButton;
    private TextField playlistNameTextField;

    @Override
    public void init() {
        playlistNameTextField = new TextField("playlist name");
        savePlaylistButton = new Button("save");
        playListNameLabel = new Label("Playlist Name :");
    }

    @Override
    public void build() {
        getChildren().addAll(playListNameLabel, playlistNameTextField, savePlaylistButton);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        playListNameLabel.setAlignment(Pos.CENTER);
        playlistNameTextField.setAlignment(Pos.CENTER);
        setSpacing(12.5);
    }

    @Override
    public void bind() {
        playListNameLabel.prefWidthProperty().bind(widthProperty());
        playListNameLabel.prefHeightProperty().bind(heightProperty().multiply(.1));
        playlistNameTextField.prefWidthProperty().bind(widthProperty());
        playlistNameTextField.prefHeightProperty().bind(heightProperty().multiply(.1));
        savePlaylistButton.prefWidthProperty().bind(widthProperty().multiply(.2));
        savePlaylistButton.prefHeightProperty().bind(heightProperty().multiply(.1));
    }

    @Override
    public void styling() {

    }
}
