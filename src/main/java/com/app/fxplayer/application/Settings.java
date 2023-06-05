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
    private StringProperty theme;
    /**
     * APPLICATION FULL SCREEN
     */
    private BooleanProperty fullScreen;
    /**
     * STAGE STYLE
     */
    private StageStyle stageStyle;
    /**
     * application font
     */
    private Font font;

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
    /**
     *
     * @return stage style
     */

    public StageStyle getStageStyle() {
        return stageStyle;
    }

    /**
     *
     * @return theme property
     */
    public StringProperty themeProperty() {
        return theme;
    }

    /**
     *
     * @return application font
     */

    public Font getFont() {
        return font;
    }
}
