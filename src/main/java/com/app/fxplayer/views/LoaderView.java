package com.app.fxplayer.views;

import com.app.fxplayer.models.Song;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoaderView extends View {
    private ProgressIndicator progressIndicator;
    private ListView<Song> songListView;

    @Override
    public void init() {
        progressIndicator = new ProgressIndicator();
        songListView = new ListView<>();
//        getStartedButton = new Button("Get Started");
    }

    @Override
    public void build() {
        getChildren().addAll(songListView, progressIndicator);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
//        getStartedButton.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        songListView.prefWidthProperty().bind(widthProperty());
        songListView.prefHeightProperty().bind(heightProperty().multiply(.85));
    }

    @Override
    public void styling() {
    }
}
