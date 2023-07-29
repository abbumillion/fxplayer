package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class SettingsView extends View {
    private Label titleLabel , themeLabel , fullScreenLabel , stageStyleLabel,tabSideStyleLabel,fontLabel;
    private HBox hbox1,hbox2,hbox3,hbox4,hbox5,hbox6;
    private VBox rootVBox;
    private ScrollPane scrollPane;
    private ComboBox<String> tabSideSyleComboBox,stageStyleComboBox;

    private Separator separator1,separator2,separator3,separator4,separator5,separator6,separator7,separator8,separator9,separator10;

    @Override
    public void init() {
        titleLabel = new Label("System Settings");
        themeLabel = new Label("Themes");
        fullScreenLabel = new Label("Full Screen");
        stageStyleLabel = new Label("Stage Style");
        fontLabel = new Label("font Style");
        tabSideStyleLabel = new Label("tab Style");
        tabSideSyleComboBox = new ComboBox<>();
        stageStyleComboBox = new ComboBox<>();
        String[] sides = {String.valueOf(Side.TOP), String.valueOf(Side.LEFT), String.valueOf(Side.RIGHT), String.valueOf(Side.BOTTOM)};
        String[] windowStyles = { StageStyle.DECORATED.name() , StageStyle.TRANSPARENT.name() , StageStyle.UNDECORATED.name() , StageStyle.UTILITY.name() , StageStyle.UNIFIED.name()};
        tabSideSyleComboBox.getItems().addAll(sides);
        stageStyleComboBox.getItems().addAll(windowStyles);
        scrollPane = new ScrollPane();
        hbox1 = new HBox();
        hbox2 = new HBox();
        hbox3 = new HBox();
        hbox4 = new HBox();
        hbox5 = new HBox();
        hbox6 = new HBox();
        rootVBox = new VBox();
        //
        separator1 = new Separator();
        separator2 = new Separator();
        separator3 = new Separator();
        separator4 = new Separator();
        separator5 = new Separator();
        separator6 = new Separator();
        separator7 = new Separator();
        separator8 = new Separator();
        separator9 = new Separator();
        separator10 = new Separator();
    }

    @Override
    public void build() {
        hbox1.getChildren().addAll( titleLabel );
        hbox2.getChildren().addAll( themeLabel );
        hbox3.getChildren().addAll( fullScreenLabel );
        hbox4.getChildren().addAll( stageStyleLabel , stageStyleComboBox );
        hbox5.getChildren().addAll( tabSideStyleLabel , tabSideSyleComboBox );
        hbox6.getChildren().addAll( fontLabel );
        rootVBox.getChildren().addAll( hbox1 , separator1 , hbox2 , separator2 , hbox3 , separator3 ,hbox4 , separator4 ,hbox5 , separator5 , hbox6 ,  separator6);
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
        stageStyleLabel.prefWidthProperty().bind(hbox4.widthProperty().multiply(.3));
        stageStyleLabel.prefHeightProperty().bind(hbox4.heightProperty());
        //
        tabSideStyleLabel.prefWidthProperty().bind(hbox5.widthProperty().multiply(.3));
        tabSideStyleLabel.prefHeightProperty().bind(hbox5.heightProperty());
        //
        tabSideSyleComboBox.prefWidthProperty().bind(hbox5.widthProperty().multiply(.3));
        tabSideSyleComboBox.prefHeightProperty().bind(hbox5.heightProperty());
        //
        fontLabel.prefWidthProperty().bind(hbox6.widthProperty());
        fontLabel.prefHeightProperty().bind(hbox6.heightProperty());
        //
        hbox1.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox1.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        hbox2.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox2.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        hbox3.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox3.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        hbox4.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox4.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        hbox5.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox5.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        hbox6.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox6.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.1));
        //
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
        //
        separator1.prefWidthProperty().bind(rootVBox.widthProperty());
        separator2.prefWidthProperty().bind(rootVBox.widthProperty());
        separator3.prefWidthProperty().bind(rootVBox.widthProperty());
        separator4.prefWidthProperty().bind(rootVBox.widthProperty());
        separator5.prefWidthProperty().bind(rootVBox.widthProperty());
        separator6.prefWidthProperty().bind(rootVBox.widthProperty());
        separator7.prefWidthProperty().bind(rootVBox.widthProperty());
        separator8.prefWidthProperty().bind(rootVBox.widthProperty());
        separator9.prefWidthProperty().bind(rootVBox.widthProperty());
        separator10.prefWidthProperty().bind(rootVBox.widthProperty());
        //
    }
    @Override
    public void styling() {
        setSpacing(15.5);
        setPadding(new Insets(2.5,2.4,3,2.4));
        titleLabel.setFont(Font.font(24));
        titleLabel.setAlignment(Pos.CENTER);
        themeLabel.setAlignment(Pos.CENTER_LEFT);
        fullScreenLabel.setAlignment(Pos.CENTER_LEFT);
        stageStyleLabel.setAlignment(Pos.CENTER_LEFT);
        tabSideStyleLabel.setAlignment(Pos.CENTER_LEFT);
        fontLabel.setAlignment(Pos.CENTER_LEFT);
    }

    public ComboBox<String> getTabSideSyleComboBox() {
        return tabSideSyleComboBox;
    }

    public ComboBox<String> getStageStyleComboBox() {
        return stageStyleComboBox;
    }
}
