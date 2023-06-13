package com.app.fxplayer.models.collectors;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.concurrent.Worker;

import java.io.File;

/**
 * extractors division
 */
public class Extractor implements Worker {
    // extraction location
    private File extractionLocation;
    public Extractor(File extractionLocation)
    {
        this.extractionLocation = extractionLocation;
    }
    @Override
    public State getState() {
        return null;
    }

    @Override
    public ReadOnlyObjectProperty<State> stateProperty() {
        return null;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public ReadOnlyObjectProperty valueProperty() {
        return null;
    }

    @Override
    public Throwable getException() {
        return null;
    }

    @Override
    public ReadOnlyObjectProperty<Throwable> exceptionProperty() {
        return null;
    }

    @Override
    public double getWorkDone() {
        return 0;
    }

    @Override
    public ReadOnlyDoubleProperty workDoneProperty() {
        return null;
    }

    @Override
    public double getTotalWork() {
        return 0;
    }

    @Override
    public ReadOnlyDoubleProperty totalWorkProperty() {
        return null;
    }

    @Override
    public double getProgress() {
        return 0;
    }

    @Override
    public ReadOnlyDoubleProperty progressProperty() {
        return null;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public ReadOnlyBooleanProperty runningProperty() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public ReadOnlyStringProperty messageProperty() {
        return null;
    }

    @Override
    public String getTitle() {
        return "Extractors division";
    }

    @Override
    public ReadOnlyStringProperty titleProperty() {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }
}
