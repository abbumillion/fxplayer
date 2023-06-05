package com.app.fxplayer.application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;


public final class Settings {
    /**
     * APPLICATION THEME
     */
    private  StringProperty theme = new SimpleStringProperty("src/main/resources/stylesheets/dark.css");
    /**
     * APPLICATION FULL SCREEN
     * default false full screen property
     */
    private  BooleanProperty fullScreenProperty = new SimpleBooleanProperty(false);
    /**
     * STAGE STYLE
     * default stage style undecorated
     */
    private  StageStyle stageStyle = StageStyle.UNDECORATED;
    /**
     * application font
     * default 12.0
     */
    private  Font font = Font.font(12.0);

    // constructor
    public Settings() {
        // construct this class
    }

    /**
     * set stage style
     * @param stageStyle
     */
    public void setStageStyle(StageStyle stageStyle) {
        this.stageStyle = stageStyle;
    }

    /**
     *
     * @return stage style
     */
    public  StageStyle getStageStyle() {
        return stageStyle;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    /**
     *
     * @return font
     */
    public  Font getFont() {
        return font;
    }

    /**
     *
     * @return theme
     */
    public  String getTheme() {
        return theme.get();
    }

    /**
     * set the theme
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme.set(theme);
    }
}
