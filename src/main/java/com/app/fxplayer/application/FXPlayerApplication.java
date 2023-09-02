package com.app.fxplayer.application;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.controllers.LoaderController;
import com.app.fxplayer.controllers.PlayerViewController;
import com.app.fxplayer.db.LocalStorage;
import com.app.fxplayer.modelgenerator.AlbumCollector;
import com.app.fxplayer.modelgenerator.FileCollector;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
public class FXPlayerApplication extends Application {
    /**
     * APPLICATION MAIN SETTINGS OBJECT
     */
    private Settings appSettings;
    /**
     * APPLICATION CONFIGURATIONS
     */
    private static void configurations() {
        File[] DRIVES = {new File("C://Users"), new File("D://")};
        Task[] albumsTasks = new Task[4];
        for (int i = 0; i < DRIVES.length; i++) {
            albumsTasks[i] = new AlbumCollector(DRIVES[i]);
//            new Thread(albumsTasks[i]).start();
        }
        Task[] songTasks = new Task[4];
        // if first time collect songs
        if (!LocalStorage.getSettingsFile().exists() && !LocalStorage.getSettingsFile().exists()) {
            System.out.println("first time collecting songs");
            for (int i = 0; i < DRIVES.length; i++) {
                songTasks[i] = new FileCollector(DRIVES[i]);
                new Thread(songTasks[i]).start();
            }
        }
        // if not read from file
        else if (LocalStorage.getSettingsFile().exists() && LocalStorage.getSongsFile().exists()) {
            System.out.println("both songs and settings file exists");
            System.out.println("reading songs list");
            SongRepository.getSongList().addAll(LocalStorage.getSongList());
        }
        songTasks[0].setOnSucceeded(event -> {
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
                        .tabSide("TOP")
                        .totalSongs(SongRepository.getSongList().size())
                        .build();
                LocalStorage.saveAppSettings(settings);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        configurations();
       new LoaderController(new LoaderView()).init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

}


