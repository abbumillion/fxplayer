package com.app.fxplayer.application;

/**
 * APPLICATION BEHAVIOR
 */
public interface App {
    /**
     * initialization application resources
     */
    void init();

    /**
     * starting application
     */
    void start();

    /**
     * restarting application
     * starting the application again
     */
    void reStart();

    /**
     * stopping the application
     */
    void stop();

}
