package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.visualization.AudioPlayerSpectrumListener;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.PlayerView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public final class Player {
    private static PlayerView playerView;
    private static Song currentSong;
    private static MediaPlayer mediaPlayer;

    public static void prev() {
        int currentSongIndex = SongRepository.getSongList().indexOf(currentSong);
        playerView.getMyMusicView().getSongTableView().getSelectionModel().select(currentSongIndex - 1);
    }

    public static void play() {
        checkMediaPlayer();
        File file = new File(getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        updatePlayerView();
        refreshView();
    }

    private static void refreshView() {
        playerView.getMyMusicView().getSongTableView().refresh();
        playerView.getAlbumsView().getAlbumListView().refresh();
        playerView.getArtistsView().getArtistListView().refresh();
        playerView.getMostPlayedView().getMostPlayedListView().refresh();
        playerView.getRecentlyAddedView().getRecentlyAddedListView().refresh();
        playerView.getRecentPlaysView().getRecentPlaysListView().refresh();
        playerView.getPlaylistView().getPlaylistListView().refresh();
    }

    public static void next() {
        int currentSongIndex = SongRepository.getSongList().indexOf(currentSong);
        playerView.getMyMusicView().getSongTableView().getSelectionModel().select(currentSongIndex + 1);
    }

    public static Song getCurrentSong() {
        return currentSong;
    }

    public static void setCurrentSong(Song currentSong) {
        Player.currentSong = currentSong;
    }

    private static void checkMediaPlayer() {
        if (mediaPlayer != null)
            mediaPlayer.dispose();
    }

    private static void updatePlayerView() {
        playerView.getPlayerControllerView().getFullScreenJFXButton().setOnAction(actionEvent -> playerView.setFullScreen());
        if (mediaPlayer != null) {
            mediaPlayer.setAudioSpectrumNumBands(127);
            playerView.getPlayerControllerView().getPauseButton().setOnAction(actionEvent -> play());
            playerView.getPlayerControllerView().getPrevButton().setOnAction(actionEvent -> prev());
            playerView.getPlayerControllerView().getNextButton().setOnAction(actionEvent -> next());
            playerView.getPlayerControllerView().getSongTitleLabel().setText(getCurrentSong().getTitle());
            playerView.getMyMusicView().getImageView().setImage(getCurrentSong().getSongImage());
            playerView.getMyMusicView().getSongTitleLabel().setText(getCurrentSong().getTitle());
            playerView.getNowPlayingView().getImageView().setImage(getCurrentSong().getSongImage());
            // cheeck the image if it exists
            BackgroundImage backgroundImage = new BackgroundImage(getCurrentSong().getSongImage()
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
            mediaPlayer.setOnEndOfMedia(() -> next());
            mediaPlayer.setOnPlaying(() -> {
            });
            mediaPlayer.setAutoPlay(true);
            AudioPlayerSpectrumListener audioPlayerSpectrumListener = new AudioPlayerSpectrumListener(playerView);
            mediaPlayer.setAudioSpectrumListener(audioPlayerSpectrumListener);
            mediaPlayer.setOnReady(() -> {
                mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {
                    if (t1 != null) {
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getDurationSlider().valueProperty().set(seconds);
                        playerView.getPlayerControllerView().getStartDurationLabel().setText(formattedTime);
                    }
                });
                mediaPlayer.startTimeProperty().addListener((observableValue, duration, t1) ->
                {
                    if (t1 != null) {
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getStartDurationLabel().setText(formattedTime);
                    }
                });
                mediaPlayer.totalDurationProperty().addListener((observableValue, duration, t1) -> {
                    if (t1 != null) {
                        System.out.println(t1);
                        double seconds = t1.toSeconds();
                        String formattedTime = formatTime(seconds);
                        playerView.getPlayerControllerView().getEndDurationLabel().setText(formattedTime);
                        playerView.getPlayerControllerView().getDurationSlider().setMax(seconds);
                    }
                });
                playerView.getPlayerControllerView().getDurationSlider().setOnMousePressed(event -> {
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

}


