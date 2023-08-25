package com.app.fxplayer.views.subViews;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Font;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SongLyricsView extends View {
    private ScrollPane scrollPane;
    private Label songLyricsLabel;
    @Override
    public void init() {
        scrollPane = new ScrollPane();
        songLyricsLabel = new Label("song lyrics in here");
    }

    @Override
    public void build() {
        scrollPane.setContent(songLyricsLabel);
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
        songLyricsLabel.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        songLyricsLabel.prefWidthProperty().bind(scrollPane.widthProperty());
        songLyricsLabel.prefHeightProperty().bind(scrollPane.heightProperty());

        scrollPane.prefWidthProperty().bind(widthProperty());
        scrollPane.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        songLyricsLabel.setFont(Font.font(14));
    }
}
