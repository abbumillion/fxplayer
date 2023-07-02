package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.tabs.*;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.io.File;

/**
 * PLAYER VIEW CLASS
 * CONTAINS ALL UI'S
 */
public class PlayerView extends View {
    // main tabpane
    private TabPane tabPane;
    // tabpane contents with their own complex ui componenets
    private Tab myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,recentlyAddedTab,albumsTab,artistsTab,visualizationTab,settingsTab;
   // my music sub view
    private MyMusicView myMusicView;
    //now playing sub view
    private NowPlayingView nowPlayingView;
    // most played sub view
    private MostPlayedView mostPlayedView;
    // recent plays sub view
    private RecentPlaysView recentPlaysView;
    // recently added sub view
    private RecentlyAddedView recentlyAddedView;
    // albums sub view
    private AlbumsView albumsView;
    // artists sub view
    private ArtistsView artistsView;
    // playlist view
    private PlaylistView playlistView;
    // visualization sub view
    private VisualizationView visualizationView;
    // settings sub view
    private SettingsView settingsView;
    // player controller sub view
    private PlayerControlsView playerControllerView;
    // toolbar sub view

    // root v box
    private VBox rootVBox;

    /**
     *
     */
    @Override
    public void init() {
        // tabs
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
        // sub views
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        mostPlayedView = new MostPlayedView();
        recentPlaysView = new RecentPlaysView();
        recentlyAddedView = new RecentlyAddedView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        visualizationView = new VisualizationView();
        settingsView = new SettingsView();
        // components
        playerControllerView = new PlayerControlsView();
        // root
        rootVBox = new VBox(0.0);
        //
    }

    /**
     *
     */
    @Override
    public void build() {
        // set tabs to sub views
        myMusicTab.setContent(myMusicView);
        nowPlayingTab.setContent(nowPlayingView);
        mostPlayedTab.setContent(mostPlayedView);
        recentPlaysTab.setContent(recentPlaysView);
        recentlyAddedTab.setContent(recentlyAddedView);
        albumsTab.setContent(albumsView);
        artistsTab.setContent(artistsView);
        visualizationTab.setContent(visualizationView);
        settingsTab.setContent(settingsView);
        // add tabs to tab pane
        tabPane.getTabs().addAll(myMusicTab,nowPlayingTab,mostPlayedTab,recentPlaysTab,
                recentlyAddedTab,artistsTab,albumsTab,visualizationTab,settingsTab);
        // add all to the root
        rootVBox.getChildren().addAll(tabPane,playerControllerView);
        //add root to the view
        getChildren().addAll(rootVBox);
        //
    }

    /**
     *
     */
    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
    }

    /**
     *
     */
    @Override
    public void bind() {
        // tabpane width and height
        tabPane.prefWidthProperty().bind(rootVBox.widthProperty());
        tabPane.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.95));
        // bottom controls container width and height
        playerControllerView.prefWidthProperty().bind(rootVBox.widthProperty());
        playerControllerView.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.05));
        // root elements width and height
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
        //
    }
    @Override
    public void styling() {
        // correcting the tab width and height
        // to make it like navigation drawer
        // declaring all necessary imageviews for tab icons
        double imageWidth = 140.0;
        ImageView myMusicTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        myMusicTabIcon.setFitHeight(imageWidth);
        myMusicTabIcon.setFitWidth(imageWidth);
        Label myMusicLabel = new Label("My Music");
        double tabWidth = 190.0;
        myMusicLabel.setMaxWidth(tabWidth - 20);
        myMusicLabel.setPadding(new Insets(5, 0, 0, 0));
        myMusicLabel.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
        myMusicLabel.setTextAlignment(TextAlignment.CENTER);
        BorderPane myMusicTabPane = new BorderPane();
        myMusicTabPane.setRotate(90.0);
        myMusicTabPane.setMaxWidth(tabWidth);
        myMusicTabPane.setCenter(myMusicTabIcon);
        myMusicTabPane.setBottom(myMusicLabel);
        myMusicTab.setText("");
        myMusicTab.setGraphic(myMusicTabPane);
        //
        ImageView artistTabIcon = new ImageView(new File("src/main/resources/images/artist.png").toURI().toASCIIString());
        //------------------------------------------------------------------------------------------------------//
        artistTabIcon.setFitHeight(imageWidth);
        artistTabIcon.setFitWidth(imageWidth);
        Label artistsLabel = new Label("Artists");
        artistsLabel.setMaxWidth(tabWidth - 20);
        artistsLabel.setPadding(new Insets(5, 0, 0, 0));
        artistsLabel.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
        artistsLabel.setTextAlignment(TextAlignment.CENTER);
        BorderPane artistsTabPane = new BorderPane();
        artistsTabPane.setRotate(90.0);
        artistsTabPane.setMaxWidth(tabWidth);
        artistsTabPane.setCenter(myMusicTabIcon);
        artistsTabPane.setBottom(artistsLabel);
        artistsTab.setText("");
        artistsTab.setGraphic(artistsTabPane);
        //---------------------------------------------------------------------------------------------------------//
        ImageView albumsTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        albumsTabIcon.setFitHeight(imageWidth);
        albumsTabIcon.setFitWidth(imageWidth);
        //
        ImageView nowplayingTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        nowplayingTabIcon.setFitHeight(imageWidth);
        nowplayingTabIcon.setFitWidth(imageWidth);
        //
        ImageView settingsTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        settingsTabIcon.setFitHeight(imageWidth);
        settingsTabIcon.setFitWidth(imageWidth);
        //
        ImageView visualizationTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        visualizationTabIcon.setFitHeight(imageWidth);
        visualizationTabIcon.setFitWidth(imageWidth);
        //
        ImageView mostPlayedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        mostPlayedTabIcon.setFitHeight(imageWidth);
        mostPlayedTabIcon.setFitWidth(imageWidth);
        //
        ImageView recentPlaysTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        recentPlaysTabIcon.setFitHeight(imageWidth);
        recentPlaysTabIcon.setFitWidth(imageWidth);
        //
        ImageView recentlyAddedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        //
        recentlyAddedTabIcon.setFitHeight(imageWidth);
        recentlyAddedTabIcon.setFitWidth(imageWidth);
        //
        myMusicTab.setGraphic(myMusicTabIcon);
        artistsTab.setGraphic(artistTabIcon);
        albumsTab.setGraphic(albumsTabIcon);
        nowPlayingTab.setGraphic(nowplayingTabIcon);
        recentlyAddedTab.setGraphic(recentlyAddedTabIcon);
        recentPlaysTab.setGraphic(recentPlaysTabIcon);
        settingsTab.setGraphic(settingsTabIcon);
        visualizationTab.setGraphic(visualizationTabIcon);
        mostPlayedTab.setGraphic(mostPlayedTabIcon);
        //
        //

    }

    /**
     *
     * @return my music sub view
     */
    public MyMusicView getMyMusicView() {
        return myMusicView;
    }

    /**
     *
     * @return player controller sub view
     */
    public PlayerControlsView getPlayerControllerView() {
        return playerControllerView;
    }

    /**
     *
     * @return albums sub view
     */
    public AlbumsView getAlbumsView() {
        return albumsView;
    }

    /**
     *
     * @return artists sub view
     */
    public ArtistsView getArtistsView() {
        return artistsView;
    }

    /**
     *
     * @return settings sub view
     */
    public SettingsView getSettingsView() {
        return settingsView;
    }

    /**
     *
     * @return now playing sub view
     */
    public NowPlayingView getNowPlayingView() {
        return nowPlayingView;
    }

    /**
     *
     * @return visualization sub view
     */
    public VisualizationView getVisualizationView() {
        return visualizationView;
    }

    /**
     *
     * @return most played sub view
     */
    public MostPlayedView getMostPlayedView() {
        return mostPlayedView;
    }

    /**
     *
     * @return recently added sub view
     */
    public RecentlyAddedView getRecentlyAddedView() {
        return recentlyAddedView;
    }

    /**
     *
     * @return recently played sub view
     */
    public RecentPlaysView getRecentPlaysView() {
        return recentPlaysView;
    }
    //
    private void getThis()
    {
        System.out.println("Get this bro!");
    }
}
