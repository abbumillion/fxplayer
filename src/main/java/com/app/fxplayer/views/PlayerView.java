package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.tabs.*;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;


public class PlayerView extends View {
    private TabPane tabPane;
    private Tab myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,recentlyAddedTab,albumsTab,artistsTab,visualizationTab,settingsTab;
    private MyMusicView myMusicView;
    private NowPlayingView nowPlayingView;
    private MostPlayedView mostPlayedView;
    private RecentPlaysView recentPlaysView;
    private RecentlyAddedView recentlyAddedView;
    private AlbumsView albumsView;
    private ArtistsView artistsView;
    private PlaylistView playlistView;
    private VisualizationView visualizationView;
    private SettingsView settingsView;
    private PlayerControlsView playerControllerView;
    private VBox rootVBox;
    @Override
    public void init() {
        myMusicTab = new Tab("My Music");
        nowPlayingTab = new Tab("Now Playing");
        albumsTab = new Tab("Albums");
        artistsTab = new Tab("Artists");
        visualizationTab = new Tab("Visualization");
        settingsTab = new Tab("Settings");
        mostPlayedTab = new Tab("Most Played");
        recentPlaysTab = new Tab("Recent Plays");
        recentlyAddedTab = new Tab("Recent Added");
        tabPane = new TabPane();
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        mostPlayedView = new MostPlayedView();
        recentPlaysView = new RecentPlaysView();
        recentlyAddedView = new RecentlyAddedView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        visualizationView = new VisualizationView();
        settingsView = new SettingsView();
        playerControllerView = new PlayerControlsView();
        rootVBox = new VBox(0.0);
    }
    @Override
    public void build() {
        myMusicTab.setContent(myMusicView);
        nowPlayingTab.setContent(nowPlayingView);
        mostPlayedTab.setContent(mostPlayedView);
        recentPlaysTab.setContent(recentPlaysView);
        recentlyAddedTab.setContent(recentlyAddedView);
        albumsTab.setContent(albumsView);
        artistsTab.setContent(artistsView);
        visualizationTab.setContent(visualizationView);
        settingsTab.setContent(settingsView);
        tabPane.getTabs().addAll(myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,
                recentlyAddedTab,artistsTab,albumsTab,visualizationTab,settingsTab);
        rootVBox.getChildren().addAll(tabPane,playerControllerView);
        getChildren().addAll(rootVBox);

    }

    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
//        tabPane.setSide(Side.LEFT);
        rootVBox.setAlignment(Pos.CENTER);
    }


    @Override
    public void bind() {
        tabPane.prefWidthProperty().bind(rootVBox.widthProperty());
        tabPane.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.925));
        playerControllerView.prefWidthProperty().bind(rootVBox.widthProperty());
        playerControllerView.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.025));
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
    }
    @Override
    public void styling() {
      //  double imageWidth = 140.0;
//        ImageView myMusicTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
//      //  myMusicTabIcon.setFitHeight(imageWidth);
//      //  myMusicTabIcon.setFitWidth(imageWidth);
//        Label myMusicLabel = new Label("My Music");
//        double tabWidth = 100.0;
//        myMusicLabel.setMaxWidth(tabWidth - 20);
//        myMusicLabel.setPadding(new Insets(5, 0, 0, 0));
//        myMusicLabel.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
//        myMusicLabel.setTextAlignment(TextAlignment.CENTER);
//        BorderPane myMusicTabPane = new BorderPane();
//        myMusicTabPane.setRotate(90.0);
//        myMusicTabPane.setMaxWidth(tabWidth);
//        myMusicTabPane.setCenter(myMusicTabIcon);
//        myMusicTabPane.setBottom(myMusicLabel);
//        myMusicTab.setText("");
//        myMusicTab.setGraphic(myMusicTabPane);
        //
        ImageView artistTabIcon = new ImageView(new File("src/main/resources/images/artist.png").toURI().toASCIIString());
        //------------------------------------------------------------------------------------------------------//
      //  artistTabIcon.setFitHeight(imageWidth);
      //  artistTabIcon.setFitWidth(imageWidth);
//        Label artistsLabel = new Label("Artists");
//        artistsLabel.setMaxWidth(tabWidth - 20);
//        artistsLabel.setPadding(new Insets(5, 0, 0, 0));
//        artistsLabel.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
//        artistsLabel.setTextAlignment(TextAlignment.CENTER);
//        BorderPane artistsTabPane = new BorderPane();
//        artistsTabPane.setRotate(90.0);
//        artistsTabPane.setMaxWidth(tabWidth);
//        artistsTabPane.setCenter(myMusicTabIcon);
//        artistsTabPane.setBottom(artistsLabel);
//        artistsTab.setText("");
//        artistsTab.setGraphic(artistsTabPane);
        //---------------------------------------------------------------------------------------------------------//
        ImageView albumsTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView nowplayingTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView settingsTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView visualizationTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView mostPlayedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView recentPlaysTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView recentlyAddedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
//        myMusicTab.setGraphic(myMusicTabIcon);
//        artistsTab.setGraphic(artistTabIcon);
//        albumsTab.setGraphic(albumsTabIcon);
//        nowPlayingTab.setGraphic(nowplayingTabIcon);
//        recentlyAddedTab.setGraphic(recentlyAddedTabIcon);
//        recentPlaysTab.setGraphic(recentPlaysTabIcon);
//        settingsTab.setGraphic(settingsTabIcon);
//        visualizationTab.setGraphic(visualizationTabIcon);
//        mostPlayedTab.setGraphic(mostPlayedTabIcon);
    }

    public MyMusicView getMyMusicView() {
        return myMusicView;
    }


    public PlayerControlsView getPlayerControllerView() {
        return playerControllerView;
    }


    public AlbumsView getAlbumsView() {
        return albumsView;
    }

    public ArtistsView getArtistsView() {
        return artistsView;
    }


    public SettingsView getSettingsView() {
        return settingsView;
    }


    public NowPlayingView getNowPlayingView() {
        return nowPlayingView;
    }


    public VisualizationView getVisualizationView() {
        return visualizationView;
    }


    public MostPlayedView getMostPlayedView() {
        return mostPlayedView;
    }


    public RecentlyAddedView getRecentlyAddedView() {
        return recentlyAddedView;
    }

    public RecentPlaysView getRecentPlaysView() {
        return recentPlaysView;
    }
    //
}
