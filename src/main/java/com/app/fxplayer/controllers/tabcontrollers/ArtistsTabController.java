package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.ArtistsView;

public class ArtistsTabController extends Controller {
    private final ArtistsView artistsView;
    public ArtistsTabController(View view) {
        super(view);
        artistsView = (ArtistsView) view;
    }

    @Override
    public void init() {
        // binding the artists repository to artist listview
        artistsView.getArtistListView().itemsProperty().bind(ModelRepository.getArtistList().itemsProperty());
        artistsView.getArtistListView().getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) ->
        {
            if (t1 != null)
            {
                System.out.println("artist backend working fine");
            }
        });
    }
}
