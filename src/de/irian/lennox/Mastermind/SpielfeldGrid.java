package de.irian.lennox.Mastermind;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class SpielfeldGrid extends GridPane {
    private static final int amountFields = 4;

    private static final Color[] farben = new Color[]{Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE};//, Color.PURPLE, Color.PINK};

    private boolean auswahl;
    private int maxFields = 0;

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

    private void init(){

        // Setze 4 Farbfelder in einer Reihe
        for (int i = 0, n = amountFields; i < n; i++) {
            Farbfeld farbfeld;
            if (!auswahl) {
                farbfeld = new Farbfeld(0, 0, 20, Color.YELLOW);
                int counter = i;
                farbfeld.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
                    @Override
                    public void handle(MouseDragEvent mouseDragEvent) {
                        Farbfeld source = (Farbfeld) mouseDragEvent.getSource();
                        farbfeld.setFill(MastermindFX.getDragDropHolder().getFill());
                        System.out.println(counter + ":" + farbfeld.getFill());
                        guessedColors[counter] = (Color) farbfeld.getFill();

                        int max = 0;
                        for (int j = 0; j < guessedColors.length; j++) {
                            if (guessedColors[j] != null){
                                max++;

                                if(max == 4) {
                                    Mastermind.setGuessedColors(Arrays.asList(guessedColors));

                                    Color[] result = Mastermind.checkColors();
                                    Resultat resultat = new Resultat();
                                    resultat.setBlackWhite(result);
                                }
                            }
                        }
                        MastermindFX.setDragDropHolder(null);
                    }
                });
            } else {
                farbfeld = new Farbfeld(0, 0, 20, farben[i]);
                farbfeld.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println("hier");
                        farbfeld.startFullDrag();
                        MastermindFX.setDragDropHolder(farbfeld);
                    }
                });
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
