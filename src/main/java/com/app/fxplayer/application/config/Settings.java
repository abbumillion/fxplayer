package com.app.fxplayer.application.config;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public final class Settings {
    private  StringProperty theme = new SimpleStringProperty("src/main/resources/stylesheets/dark.css");
    private  BooleanProperty fullScreenProperty = new SimpleBooleanProperty(false);
    private  StageStyle stageStyle = StageStyle.UNDECORATED;
    private  Font font = Font.font(12.0);
    public Settings() {}

    public void setStageStyle(StageStyle stageStyle) {
        this.stageStyle = stageStyle;
    }

    public  StageStyle getStageStyle() {
        return stageStyle;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public  Font getFont() {
        return font;
    }

    public  String getTheme() {
        return theme.get();
    }

    public void setTheme(String theme) {
        this.theme.set(theme);
    }
}
