package com.app.fxplayer.spotify;

import com.app.fxplayer.auth.SpotifyAuthorizer;
import se.michaelthelin.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;

public class SpotifyRequester {
    public void spotifyApiTest()
    {
        GetListOfCurrentUsersPlaylistsRequest.Builder listOfCurrentUsersPlaylists = SpotifyAuthorizer.getSpotifyApi().getListOfCurrentUsersPlaylists();
        System.out.println(listOfCurrentUsersPlaylists);
    }
}
