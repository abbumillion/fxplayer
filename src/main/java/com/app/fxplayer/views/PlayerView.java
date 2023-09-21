package com.app.fxplayer.views;

import com.app.fxplayer.views.components.PlayerControlsView;
import com.app.fxplayer.views.tabs.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import lombok.*;

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
        rootVBox.getChildren().addAll(tabPane, playerControllerView);
        getChildren().addAll(rootVBox);
    }

    @Override
    public void align() {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.TOP);
        rootVBox.setAlignment(Pos.CENTER);
        setSpacing(2.5);
        setPadding(new Insets(.5,.5,.5,.5));
    }

    @Override
    public void bind() {
        tabPane.prefWidthProperty().bind(rootVBox.widthProperty());
        tabPane.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.975));
        playerControllerView.prefWidthProperty().bind(rootVBox.widthProperty());
        playerControllerView.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.025));
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
    }
}
