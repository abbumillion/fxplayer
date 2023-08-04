package com.app.fxplayer.controllers.tabcontrollers;

import com.app.fxplayer.controllers.Controller;
import com.app.fxplayer.models.Album;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.ModelRepository;
import com.app.fxplayer.views.View;
import com.app.fxplayer.views.tabs.AlbumsView;

public class AlbumsTabController extends Controller {
    private final AlbumsView albumsView;
    public AlbumsTabController(View view) {
        super(view);
        albumsView = (AlbumsView) view;
    }
    @Override
    public void init() {
        ModelRepository.getSongList().itemsProperty().addListener((observableValue, songs, t1) -> {
            if (t1 != null)
            {


        for (Album alb : ModelRepository.getAlbumList().getItems())
        {
            System.out.println("checking album");
            Song song = (Song) t1;
            if (alb.getName().contains(song.getAlbum()))
            {
                alb.getSongs().add((Song) t1);
                System.out.println("adding song to album");
            }
            else
            {
                Album newAlbum = new Album((Song) t1);
                ModelRepository.getAlbumList().getItems().add(newAlbum);
                System.out.println("adding album");
            }
        }
            }
        });
    }
}
