package com.app.fxplayer.application;

public class JfxApplication implements App{
    private ApplicationData applicationData;
    private ApplicationStates applicationStates;
    private Settings settings;
    @Override
    public void init() {
        applicationData = new ApplicationData();
        settings = new Settings();
    }

    @Override
    public void start() {

    }

    @Override
    public void reStart() {

    }

    @Override
    public void stop() {

    }

    public ApplicationData getApplicationData() {
        return applicationData;
    }

    public ApplicationStates getApplicationStates() {
        return applicationStates;
    }

    public Settings getSettings() {
        return settings;
    }
}
