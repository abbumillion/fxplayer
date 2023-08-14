package com.app.fxplayer.views.listcells;

import com.app.fxplayer.models.Artist;
import javafx.scene.control.ListCell;

public class ArtistCell extends ListCell<Artist> {
    @Override
    protected void updateItem(Artist artist, boolean b) {
        super.updateItem(artist, b);
        if (artist != null) {
            System.out.println(artist);
        }
    }
}
