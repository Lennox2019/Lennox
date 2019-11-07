package de.irian.lennox.Mastermind;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.text.MutableAttributeSet;


public class MastermindFX extends Application {

    private static final int amountFields = 12;

    private static Farbfeld dragDropHolder;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Mastermind");
        GridPane myGrid = new GridPane();
        myGrid.setVgap(0);

        Mastermind.generateSecretColors();

        Mastermind.myGrid = myGrid;
        Mastermind.stage = stage;
        // spielfelder


        SpielfeldGrid spielfeld = new SpielfeldGrid();

        GridPane.setConstraints(spielfeld, 0, Mastermind.rowCount.get());
        myGrid.getChildren().add(spielfeld);


        int row = amountFields;

        // Separator
        Separator sep = new Separator();
        myGrid.add(sep, 0, row++, 2, 1);

        // auswahlfelder
        for (int i = 0, n = 1; i < n; i++) {
            SpielfeldGrid auswahl = new SpielfeldGrid(true);

            GridPane.setConstraints(auswahl, 0, row++);
            myGrid.getChildren().add(auswahl);
        }

        // Separator
        sep = new Separator();
        myGrid.add(sep, 0, row++);

        // menü
        Button neuesSpiel = new Button("Neues Spiel");
        neuesSpiel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(" starte neues spiel");
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
        // button neues spiel
        // button beenden

        // an die button einen action listener
        myGrid.add(neuesSpiel, 0, row);
        myGrid.add(beenden, 0, row);
        stage.setScene(new Scene(myGrid));
        stage.setResizable(false);
        stage.show();
    }

    public static Farbfeld getDragDropHolder() {
        return dragDropHolder;
    }

    public static void setDragDropHolder(Farbfeld dragDropHolder) {
        MastermindFX.dragDropHolder = dragDropHolder;
    }
}
