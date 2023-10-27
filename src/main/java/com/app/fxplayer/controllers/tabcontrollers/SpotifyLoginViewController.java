//package com.app.fxplayer.controllers.tabcontrollers;
//import com.app.fxplayer.auth.SpotifyAuthorizer;
//import com.app.fxplayer.controllers.Controller;
//import com.app.fxplayer.views.SpotifyLoginView;
//import com.app.fxplayer.views.View;
//import java.io.IOException;
//public class SpotifyLoginViewController extends Controller {
//    SpotifyLoginView spotifyLoginView;
//    public SpotifyLoginViewController(View view) {
//        super(view);
//        spotifyLoginView = (SpotifyLoginView) view;
//    }
//    @Override
//    public void init() throws InterruptedException, IOException {
//        System.out.println("initializing web engine please wait .....");
//        SpotifyAuthorizer.authorizationCode_Async();
//        spotifyLoginView.getWebView().getEngine().setJavaScriptEnabled(true);
//        spotifyLoginView.getWebView().getEngine().load("https://open.spotify.com/collection/tracks");
//        spotifyLoginView.showView();
//    }
//}
