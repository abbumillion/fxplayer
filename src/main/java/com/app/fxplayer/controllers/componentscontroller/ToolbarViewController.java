package com.app.fxplayer.controllers.componentscontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.ToolBarView;
import javafx.application.Platform;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ToolbarViewController extends Controller {
    private ToolBarView toolBarView;

    public ToolbarViewController(View view) {
        super(view);
        toolBarView = (ToolBarView) view;
    }

    @Override
    public void init() {
        timer();
        toolBarView.getSearchTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                String keyword = newValue;
                for (int i = 0; i < SongRepository.getSongList().size(); i++) {
                    Song currentSong = SongRepository.getSongList().get(i);
                    if (currentSong.getArtist().contains(keyword) ||
                            currentSong.getAlbum().contains(newValue) ||
                            currentSong.getTitle().contains(newValue)) {
                        Player.setCurrentSong(currentSong);
                        Player.play();
                        break;

                    } else {
                        System.out.println("Nothing Found...");
                    }
                }
            }
        });
    }

    private void timer() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                final String format = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    toolBarView.getDateLabel().setText(format);
                });
            }
        });
        thread.start();
    }
}
