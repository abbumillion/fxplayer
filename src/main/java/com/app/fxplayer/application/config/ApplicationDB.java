package com.app.fxplayer.application.config;

import com.app.fxplayer.modelgenerator.Generator;
import com.app.fxplayer.models.Song;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public final class ApplicationDB {
    static File songFile = new File("songs.txt");
    static File startUpFile = new File("startup.txt");



    public static void saveStartUpFileToDataBase() throws IOException {
        PrintWriter printWriter = new PrintWriter(startUpFile);
        if (StartUpData.firstTime) {
            StartUpData.firstTime = false;
            printWriter.println(false);
        }
        else {
            System.out.println("do nothing for now");
        }
        printWriter.close();
    }


    public static boolean isFirstTime() throws FileNotFoundException {
        // check if the start-up file exists
        if (startUpFile.exists()) {
            Scanner scanner = new Scanner(startUpFile);
            while (scanner.hasNext()) {
                if (scanner.nextBoolean()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        else {
            // if the start-up file doesn't exist
            return true;
        }
        return StartUpData.firstTime;
    }



    public static void saveSongListToDataBase(List<Song> songList) throws IOException {
        PrintWriter printWriter = new PrintWriter(songFile);
        if (!songList.isEmpty())
        {
            for (int i = 0; i < songList.size() ; i++)
                printWriter.println(songList.get(i).getSource());
        }
        printWriter.close();
    }
    public static List<Song> getSongListFromDatabase() throws IOException {
        List<Song> songList = FXCollections.observableArrayList();
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {

                Scanner scanner = new Scanner(songFile);
                while (scanner.hasNextLine())
                {
                    Song song = Generator.generateSong(scanner.nextLine());
                    songList.add(song);
                }
                scanner.close();
                return null;
            }
        };
        Platform.runLater(task);
        return songList;
    }

    public static File getSongFile() {
        return songFile;
    }

    public static File getStartUpFile() {
        return startUpFile;
    }
}
