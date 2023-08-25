package com.app.fxplayer.application;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.db.LocalStorage;
import com.app.fxplayer.modelgenerator.FileCollector;
import com.app.fxplayer.repo.SongRepository;
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
    private Settings appSettings;

    private static final File[] DRIVES = { new File("C://Users"), new File("D://")};






    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        configurations();
        new PlayerViewController(new PlayerView()).init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    private static void configurations() {

        Task[] tasks = new Task[4];
        // if first time collect songs
        if (!LocalStorage.getSettingsFile().exists() && !LocalStorage.getSettingsFile().exists()) {
            System.out.println("first time collecting songs");
            for (int i = 0; i < DRIVES.length; i++) {
                tasks[i] = new FileCollector(DRIVES[i]);
                new Thread(tasks[i]).start();
            }
        }
        // if not read from file
        else if (LocalStorage.getSettingsFile().exists() && LocalStorage.getSongsFile().exists())
        {
            System.out.println("both songs and settings file exists");
            System.out.println("reading songs list");
            SongRepository.getSongList().addAll(LocalStorage.getSongList());
        }
        tasks[0].setOnSucceeded(event -> {
            try {
                System.out.println("task one successeded");
                System.out.println("saving songs to file");
                LocalStorage.saveSongList();
                // save settings file
                Settings settings = Settings
                        .builder()
                        .font("10.0")
                        .isFirstTime(false)
                        .isFullScreen(true)
                        .theme("dark")
                        .stageStyle("decorated")
                        .tabSide(TOP)
                        .totalSongs(SongRepository.getSongList().size())
                        .build();
                LocalStorage.saveAppSettings(settings);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });







    }








}


