package de.irian.lennox.schiffeversenken;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class SchiffeversenkenFX extends Application {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;
    Rectangle fields = new Rectangle();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Schiffe versenken");
        GridPane mainGrid = new GridPane();

        Label yourField = new Label("Dein Feld");
        mainGrid.add(yourField, 0, 0);

        Label enemyField = new Label("Gegner Feld");
        mainGrid.add(enemyField, 60,0);

        Label ships = new Label(("Schiffe"));
        mainGrid.add(ships, 35, 0);

        Button neuesSpiel = new Button("Neues Spiel");
        neuesSpiel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                try {
                    start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Button beenden = new Button("Beenden");
        GridPane.setHalignment(beenden, HPos.RIGHT);
        beenden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        mainGrid.add(neuesSpiel, 0, 10);
        mainGrid.add(beenden, 0, 10);

        SchiffeversenkenSpielFeld mySchiffeversenkenSpielFeld = new SchiffeversenkenSpielFeld(Color.BLUE);
        mainGrid.add(mySchiffeversenkenSpielFeld,0,1);

        Schiff schiff = new Schiff();
        mainGrid.add(schiff, 40, 1);



        mainGrid.setHgap(1.5);

        SchiffeversenkenSpielFeld enemySchiffeversenkenSpielFeld = new SchiffeversenkenSpielFeld(Color.GOLD);
        mainGrid.add(enemySchiffeversenkenSpielFeld, 60, 1);

        stage.setScene(new Scene (mainGrid));
        stage.setResizable(true);
        stage.show();
    }
}