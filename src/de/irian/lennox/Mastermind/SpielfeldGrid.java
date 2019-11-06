package de.irian.lennox.Mastermind;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpielfeldGrid extends GridPane {
    private static final int amountFields = 4;

    private static final Color[] farben = new Color[]{Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE , Color.PURPLE, Color.PINK};

    private boolean auswahl;
    private Resultat resultat = new Resultat();
    private List<Farbfeld> farbfelder = new ArrayList<>();

    Color[] guessedColors = new Color[4];

    public SpielfeldGrid() {
        init();
    }

    public SpielfeldGrid(boolean auswahl) {
        this.auswahl = auswahl;
        init();
    }

    public static Color[] getFarben() {
        return farben;
    }

    private void init() {

        // Setze 4 Farbfelder in einer Reihe


        if (!auswahl) {
            for (int i = 0, n = amountFields; i < n; i++) {
                Farbfeld farbfeld = new Farbfeld(0, 0, 20, Color.YELLOW);
                int counter = i;
                farbfeld.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
                    @Override
                    public void handle(MouseDragEvent mouseDragEvent) {
                        farbfeld.setFill(MastermindFX.getDragDropHolder().getFill());
                        guessedColors[counter] = (Color) farbfeld.getFill();
                        farbfelder.add(farbfeld);

                        int max = 0;
                        for (int j = 0; j < guessedColors.length; j++) {
                            if (guessedColors[j] != null) {
                                max++;

                                if (max == 4) {
                                    for (int l = 0; l < farbfelder.size(); l++) {
                                        farbfelder.get(l).setDisable(true);
                                    }
                                    Mastermind.setGuessedColors(Arrays.asList(guessedColors));

                                    Color[] result = Mastermind.checkColors();
                                    if (resultat != null) {
                                        resultat.setBlackWhite(result);
                                    }
                                }
                            }
                        }
                        MastermindFX.setDragDropHolder(null);
                    }
                });
                GridPane.setConstraints(farbfeld, i, 0);
                getChildren().add(farbfeld);
            }
        } else {
            for (int i = 0, n = farben.length; i < n; i++) {
                Farbfeld farbfeld = new Farbfeld(0, 0, 20, farben[i]);
                farbfeld.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        farbfeld.startFullDrag();
                        MastermindFX.setDragDropHolder(farbfeld);
                    }
                });
                GridPane.setConstraints(farbfeld, i, 0);
                getChildren().add(farbfeld);
            }
        }


        if (!auswahl) {
            resultat = new Resultat();
            GridPane.setConstraints(resultat, 4, 0);
            getChildren().add(resultat);
        }
        // abstand zwishen den kreisen
        setHgap(10);
        //abstand zu den Rändern
        setPadding(new Insets(5, 15, 0, 15));
    }

}
