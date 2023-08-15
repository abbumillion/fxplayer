package com.app.fxplayer.repo;

import com.app.fxplayer.models.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileRepo {
    public static ObservableList<Song> fileList = FXCollections.observableArrayList();

    public static ObservableList<Song> getFileList() {
        return fileList;
    }
}
