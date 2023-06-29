package com.app.fxplayer.views;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

public class LoaderView extends View{
    // labels
    private Label loaderTitleLabel,loaderMessageLabel;
    // progress indicator
    private ProgressIndicator progressIndicator;
    @Override
    public void init() {
        //
        loaderTitleLabel = new Label("loader title");
        loaderMessageLabel = new Label("loader Message");
        //
        progressIndicator = new ProgressIndicator();
        //

    }

    @Override
    public void build() {

    }

    @Override
    public void align() {

    }

    @Override
    public void bind() {

    }

    @Override
    public void styling() {

    }

    public ProgressIndicator getProgressIndicator() {
        return progressIndicator;
    }

    public Label getLoaderMessageLabel() {
        return loaderMessageLabel;
    }

    public Label getLoaderTitleLabel() {
        return loaderTitleLabel;
    }
}
