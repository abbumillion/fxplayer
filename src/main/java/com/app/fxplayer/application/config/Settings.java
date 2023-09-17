package com.app.fxplayer.application.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Settings implements Serializable {
    private String theme = "src/main/resources/stylesheets/dark.css";
    private String font;
    private String tabSide;
    private String stageStyle;
    private boolean isFirstTime;
    private boolean isFullScreen;
    private int totalSongs = 0;
}
