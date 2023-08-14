package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.Album;
import javafx.scene.control.ListCell;

public class AlbumCell extends ListCell<Album> {
    @Override
    protected void updateItem(Album album, boolean b) {
        super.updateItem(album, b);
        if (album != null) {
            System.out.println(album);
        }
    }
}
