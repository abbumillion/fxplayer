package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SettingsView extends View {
    private Label titleLabel , themeLabel , fullScreenLabel , windowStyleLabel,tabSideStyleLabel,fontLabel;
    private HBox hbox1,hbox2,hbox3,hbox4,hbox5,hbox6;
    private VBox rootVBox;
    private ScrollPane scrollPane;
    private ComboBox<String> tabSideSyleComboBox;


    @Override
    public void init() {
        titleLabel = new Label("System Settings");
        themeLabel = new Label("Themes");
        fullScreenLabel = new Label("Full Screen");
        windowStyleLabel = new Label("Window Style");
        fontLabel = new Label("font Style");
        tabSideStyleLabel = new Label("tab Style");
        //
        tabSideSyleComboBox = new ComboBox<>();
        String[] sides = {String.valueOf(Side.TOP), String.valueOf(Side.LEFT), String.valueOf(Side.RIGHT), String.valueOf(Side.BOTTOM)};
        tabSideSyleComboBox.getItems().addAll(sides);
        //
        scrollPane = new ScrollPane();
        //
        hbox1 = new HBox();
        hbox2 = new HBox();
        hbox3 = new HBox();
        hbox4 = new HBox();
        hbox5 = new HBox();
        hbox6 = new HBox();
        //
        rootVBox = new VBox();
        //
        //
    }

    @Override
    public void build() {
        hbox1.getChildren().addAll(titleLabel);
        hbox2.getChildren().addAll(themeLabel);
        hbox3.getChildren().addAll(fullScreenLabel);
        hbox4.getChildren().addAll(windowStyleLabel);
        hbox5.getChildren().addAll(tabSideStyleLabel , tabSideSyleComboBox);
        hbox6.getChildren().addAll(fontLabel);
        rootVBox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
        scrollPane.setContent(rootVBox);
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        //
        titleLabel.prefWidthProperty().bind(hbox1.widthProperty());
        titleLabel.prefHeightProperty().bind(hbox1.heightProperty());
        //
        themeLabel.prefWidthProperty().bind(hbox2.widthProperty());
        themeLabel.prefHeightProperty().bind(hbox2.heightProperty());
        //
        fullScreenLabel.prefWidthProperty().bind(hbox3.widthProperty());
        fullScreenLabel.prefHeightProperty().bind(hbox3.heightProperty());
        //
        windowStyleLabel.prefWidthProperty().bind(hbox4.widthProperty());
        windowStyleLabel.prefHeightProperty().bind(hbox4.heightProperty());
        //
        tabSideStyleLabel.prefWidthProperty().bind(hbox5.widthProperty().multiply(.4));
        tabSideStyleLabel.prefHeightProperty().bind(hbox5.heightProperty());
        tabSideSyleComboBox.prefWidthProperty().bind(hbox5.widthProperty().multiply(.4));
        tabSideSyleComboBox.prefHeightProperty().bind(hbox5.heightProperty().multiply(.3));
        //
        fontLabel.prefWidthProperty().bind(hbox6.widthProperty());
        fontLabel.prefHeightProperty().bind(hbox6.heightProperty());
        //
        hbox1.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox1.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        hbox2.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox2.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        hbox3.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox3.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        hbox4.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox4.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        hbox5.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox5.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        hbox6.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox6.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.2));
        //
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
        //

    }
    @Override
    public void styling() {
    }

    public ComboBox<String> getTabSideSyleComboBox() {
        return tabSideSyleComboBox;
    }
}
