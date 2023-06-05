package com.app.fxplayer.application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

/**
 * APPLICATION SETTINGS STORING DATA CLASS
 * LIKE THEMES,FULL SCREEN,FONTS,STAGE STYLE
 * this class needs to singleton since only one
 * instance of this class is needed across the application,
 * so we are going to use singleton pattern
 */
public final class Settings {
    /**
     * APPLICATION THEME
     */
    private static StringProperty theme;
    /**
     * APPLICATION FULL SCREEN
     */
    private static BooleanProperty fullScreen;
    /**
     * STAGE STYLE
     */
    private static StageStyle stageStyle;
    /**
     * application font
     */
    private static Font font;

    // this classes instance
    private static Settings settings;
    // constructor
    private Settings() {}

    /**
     *
     * @return application Settings
     */
    public static synchronized Settings getSettings()
    {
        if (settings == null){
            settings = new Settings();
        }
        return settings;
    }


    public static StringProperty themeProperty() {
        return theme;
    }

    public static StageStyle getStageStyle() {
        return stageStyle;
    }

    public static Font getFont() {
        return font;
    }

    public static String getTheme() {
        return theme.get();
    }
}
