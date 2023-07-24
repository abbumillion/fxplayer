package com.app.fxplayer.player.audioplayer;
import com.app.fxplayer.models.Song;
import com.app.fxplayer.repo.ModelRepository;

public final class MediaQueue {
    private static Song prevSong , currentSong , nextSong;

    public static void setCurrentSong(Song song)
    {
        // index holder for the queue
        int indexOfPrevSong,indexOfCurrentSong,indexOfNextSong;
        // current song index
        indexOfCurrentSong =  ModelRepository.getSongList().getItems().indexOf(song);
        // case 1
        // if the current song is on the first index 0
        // then prv = last song on the repo
        // then nxt = index 1 or current + 1
        if (indexOfCurrentSong == 0)
        {
            //
            indexOfPrevSong = ModelRepository.getSongList().getItems().size() - 1;
            indexOfNextSong = indexOfCurrentSong + 1;
        }
        // case 2
        // if the current index is on the last
        // which means it's playing the last song
        else if (indexOfCurrentSong == ModelRepository.getSongList().getItems().size() - 1)
        {
            //
            indexOfPrevSong = ModelRepository.getSongList().getItems().size() - 1;
            indexOfNextSong = 0;
            //
        }
        // case 3
        // if the current is at random position
        // except at 0 and 1
        else
        {
            indexOfPrevSong = indexOfCurrentSong - 1;
            indexOfNextSong = indexOfCurrentSong + 1;
        }
        // prev song
        prevSong = ModelRepository.getSongList().getItems().get(indexOfPrevSong);
        // next song
        nextSong = ModelRepository.getSongList().getItems().get(indexOfNextSong);
        //current song
        currentSong = ModelRepository.getSongList().getItems().get(indexOfCurrentSong);

    }
    public static Song getNextSong() {
        return nextSong;
    }

    public static Song getCurrentSong() {
        // case 1
        // the player initialization
        if (currentSong == null)
        {
            // player initialization phase
            // pass the first song on the repository
            currentSong = ModelRepository.getSongList().getItems().get(0);
        }
        // case 2
        // the player is playing
        if (currentSong != null)
        {
            //
            return currentSong;
        }
        // case 3
        //the player has stopped
        // the player is paused
        return null;
    }

    public static Song getPrevSong() {
        return prevSong;
    }
}
