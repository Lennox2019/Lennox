package de.irian.lennox.Mastermind;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SpielfeldGrid extends GridPane {
    private static final int amountFields = 4;

    private static final Color[] farben = new Color[]{Color.RED, Color.GREEN, Color.PURPLE, Color.BLUE};

    private boolean auswahl;

    public SpielfeldGrid() {
        init();
    }

    public SpielfeldGrid(boolean auswahl) {
        this.auswahl = auswahl;
        init();
    }

    private void init(){

        // Setze 4 Farbfelder in einer Reihe
        for (int i = 0, n = amountFields; i < n; i++) {
            Farbfeld farbfeld;
            if (!auswahl) {
                farbfeld = new Farbfeld(0, 0, 20, Color.YELLOW);
            } else{
                farbfeld = new Farbfeld(0, 0, 20, farben[i]);
            }
            GridPane.setConstraints(farbfeld, i, 0);
            getChildren().add(farbfeld);
        }
        if (!auswahl) {
            Resultat resultat = new Resultat();
            GridPane.setConstraints(resultat, 4, 0);
            getChildren().add(resultat);
        }
        // abstand zwishen den kreisen
        setHgap(10);
        //abstand zu den Rändern
        setPadding(new Insets(5, 15, 0, 15));
    }

}
