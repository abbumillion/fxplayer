package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.components.ToolBarView;
import com.app.fxplayer.views.tabs.*;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.*;

import java.io.File;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PlayerView extends View {
    private TabPane tabPane;
    private Tab myMusicTab, nowPlayingTab, mostPlayedTab, recentPlaysTab,
            recentlyAddedTab, albumsTab, artistsTab, playlistTab, favoriteSongsTab,
            barChartVisualizationTab, canvasVirtualizationTab, lineChartVisualizationTab, audioEqualizerTab, settingsTab;
    private MyMusicView myMusicView;
    private NowPlayingView nowPlayingView;
    private MostPlayedView mostPlayedView;
    private RecentPlaysView recentPlaysView;
    private RecentlyAddedView recentlyAddedView;
    private AlbumsView albumsView;
    private ArtistsView artistsView;
    private PlaylistView playlistView;
    private FavoriteSongsView favoriteSongsView;
    private BarChartVisualizationView barChartVisualizationView;
    private CanvasVisualizationView canvasVisualizationView;
    private LineChartVisualizationView lineChartVisualizationView;
    private AudioEqualizerView audioEqualizerView;
    private SettingsView settingsView;
    private PlayerControlsView playerControllerView;
    private ToolBarView toolBarView;
    private VBox rootVBox;

    @Override
    public void init() {
        myMusicTab = new Tab("My Music");
        nowPlayingTab = new Tab("Now Playing");
        albumsTab = new Tab("Albums");
        artistsTab = new Tab("Artists");
        audioEqualizerTab = new Tab("Equalizer");
        barChartVisualizationTab = new Tab("Bar Chart");
        canvasVirtualizationTab = new Tab("Canvas");
        lineChartVisualizationTab = new Tab("Line Chart");
        settingsTab = new Tab("Settings");
        mostPlayedTab = new Tab("Most Played");
        recentPlaysTab = new Tab("Recent Plays");
        recentlyAddedTab = new Tab("Recently Added");
        playlistTab = new Tab("Playlists");
        favoriteSongsTab = new Tab("Favorites");
        tabPane = new TabPane();
        myMusicView = new MyMusicView();
        nowPlayingView = new NowPlayingView();
        mostPlayedView = new MostPlayedView();
        recentPlaysView = new RecentPlaysView();
        recentlyAddedView = new RecentlyAddedView();
        albumsView = new AlbumsView();
        artistsView = new ArtistsView();
        barChartVisualizationView = new BarChartVisualizationView();
        canvasVisualizationView = new CanvasVisualizationView();
        lineChartVisualizationView = new LineChartVisualizationView();
        audioEqualizerView = new AudioEqualizerView();
        settingsView = new SettingsView();
        playlistView = new PlaylistView();
        favoriteSongsView = new FavoriteSongsView();
        playerControllerView = new PlayerControlsView();
        toolBarView = new ToolBarView();
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
        barChartVisualizationTab.setContent(barChartVisualizationView);
        canvasVirtualizationTab.setContent(canvasVisualizationView);
        lineChartVisualizationTab.setContent(lineChartVisualizationView);
        audioEqualizerTab.setContent(audioEqualizerView);
        playlistTab.setContent(playlistView);
        favoriteSongsTab.setContent(favoriteSongsView);
        settingsTab.setContent(settingsView);
        tabPane.getTabs().addAll(myMusicTab, nowPlayingTab, mostPlayedTab, recentPlaysTab,
                recentlyAddedTab, artistsTab, albumsTab, playlistTab, favoriteSongsTab, barChartVisualizationTab,
                canvasVirtualizationTab, lineChartVisualizationTab
                , audioEqualizerTab, settingsTab);
        rootVBox.getChildren().addAll(toolBarView, tabPane, playerControllerView);
        getChildren().addAll(rootVBox);
    }

    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.TOP);
        rootVBox.setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        tabPane.prefWidthProperty().bind(rootVBox.widthProperty());
        tabPane.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.9));
        playerControllerView.prefWidthProperty().bind(rootVBox.widthProperty());
        playerControllerView.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.025));
        toolBarView.prefWidthProperty().bind(rootVBox.widthProperty());
        toolBarView.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.075));
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        ImageView myMusicTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/download (3).png").toURI().toASCIIString());
        ImageView albumsTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/album-icon-6.jpg").toURI().toASCIIString());
        ImageView artistsTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/artist.png").toURI().toASCIIString());
        ImageView nowplayingTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/1200x630wa.png").toURI().toASCIIString());
        ImageView settingsTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/download (4).png").toURI().toASCIIString());
        ImageView visualizationTabIcon = new ImageView(new File("src/main/resources/icons/tabicons/istockphoto-1367611853-640x640.jpg").toURI().toASCIIString());
        ImageView mostPlayedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView recentPlaysTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        ImageView recentlyAddedTabIcon = new ImageView(new File("src/main/resources/images/song.png").toURI().toASCIIString());
        myMusicTabIcon.setFitWidth(38);
        myMusicTabIcon.setFitHeight(32);
        myMusicTabIcon.setPreserveRatio(true);
        nowplayingTabIcon.setFitWidth(38);
        nowplayingTabIcon.setFitHeight(32);
        nowplayingTabIcon.setPreserveRatio(true);
        albumsTabIcon.setFitWidth(38);
        albumsTabIcon.setFitHeight(32);
        artistsTabIcon.setPreserveRatio(true);
        artistsTabIcon.setFitWidth(38);
        artistsTabIcon.setFitHeight(32);
        artistsTabIcon.setPreserveRatio(true);
        albumsTabIcon.setFitWidth(38);
        albumsTabIcon.setFitHeight(32);
        albumsTabIcon.setPreserveRatio(true);
        visualizationTabIcon.setFitWidth(38);
        visualizationTabIcon.setFitHeight(32);
        visualizationTabIcon.setPreserveRatio(true);
        settingsTabIcon.setFitWidth(38);
        settingsTabIcon.setFitHeight(32);
        settingsTabIcon.setPreserveRatio(true);
    }

}
