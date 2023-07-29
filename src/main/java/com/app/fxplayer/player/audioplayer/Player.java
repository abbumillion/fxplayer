package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.player.visualization.AudioPlayerSpectrumListener;
import com.app.fxplayer.player.visualization.soundcloud.WaveFormService;
import com.app.fxplayer.views.PlayerView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public final class Player {
    private static PlayerView playerView;
    private static MediaPlayer mediaPlayer;
    public static void play() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        if ( playerView != null) {
            updatePlayerView();
        }
    }

    public static void next() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        if ( playerView != null) {
            updatePlayerView();
        }
    }

    public static void prev() {
        checkMediaPlayer();
        File file = new File(MediaQueue.getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        if ( playerView != null) {
            updatePlayerView();
        }

    }

    private static void checkMediaPlayer() {
        if (mediaPlayer != null)
            mediaPlayer.dispose();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void dispose() {
        mediaPlayer.dispose();
    }

    private static void updatePlayerView()
    {
        if ( mediaPlayer != null )
        {
            //wave visualization
            playerView.getPlayerControllerView().getWaveVisualization().getWaveService().startService(new File(MediaQueue.getCurrentSong().getSource()), WaveFormService.WaveFormJob.AMPLITUDES_AND_WAVEFORM);
            //
            playerView.getPlayerControllerView().getPauseButton().setOnAction(actionEvent -> play());
            playerView.getPlayerControllerView().getPrevButton().setOnAction(actionEvent -> prev());
            playerView.getPlayerControllerView().getNextButton().setOnAction(actionEvent -> next());
            playerView.getPlayerControllerView().getFullScreenJFXButton().setOnAction(actionEvent -> playerView.setFullScreen());
            mediaPlayer.volumeProperty().bind(playerView.getPlayerControllerView().getVolumeSlider().valueProperty());
            mediaPlayer.rateProperty().bind(playerView.getPlayerControllerView().getRateSlider().valueProperty());
            mediaPlayer.balanceProperty().bind(playerView.getPlayerControllerView().getBalanceSlider().valueProperty());
            playerView.getPlayerControllerView().getSongImageView().imageProperty().bind(MediaQueue.getCurrentSong().getImage().imageProperty());
            playerView.getMyMusicView().getImageView().imageProperty().bind(MediaQueue.getCurrentSong().getImage().imageProperty());
            playerView.getNowPlayingView().getImageView().imageProperty().bind(MediaQueue.getCurrentSong().getImage().imageProperty());
            AudioPlayerSpectrumListener audioPlayerSpectrumListener = new AudioPlayerSpectrumListener(playerView.getVisualizationView());
            mediaPlayer.setAudioSpectrumListener(audioPlayerSpectrumListener);
            mediaPlayer.totalDurationProperty().addListener((observableValue, duration, t1) -> {});
            mediaPlayer.startTimeProperty().addListener((observableValue, duration, t1) -> {});
            mediaPlayer.bufferProgressTimeProperty().addListener((observableValue, duration, t1) -> {});
            mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {});
            mediaPlayer.audioSpectrumIntervalProperty().addListener((observableValue, duration, t1) -> {});
            mediaPlayer.setOnEndOfMedia(() -> next());
            playerView.getPlayerControllerView().getVolumeLevelLabel().textProperty().bind(mediaPlayer.volumeProperty().asString());
         //   playerView.getPlayerControllerView().getRateLevelLabel().textProperty().bind(mediaPlayer.rateProperty().asString());
            playerView.getPlayerControllerView().getBalanceLevelLabel().textProperty().bind(mediaPlayer.balanceProperty().asString());
        }
    }

    public static void setPlayerView(PlayerView playerView1) {
        Player.playerView = playerView1;
    }


    static class PlayerDurationHandler{
        public void handleDuration()
        {
            mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {
                if (t1 != null)
                {
                    System.out.println(t1);
                }
            });
            //
//            //Code for Volume Slider
////            playerView.getPlayerControllerView().getVolumeSlider().setValue(0.7 * 100);
////            playerView.valueProperty().addListener((Observable observable) -> {
////                mp.setVolume(volumeSlider.getValue()/100);
////            });
//            //Code for seeking bar
//
////            playerView.getPlayerControllerView().getDurationSlider().maxProperty().bind(Bindings.createDoubleBinding(
////                    () -> mediaPlayer.getTotalDuration().toSeconds(),
////                    mediaPlayer.totalDurationProperty()));
//
//            mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
//                playerView.getPlayerControllerView().getDurationSlider().setValue(newValue.toSeconds());
//            });
//
//            playerView.getPlayerControllerView().getDurationSlider().valueProperty().addListener((observableValue, number, t1) -> {
//                if ( t1 != null )
//                {
//                    mediaPlayer.seek(Duration.seconds(t1.doubleValue()));
//                }
//            });
////            playerView.getPlayerControllerView().setOnMouseClicked((MouseEvent event) -> {
////                mp.seek(Duration.seconds(seekSlider.getValue()));
////            });
//            //
        }
    }

}


