package com.app.fxplayer.player.audioplayer;

import com.app.fxplayer.controllers.ArtistDetailViewController;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.player.visualization.AudioPlayerSpectrumListener;
import com.app.fxplayer.repo.SongRepository;
import com.app.fxplayer.views.ArtistDetailView;
import com.app.fxplayer.views.PlayerView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public final class Player {
    private static PlayerView playerView;
    private static Song currentSong;
    private static MediaPlayer mediaPlayer;

    public static void prev() {
        int currentSongIndex = SongRepository.getSongList().indexOf(currentSong);
        playerView.getMyMusicView().getSongListView().getSelectionModel().select(currentSongIndex - 1);
        playerView.getMyMusicView().getSongListView().scrollTo(currentSongIndex - 1);
    }

    public static void next() {
        int currentSongIndex = SongRepository.getSongList().indexOf(currentSong);
        playerView.getMyMusicView().getSongListView().getSelectionModel().select(currentSongIndex + 1);
        playerView.getMyMusicView().getSongListView().scrollTo(currentSongIndex + 1);
    }

    public static void play() {
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        File file = new File(getCurrentSong().getSource());
        Media media = new Media(file.toURI().toASCIIString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        updatePlayerView();
//        refreshView();
    }

    private static void refreshView() {
        playerView.getMyMusicView().getSongListView().refresh();
        playerView.getAlbumsView().getAlbumListView().refresh();
        playerView.getArtistsView().getArtistListView().refresh();
        playerView.getMostPlayedView().getMostPlayedListView().refresh();
        playerView.getRecentlyAddedView().getRecentlyAddedListView().refresh();
        playerView.getRecentPlaysView().getRecentPlaysListView().refresh();
        playerView.getPlaylistView().getPlaylistListView().refresh();
//        new SongSorter(playerView).sortSongs();
    }

    public static Song getCurrentSong() {
        return currentSong;
    }

    public static void setCurrentSong(Song currentSong) {
        Player.currentSong = currentSong;
    }

    private static void updatePlayerView() {
        playerView.getPlayerControllerView().getFullScreenJFXButton().setOnAction(actionEvent -> playerView.setFullScreen());
        playerView.getMyMusicView().getSongArtistHyperLink().setOnAction(event -> {
            ArtistDetailViewController artistDetailViewController = new ArtistDetailViewController(new ArtistDetailView());
            try {
                System.out.println("show some artist information to the user on the screen please...");
                artistDetailViewController.init();
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
            try {
                artistDetailViewController.init();
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        });
        playerView.getPlayerControllerView().getLyricsButton().setOnAction(event -> {
            System.out.println("we need spotify api for this. ");
            System.out.println("show song lyrics");
            System.out.println("show song lyrics");
            System.out.println("show song lyrics");
            System.out.println("show song lyrics");
            System.out.println("show song lyrics");
        });
        if (mediaPlayer != null) {
            mediaPlayer.setAudioSpectrumNumBands(128);
            mediaPlayer.setVolume(10.0);
            playerView.getPlayerControllerView().getPauseButton().setOnAction(actionEvent -> play());
            playerView.getPlayerControllerView().getPrevButton().setOnAction(actionEvent -> prev());
            playerView.getPlayerControllerView().getNextButton().setOnAction(actionEvent -> next());
            playerView.getMyMusicView().getImageView().setImage(getCurrentSong().getSongImage());
            playerView.getMyMusicView().getSongTitleHyperLink().setText(getCurrentSong().getTitle());
            playerView.getMyMusicView().getSongArtistHyperLink().setText(getCurrentSong().getArtist());
            playerView.getNowPlayingView().getImageView().setImage(getCurrentSong().getSongImage());
            applyCurrentSongImageToNowPlayingBackground();
            registerPlayerEvents();
            AudioPlayerSpectrumListener audioPlayerSpectrumListener = new AudioPlayerSpectrumListener(playerView);
            mediaPlayer.setAudioSpectrumListener(audioPlayerSpectrumListener);
        }
    }

    private static void registerPlayerEvents() {
        mediaPlayer.setOnEndOfMedia(Player::next);
        /**
         * update media player current time to the ui
         * this event is fired only if the media player
         * is playing
         */
        mediaPlayer.setOnPlaying(() -> {
            mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {
                if (t1 != null) {
                    // get current millis from the player
                    double milliSeconds = t1.toMillis();
                    // format the time
                    String formattedTime = formatTime(milliSeconds);
                    // update the duration slider value
                    playerView.getPlayerControllerView().getDurationSlider().valueProperty().set(milliSeconds);
                    // update the duration label to current media player time
                    playerView.getPlayerControllerView().getStartDurationLabel().setText(formattedTime);
                }
            });
            double songDuration = mediaPlayer.getTotalDuration().toSeconds() * 1000;
            playerView.getPlayerControllerView().getEndDurationLabel().setText(formatTime(songDuration));
            playerView.getPlayerControllerView().getDurationSlider().setMax(songDuration);
            playerView.getPlayerControllerView().getDurationSlider().setOnMousePressed(event -> {
                mediaPlayer.seek(Duration.millis(playerView.getPlayerControllerView().getDurationSlider().getValue()));
            });
        });
    }

    private static void applyCurrentSongImageToNowPlayingBackground() {
        if (currentSong.getSongImage() != null) {
            BackgroundImage backgroundImage = new BackgroundImage(getCurrentSong().getSongImage(),
                    BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                    new BackgroundSize(
                            playerView.getNowPlayingView().widthProperty().get(),
                            playerView.getNowPlayingView().heightProperty().get(),
                            false,
                            false,
                            true,
                            true
                    ));
//            GaussianBlur blur = new GaussianBlur(20);
//            playerView.getNowPlayingView().getImageView().setEffect(blur);
            playerView.getNowPlayingView().setBackground(new Background(backgroundImage));
        }
    }

    private static String formatTime(double millis) {
        int minutes = (int) ((millis / 1000) / 60);
        int seconds = (int) ((millis / 1000) % 60);
        return minutes + ":" + seconds;
    }

    public static void setPlayerView(PlayerView playerView) {
        Player.playerView = playerView;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}


