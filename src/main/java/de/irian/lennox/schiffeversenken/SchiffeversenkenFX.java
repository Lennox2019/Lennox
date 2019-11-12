package de.irian.lennox.schiffeversenken;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.awt.*;
public class SchiffeversenkenFX extends Application {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;
    Rectangle fields = new Rectangle();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Schiffe versenken");
        GridPane mainGrid = new GridPane();

        SchiffeversenkenSpielFeld schiffeversenkenSpielFeld = new SchiffeversenkenSpielFeld();
        mainGrid.getChildren().add(schiffeversenkenSpielFeld);

        stage.setScene(new Scene (mainGrid));
        stage.setResizable(false);
        stage.show();
    }
}