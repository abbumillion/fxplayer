module com.app.fxplayer {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires jave.core;
    requires org.apache.commons.io;
    requires lombok;
    exports com.app.fxplayer.application;
    exports com.app.fxplayer.application.config;
}