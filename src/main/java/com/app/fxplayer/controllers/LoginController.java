package com.app.fxplayer.controllers;

import com.app.fxplayer.views.LoginView;
import com.app.fxplayer.views.PlayerView;
import com.app.fxplayer.views.View;

import java.io.IOException;
public class LoginController extends Controller{
    LoginView loginView;
    public LoginController(View view) {
        super(view);
        loginView = (LoginView) view;
    }
    @Override
    public void init() throws InterruptedException, IOException {
        loginView.getLoginButton().setOnAction(actionEvent ->
        {
            System.out.println("Signing in please wait .....");
          //  SpotifyAuthorizer.authorizationCode_Async();
            try {
                loginView.hideView();
                new PlayerViewController(new PlayerView()).init();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        loginView.showView();
    }
}
