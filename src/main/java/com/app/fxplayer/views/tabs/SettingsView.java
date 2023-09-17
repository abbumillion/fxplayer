package com.app.fxplayer.views.tabs;

import com.app.fxplayer.views.View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SettingsView extends View {
    private Label titleLabel, themeLabel, fullScreenLabel, stageStyleLabel, tabSideStyleLabel, fontLabel,
            languageLabel, accountNameLabel, emailLabel;
    private HBox hbox1, hbox2, hbox3, hbox4, hbox5, hbox6;
    private VBox rootVBox;
    private ScrollPane scrollPane;
    private ComboBox<String> tabSideSyleComboBox, stageStyleComboBox, languageLabelComboBox;

    @Override
    public void init() {
        titleLabel = new Label("System Settings");
        themeLabel = new Label("Themes");
        fullScreenLabel = new Label("Full Screen");
        stageStyleLabel = new Label("Stage Style");
        fontLabel = new Label("font Style");
        tabSideStyleLabel = new Label("tab Style");
        languageLabel = new Label("Languages");
        accountNameLabel = new Label("Account Name");
        emailLabel = new Label("Email");
        languageLabelComboBox = new ComboBox<>();
        tabSideSyleComboBox = new ComboBox<>();
        stageStyleComboBox = new ComboBox<>();
        String[] languages = {"English", "Amharic", "Arabic", "Oromo"};
        String[] sides = {String.valueOf(Side.TOP), String.valueOf(Side.LEFT), String.valueOf(Side.RIGHT), String.valueOf(Side.BOTTOM)};
        String[] windowStyles = {StageStyle.DECORATED.name(), StageStyle.TRANSPARENT.name(), StageStyle.UNDECORATED.name(), StageStyle.UTILITY.name(), StageStyle.UNIFIED.name()};
        tabSideSyleComboBox.getItems().addAll(sides);
        stageStyleComboBox.getItems().addAll(windowStyles);
        languageLabelComboBox.getItems().addAll(languages);
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
        hbox1.getChildren().addAll(titleLabel);
        hbox2.getChildren().addAll(themeLabel);
        hbox3.getChildren().addAll(fullScreenLabel);
        hbox4.getChildren().addAll(stageStyleLabel, stageStyleComboBox);
        hbox5.getChildren().addAll(tabSideStyleLabel, tabSideSyleComboBox);
        hbox6.getChildren().addAll(fontLabel);
        rootVBox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6);
        scrollPane.setContent(rootVBox);
        getChildren().addAll(scrollPane);
    }

    @Override
    public void align() {
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setAlignment(Pos.CENTER);
        hbox5.setAlignment(Pos.CENTER);
        hbox6.setAlignment(Pos.CENTER);
        rootVBox.setAlignment(Pos.CENTER);
        setAlignment(Pos.CENTER);
    }

    @Override
    public void bind() {
        titleLabel.prefWidthProperty().bind(hbox1.widthProperty());
        titleLabel.prefHeightProperty().bind(hbox1.heightProperty());
        themeLabel.prefWidthProperty().bind(hbox2.widthProperty());
        themeLabel.prefHeightProperty().bind(hbox2.heightProperty());
        fullScreenLabel.prefWidthProperty().bind(hbox3.widthProperty());
        fullScreenLabel.prefHeightProperty().bind(hbox3.heightProperty());
        stageStyleLabel.prefWidthProperty().bind(hbox4.widthProperty().multiply(.3));
        stageStyleLabel.prefHeightProperty().bind(hbox4.heightProperty());
        tabSideStyleLabel.prefWidthProperty().bind(hbox5.widthProperty().multiply(.3));
        tabSideStyleLabel.prefHeightProperty().bind(hbox5.heightProperty());
        tabSideSyleComboBox.prefWidthProperty().bind(hbox5.widthProperty().multiply(.3));
        tabSideSyleComboBox.prefHeightProperty().bind(hbox5.heightProperty().multiply(.5));
        fontLabel.prefWidthProperty().bind(hbox6.widthProperty());
        fontLabel.prefHeightProperty().bind(hbox6.heightProperty());
        hbox1.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox1.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        hbox2.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox2.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        hbox3.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox3.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        hbox4.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox4.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        hbox5.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox5.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        hbox6.prefWidthProperty().bind(rootVBox.widthProperty());
        hbox6.prefHeightProperty().bind(rootVBox.heightProperty().multiply(.0451));
        rootVBox.prefWidthProperty().bind(widthProperty());
        rootVBox.prefHeightProperty().bind(heightProperty());
    }

    @Override
    public void styling() {
        setSpacing(15.5);
        setPadding(new Insets(2.5, 2.4, 3, 2.4));
        titleLabel.setFont(Font.font(24));
        titleLabel.setAlignment(Pos.CENTER);
        themeLabel.setAlignment(Pos.CENTER_LEFT);
        fullScreenLabel.setAlignment(Pos.CENTER_LEFT);
        stageStyleLabel.setAlignment(Pos.CENTER_LEFT);
        tabSideStyleLabel.setAlignment(Pos.CENTER_LEFT);
        fontLabel.setAlignment(Pos.CENTER_LEFT);

    }
}
