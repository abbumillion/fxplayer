package com.app.fxplayer.application;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.LoaderViewController;
import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.db.LocalStorage;
import com.app.fxplayer.modelgenerator.FileCollector;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.stage.StageStyle.DECORATED;
import static javax.swing.JSplitPane.TOP;

public class FXPlayerApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        new LoaderViewController(new LoaderView()).init();
    }
}


