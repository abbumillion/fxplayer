package com.app.fxplayer.controllers;

import com.app.fxplayer.application.config.Settings;
import com.app.fxplayer.db.LocalStorage;
import com.app.fxplayer.modelgenerator.FileCollector;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;
import javafx.concurrent.Task;

import java.io.File;
import java.io.IOException;

import static javax.swing.JSplitPane.TOP;

public class LoaderViewController extends Controller{
    private Settings appSettings;
    private static final File[] DRIVES = { new File("C://"), new File("D://")};
    private final LoaderView loaderView;
    public LoaderViewController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
        configurations();
        loaderView.showView();
    }
    private  void configurations() {

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
        // start the main player app controller
        PlayerView playerView = new PlayerView();
        PlayerViewController playerViewController = new PlayerViewController(playerView);
        // starting tasks
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
                loaderView.hideView();
                playerViewController.init();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        loaderView.getSongListView().itemsProperty().set(SongRepository.getSongList());
        loaderView.getSongListView().getSelectionModel().selectedItemProperty().addListener((observableValue, song1, song2) ->
        {
            if (song2 != null) {
                Player.setCurrentSong(song2);
                Player.setPlayerView(playerView);
                Player.play();
            }
        });
        // binding the loader player controls view to main player controls view and start playing
        // right away
        loaderView.getPlayerControlsView().getNextButton().setOnAction(actionEvent -> {playerView.getPlayerControllerView().getNextButton().fire();});
        loaderView.getPlayerControlsView().getFullScreenJFXButton().setOnAction(actionEvent -> {view.setFullScreen();});
        loaderView.getPlayerControlsView().getPrevButton().setOnAction(actionEvent -> {playerView.getPlayerControllerView().getPrevButton().fire();});
        loaderView.getPlayerControlsView().getPauseButton().setOnAction(actionEvent -> {playerView.getPlayerControllerView().getPauseButton().fire();});
        loaderView.getPlayerControlsView().getDurationSlider().valueProperty().bindBidirectional(playerView.getPlayerControllerView().getDurationSlider().valueProperty());
        loaderView.getPlayerControlsView().getStartDurationLabel().textProperty().bindBidirectional(playerView.getPlayerControllerView().getStartDurationLabel().textProperty());
        loaderView.getPlayerControlsView().getEndDurationLabel().textProperty().bindBidirectional(playerView.getPlayerControllerView().getEndDurationLabel().textProperty());
        loaderView.getPlayerControlsView().getSongTitleLabel().textProperty().bindBidirectional(playerView.getPlayerControllerView().getSongTitleLabel().textProperty());
        loaderView.backgroundProperty().bind(playerView.getNowPlayingView().backgroundProperty());
    }
}
