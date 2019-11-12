package de.irian.lennox.schiffeversenken;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.Rectangle;

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


        SchiffeversenkenSpielFeld mySchiffeversenkenSpielFeld = new SchiffeversenkenSpielFeld(Color.BLUE);
        mainGrid.add(mySchiffeversenkenSpielFeld,0,1);

        mainGrid.setHgap(1.5);

        SchiffeversenkenSpielFeld enemySchiffeversenkenSpielFeld = new SchiffeversenkenSpielFeld(Color.GOLD);
        mainGrid.add(enemySchiffeversenkenSpielFeld, 60, 1);

        stage.setScene(new Scene (mainGrid));
        stage.setResizable(true);
        stage.show();
    }
}