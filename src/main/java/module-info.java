module com.app.fxplayer {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.base;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires se.michaelthelin.spotify;
    requires java.desktop;
    requires jave.core;
    requires org.apache.commons.io;
    requires lombok;
    requires org.apache.httpcomponents.core5.httpcore5;
    exports com.app.fxplayer.application;
    exports com.app.fxplayer.application.config;
}