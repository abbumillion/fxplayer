package com.app.fxplayer.controllers.viewcontroller;

import com.app.fxplayer.application.config.ApplicationDB;
import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.modelgenerator.Collector;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.audioplayer.Player;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.LoaderView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

import java.io.IOException;

public class LoaderViewController extends Controller {
    private final LoaderView loaderView;
    public LoaderViewController(View view) {
        super(view);
        loaderView = (LoaderView) view;
    }

    @Override
    public void init() throws InterruptedException, IOException {
//        if (ApplicationDB.isFirstTime())
//        {
//            System.out.println("first time");
//            firstTimeOperation();
//        }
//        else {
//            System.out.println("not first time");
//            // if the song file exists
//            // then load files from
//            // the song file and add
//            // it to the application
//            // song repository
//            if (ApplicationDB.getSongFile().exists()) {
//                System.out.println("song file exists");
//                PlayerViewController playerViewController = new PlayerViewController(new PlayerView());
//                playerViewController.init();
//                List<Song> songList = ApplicationDB.getSongListFromDatabase();
//                Iterator iterator = songList.listIterator();
//                while (iterator.hasNext()) {
//                    ModelRepository.getSongList().getItems().add((Song) iterator.next());
//                }
//            }
//            // if the song file
//            // doesn't exist
//            // start first time operation
//            else {
//                System.out.println("song file doesn't exists");
//                firstTimeOperation();
//            }
//        }
        firstTimeOperation();
        loaderView.getLoaderListView().itemsProperty().bind(ModelRepository.getSongList().itemsProperty());
        loaderView.showView();
        loaderView.getLoaderListView().getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) ->
        {
            if (t1 != null)
            {
                Song song = (Song) t1;
                Player.setCurrentSong(song);
                Player.play();
            }
        });
    }
    private void firstTimeOperation() throws IOException {
        Collector collector = new Collector();
        new Thread(collector).start();
        collector.setOnRunning(Event->{
            loaderView.hideView();
            PlayerViewController playerViewController = new PlayerViewController(new PlayerView());
            playerViewController.init();
        });
        // on successed add collections to a file on the hard disk
        collector.setOnSucceeded(e->{
            try {
                ApplicationDB.saveSongListToDataBase(ModelRepository.getSongList().getItems());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
//        ApplicationDB.saveStartUpFileToDataBase();
    }
}
