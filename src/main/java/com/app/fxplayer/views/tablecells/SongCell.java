package com.app.fxplayer.views.tablecells;

import com.app.fxplayer.models.models.Song;
import javafx.scene.control.TableCell;

/**
 * SONG CELL CLASS
 */
public class SongCell extends TableCell<Song,String> {
    @Override
    protected void updateItem(String s, boolean b) {
        super.updateItem(s, b);
        System.out.println(s);
    }
}
