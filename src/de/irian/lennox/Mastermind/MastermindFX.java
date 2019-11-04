package de.irian.lennox.Mastermind;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MastermindFX extends Application {

    private static final int amountFields = 8;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Mastermind");
        GridPane myGrid = new GridPane();
        myGrid.setVgap(0);

        for (int i = 0, n = amountFields; i < n; i++) {
            SpielfeldGrid spielfeld = new SpielfeldGrid();

            GridPane.setConstraints(spielfeld, 0, i);
            myGrid.getChildren().add(spielfeld);
        }
        int row = amountFields;
        for (int i = 0, n = 1; i < n; i++) {
            SpielfeldGrid auswahl = new SpielfeldGrid(true);

            GridPane.setConstraints(auswahl, 0, row++);
            myGrid.getChildren().add(auswahl);
        }
        Pane root = new VBox(0);
        root.getChildren().add(myGrid);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
