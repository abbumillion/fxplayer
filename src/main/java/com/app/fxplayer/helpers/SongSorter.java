package com.app.fxplayer.helpers;

import com.app.fxplayer.views.PlayerView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongSorter implements Runnable {
    private PlayerView playerView;
    public void sortSongs() {
        // most played
        playerView.getMostPlayedView().getMostPlayedListView().getItems().sort((o1, o2) -> {
            if (o1.getNumberOfPlays() < o2.getNumberOfPlays())
                return 1;
            else
                return -1;
        });
        // recent plays
        playerView.getRecentPlaysView().getRecentPlaysListView().getItems().sort((o1, o2) -> {
            if (o1.getLastPlayedDate().after(o2.getLastPlayedDate()))
                return 1;
            else
                return -1;
        });
        // recent added
        playerView.getRecentlyAddedView().getRecentlyAddedListView().getItems().sort((o1, o2) -> {
            if (o1.getAddedDate().after(o2.getAddedDate()))
                return 1;
            else
                return -1;
        });
    }
    @Override
    public void run() {
        sortSongs();
    }
}
