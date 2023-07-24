package com.app.fxplayer.modelgenerator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;

import java.io.File;

public class Collector  extends Task<File> {
    private final String title = "music collecting background task";
    private static final File[] drives = {new File("C://"),new File("D://")};
    private IntegerProperty fileIndex = new SimpleIntegerProperty(0);

    private  void extract(File file)
    {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files)
            {
                //
                //
                fileIndex.set(fileIndex.get() + 1);
                if (f.isDirectory()) {
                    //
                    //
                    extract(f);
                }
                else if (f.isFile()) {
                    //
                    //
                    String path = f.getPath();
                    if (path.endsWith(".mp3") || path.endsWith(".mp4"))
                    {
                        //
                        try {
                            //
                            updateMessage("Found ->" + path);
//                            updateProgress(fileIndex,);
                            Generator.generateSong(path);
//                            Thread.sleep(200);
                            //
                        }catch (Exception exception)
                        {
                            //
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override
    protected File call() {
        //
        for (File drive: drives) {
            extract(drive);
        }
        //
        return null;
    }

}
