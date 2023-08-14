package com.app.fxplayer.controllers.componentscontroller;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.components.ToolBarView;

public class ToolbarViewController extends Controller {
    private ToolBarView toolBarView;

    public ToolbarViewController(View view) {
        super(view);
        toolBarView = (ToolBarView) view;
    }

    @Override
    public void init() {
        toolBarView.getSearchTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                String keyword = newValue;
                for (int i = 0; i < SongRepository.getSongList().size(); i++) {
                    Song currentSong = SongRepository.getSongList().get(i);
                    if (currentSong.getArtist().contains(keyword) ||
                            currentSong.getAlbum().contains(newValue) ||
                            currentSong.getTitle().contains(newValue)) {
//                        SongRepository.getSongList().select(currentSong);
                    } else {
                        System.out.println("Nothing Found...");
                    }
                }
            }
        });
    }
}
