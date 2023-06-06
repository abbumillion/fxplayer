package com.app.fxplayer.helpers;

/**
 * string constant static class
 */
public final class StringConstants {
    //
    private static final String systemTitle = "Fx-Player";
    //
    private static final String systemDescription = "Javafx Audio Player Project";
    //
    private static final String systemTheme = "src/main/resources/stylesheets/dark.css";
    // app icon
    private static final String systemIcon = "src/main/resources/icons/fx-player.png";

    /**
     *
     * @return system description
     */

    public static String getSystemDescription() {
        //
        return systemDescription;
        //
    }

    /**
     *
     * @return system theme
     */
    public static String getSystemTheme() {
        //
        return systemTheme;
        //
    }

    /**
     *
     * @return system title
     */
    public static String getSystemTitle() {
        //
        return systemTitle;
        //
    }

    public static String getSystemIcon() {
        return systemIcon;
    }
}
