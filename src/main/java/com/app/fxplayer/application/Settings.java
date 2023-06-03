package com.app.fxplayer.application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

/**
 * APPLICATION SETTINGS STORING DATA CLASS
 * LIKE THEMES,FULL SCREEN,FONTS,STAGE STYLE
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

    public Font getFont() {
        return font;
    }
}
