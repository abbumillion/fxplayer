package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.models.Playlist;
import javafx.scene.control.ListCell;

public class PlaylistCell extends ListCell<Playlist> {
    @Override
    protected void updateItem(Playlist playlist, boolean b) {
        super.updateItem(playlist, b);
        if (playlist != null)
        {
            System.out.println(playlist);
        }
    }
}
