package com.app.fxplayer.application;

import com.app.fxplayer.db.LocalStorage;
import com.app.fxplayer.modelgenerator.FileCollector;
import com.app.fxplayer.repo.SongRepository;
import javafx.application.Application;
import java.io.File;
import java.io.FileNotFoundException;

public class app {
    public static void main(String[] args) throws Exception {
        Application.launch(FXPlayerApplication.class);
    }


}
