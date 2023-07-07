package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.Song;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;

public  class SongCell extends ListCell<Song> {
    // common things for song cells
    // like content

    @Override
    protected void updateItem(Song song, boolean b) {

        super.updateItem(song, b);
        if (song != null)
        {
            //
            setGraphic(new Label(song.getTitle()));

        }
    }
}
