package com.app.fxplayer.models.collectors;

// we will use this guy
// to do some background tasks
// on behalf of me or us
public final class FileExtractionManager {
    // file extraction manager instance
    private static FileExtractionManager fileExtractionManager = null;

    private FileExtractionManager(){
        // nobody but this can only create
        // its own instance I wonder
    }

    public static synchronized FileExtractionManager getFileExtractionManager(){
        // check if it's alive
        if (fileExtractionManager == null)
        {
            fileExtractionManager = new FileExtractionManager();
        }
        // if not
        return fileExtractionManager;
    }

    // extraction entry requirements
    // all extraction locations
    // verify locations for
    // extraction
    // initiate extraction
    public void initExtraction()
    {
        System.out.println("extraction initiated");
        System.out.println("extraction details");
        System.out.println("extraction requirements");
        System.out.println("extraction extractors");

    }
}
