package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.visualization.AudioPlayerSpectrumListener;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.PlayerView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public final class Player {
    private static PlayerView playerView;
    private static Song currentSong;
    private static MediaPlayer mediaPlayer;
    public static void prev(){
        int currentSongIndex = ModelRepository.getSongList().getItems().indexOf(currentSong);
        ModelRepository.getSongList().getSelectionModel().select(currentSongIndex - 1);
    }
    public static void play() {
        checkMediaPlayer();
        File file = new File(getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        updatePlayerView();
    }
    public static void next(){
        int currentSongIndex = ModelRepository.getSongList().getItems().indexOf(currentSong);
        ModelRepository.getSongList().getSelectionModel().select(currentSongIndex + 1);
    }
    public static Song getCurrentSong() {
        return currentSong;
    }



    private static void checkMediaPlayer() {
        if (mediaPlayer != null)
            mediaPlayer.dispose();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    private static void updatePlayerView()
    {
        if ( mediaPlayer != null )
        {
            mediaPlayer.setAudioSpectrumNumBands(128);
            playerView.getPlayerControllerView().getPauseButton().setOnAction(actionEvent -> play());
            playerView.getPlayerControllerView().getPrevButton().setOnAction(actionEvent -> prev());
            playerView.getPlayerControllerView().getNextButton().setOnAction(actionEvent -> next());
            playerView.getPlayerControllerView().getFullScreenJFXButton().setOnAction(actionEvent -> playerView.setFullScreen());
            mediaPlayer.volumeProperty().bind(playerView.getPlayerControllerView().getVolumeSlider().valueProperty());
            mediaPlayer.rateProperty().bind(playerView.getPlayerControllerView().getRateSlider().valueProperty());
            mediaPlayer.balanceProperty().bind(playerView.getPlayerControllerView().getBalanceSlider().valueProperty());
            playerView.getPlayerControllerView().getSongImageView().imageProperty().bind(getCurrentSong().getImage().imageProperty());
            playerView.getMyMusicView().getImageView().imageProperty().bind(getCurrentSong().getImage().imageProperty());
            //
            playerView.getNowPlayingView().getImageView().imageProperty().bind(getCurrentSong().getImage().imageProperty());
            // create a background with current playing song image
            Image image = getCurrentSong().getImage().getImage();
//            image.splayerView.getNowPlayingView().widthProperty().get(),playerView.getNowPlayingView().heightProperty().get(),true,true);
            if (image != null) {

                BackgroundImage backgroundImage = new BackgroundImage(image
                        ,
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                        new BackgroundSize(
                                playerView.getNowPlayingView().widthProperty().get(),
                                playerView.getNowPlayingView().heightProperty().get(),
                                false,
                                false,
                                true,
                                true
                        ));
                GaussianBlur blur = new GaussianBlur(20);
                playerView.getNowPlayingView().getImageView().setEffect(blur);
                playerView.getNowPlayingView().setBackground(new Background(backgroundImage));
            }
            //
            playerView.getPlayerControllerView().getVolumeLevelLabel().textProperty().bind(mediaPlayer.volumeProperty().asString());
            playerView.getPlayerControllerView().getRateLevelLabel().textProperty().bind(mediaPlayer.rateProperty().asString());
            playerView.getPlayerControllerView().getBalanceLevelLabel().textProperty().bind(mediaPlayer.balanceProperty().asString());
            mediaPlayer.setOnEndOfMedia(() -> next());
            mediaPlayer.setOnPlaying(() -> {});
            mediaPlayer.setAutoPlay(true);
            AudioPlayerSpectrumListener audioPlayerSpectrumListener = new AudioPlayerSpectrumListener(playerView.getVisualizationView());
            mediaPlayer.setAudioSpectrumListener(audioPlayerSpectrumListener);
            ModelRepository.getSongList().getSelectionModel().selectedItemProperty().addListener((observableValue, song, t1) -> {
                if (t1 != null)
                {
                    playerView.getMyMusicView().getSongListView().getSelectionModel().select(t1);
                }
            });
            mediaPlayer.setOnReady(()->{
                mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {
                    if ( t1 != null )
                    {
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getDurationSlider().valueProperty().set(seconds);
                        playerView.getPlayerControllerView().getStartDurationLabel().setText(formattedTime);
                    }
                });
                // start time
                mediaPlayer.startTimeProperty().addListener((observableValue, duration, t1) ->
                {
                    if (t1 != null)
                    {
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getStartDurationLabel().setText(formattedTime);
                    }
                });
                // stop time
                mediaPlayer.totalDurationProperty().addListener((observableValue, duration, t1) -> {
                    if (t1 != null)
                    {
                        System.out.println(t1);
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getEndDurationLabel().setText(formattedTime);
                        playerView.getPlayerControllerView().getDurationSlider().setMax(seconds);
                    }
                });
                playerView.getPlayerControllerView().getDurationSlider().setOnMousePressed(event->{
                    mediaPlayer.seek(Duration.seconds(playerView.getPlayerControllerView().getDurationSlider().getValue()));
                });
            });
        }
    }

    private static String formatTime(double seconds) {
        String s = String.valueOf(seconds);
        seconds /= 60;
        String m = String.valueOf(seconds % 60);
        seconds /= 60;
        String h = String.valueOf(seconds % 24);
        return h + ":" + m + ":" + s;
    }

    public static void setPlayerView(PlayerView playerView1) {
        Player.playerView = playerView1;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setCurrentSong(Song currentSong) {
        Player.currentSong = currentSong;
    }
}


