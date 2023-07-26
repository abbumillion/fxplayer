package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SettingsView extends View {
    private Label titleLabel , themeLabel , fullScreenLabel , windowStyleLabel,tabSideStyleLabel,fontLabel;
    private HBox hbox1,hbox2,hbox3,hbox4,hbox5,hbox6;
    private VBox rootVBox;
    private ScrollPane scrollPane;
    private ComboBox<String> tabSideSyleComboBox,windowsStyleComboBox;


    @Override
    public void init() {
        titleLabel = new Label("System Settings");
        themeLabel = new Label("Themes");
        fullScreenLabel = new Label("Full Screen");
        windowStyleLabel = new Label("Window Style");
        fontLabel = new Label("font Style");
        tabSideStyleLabel = new Label("tab Style");
        tabSideSyleComboBox = new ComboBox<>();
        String[] sides = {String.valueOf(Side.TOP), String.valueOf(Side.LEFT), String.valueOf(Side.RIGHT), String.valueOf(Side.BOTTOM)};
        String[] windowStyles = {String.valueOf(Side.TOP), String.valueOf(Side.LEFT), String.valueOf(Side.RIGHT), String.valueOf(Side.BOTTOM)};
        tabSideSyleComboBox.getItems().addAll(sides);
        scrollPane = new ScrollPane();
        hbox1 = new HBox();
        hbox2 = new HBox();
        hbox3 = new HBox();
        hbox4 = new HBox();
        hbox5 = new HBox();
        hbox6 = new HBox();
        rootVBox = new VBox();
    }

    @Override
    public void build() {
        // title label on hbox1
        hbox1.getChildren().addAll(titleLabel);
        // theme label on hbox2
        hbox2.getChildren().addAll(themeLabel);
        // full screen
        hbox3.getChildren().addAll(fullScreenLabel);
        // window style
        hbox4.getChildren().addAll(windowStyleLabel);
        // tab style
        hbox5.getChildren().addAll(tabSideStyleLabel , tabSideSyleComboBox);
        // font label
        hbox6.getChildren().addAll(fontLabel);
        // container box for all hboxs
        rootVBox.getChildren().addAll(hbox1,hbox2,hbox3,hbox4,hbox5,hbox6);
        // scroll pane for scrolling effects
        scrollPane.setContent(rootVBox);
        // root which is this class
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        // have to on the center
        titleLabel.prefWidthProperty().bind(hbox1.widthProperty());
        titleLabel.prefHeightProperty().bind(hbox1.heightProperty());
        // left side of the hbox2
        themeLabel.prefWidthProperty().bind(hbox2.widthProperty());
        themeLabel.prefHeightProperty().bind(hbox2.heightProperty());
        // left side of hbox3
        fullScreenLabel.prefWidthProperty().bind(hbox3.widthProperty());
        fullScreenLabel.prefHeightProperty().bind(hbox3.heightProperty());
        // left side of hbox4
        windowStyleLabel.prefWidthProperty().bind(hbox4.widthProperty());
        windowStyleLabel.prefHeightProperty().bind(hbox4.heightProperty());
        // window style label on the left side
        tabSideStyleLabel.prefWidthProperty().bind(hbox5.widthProperty().multiply(.24));
        tabSideStyleLabel.prefHeightProperty().bind(hbox5.heightProperty());
        //
        tabSideSyleComboBox.prefWidthProperty().bind(hbox5.widthProperty().multiply(.25));
        tabSideSyleComboBox.prefHeightProperty().bind(hbox5.heightProperty().multiply(.23));
        //
        fontLabel.prefWidthProperty().bind(hbox6.widthProperty());
        fontLabel.prefHeightProperty().bind(hbox6.heightProperty());
        //
        hbox1.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox1.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        hbox2.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox2.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        hbox3.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox3.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        hbox4.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox4.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        hbox5.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox5.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        hbox6.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox6.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
        //
    }
    @Override
    public void styling() {
        //
        titleLabel.setFont(Font.font(14));
        titleLabel.setAlignment(Pos.CENTER);
        //
        themeLabel.setAlignment(Pos.CENTER_LEFT);
        fullScreenLabel.setAlignment(Pos.CENTER_LEFT);
        windowStyleLabel.setAlignment(Pos.CENTER_LEFT);
        tabSideStyleLabel.setAlignment(Pos.CENTER_LEFT);
        fontLabel.setAlignment(Pos.CENTER_LEFT);
        //
    }

    public ComboBox<String> getTabSideSyleComboBox() {
        return tabSideSyleComboBox;
    }
}
