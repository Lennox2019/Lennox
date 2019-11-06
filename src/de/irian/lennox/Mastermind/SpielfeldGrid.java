package de.irian.lennox.Mastermind;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Separator;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpielfeldGrid extends GridPane {
    private static final int amountFields = 4;

    private static final Color[] farben = new Color[]{Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE, Color.PURPLE, Color.LIGHTPINK};
    private static final Color[] gradientFarben = new Color[]{Color.BLACK, Color.WHITE, Color.DARKORANGE, Color.DARKBLUE, Color.MEDIUMPURPLE, Color.PINK};

    private boolean auswahl;
    private Resultat resultat = new Resultat();
    private List<Farbfeld> farbfelder = new ArrayList<>();

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;


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

        setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));


        if (!auswahl) {
            for (int i = 0, n = amountFields; i < n; i++) {

                RadialGradient gradient1 = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
                        new Stop(0, Color.DARKOLIVEGREEN),
                        new Stop(1, Color.BLACK)
                });
                Farbfeld farbfeld = new Farbfeld(0, 0, 20, Color.DARKOLIVEGREEN);

                farbfeld.setFill(gradient1);
                farbfeld.setStroke(Color.BLACK);

                //    Shadow shadow = new Shadow(20, Color.BLACK);
                //  farbfeld.setEffect(shadow);

                int counter = i;
                farbfeld.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
                    @Override
                    public void handle(MouseDragEvent mouseDragEvent) {
                        farbfeld.setFill(MastermindFX.getDragDropHolder().getFill());

                        Mastermind.stage.getScene().setCursor(Cursor.DEFAULT);
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
                RadialGradient gradient = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
                        new Stop(0, farben[i]),
                        new Stop(1, gradientFarben[i])
                });
                Farbfeld farbfeld = new Farbfeld(0, 0, 20, farben[i]);
                //farbfeld.setFill(gradient);
                farbfeld.setStroke(Color.BLACK);
                farbfeld.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        farbfeld.startFullDrag();
                        //         Mastermind.stage.getScene().setCursor(getCursor(farbfeld));
                        //         MastermindFX.setDragDropHolder(farbfeld);
                    }
                });
                //farbfeld.setOnMousePressed(circleOnMousePressedEventHandler);
                //farbfeld.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                GridPane.setConstraints(farbfeld, i, 0);
                getChildren().add(farbfeld);
            }

            // zeige generierte farben an. auskommentieren wenn richtig gespielt wird
//            int i = 0;
//            for (Color color : Mastermind.secretColors) {
//                Farbfeld farbfeld = new Farbfeld(0, 0, 20, color);
//                GridPane.setConstraints(farbfeld, i++, 1);
//                getChildren().add(farbfeld);
//            }
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

    private ImageCursor getCursor(Farbfeld farbfeld) {
        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);
        Image image = farbfeld.snapshot(sp, null);
        return new ImageCursor(image, 16, 16);
    }
}

//    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
//            new EventHandler<MouseEvent>() {

//                @Override
//                public void handle(MouseEvent t) {
//                    orgSceneX = t.getSceneX();
//                    orgSceneY = t.getSceneY();
//                    orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
//                    orgTranslateY = ((Circle) (t.getSource())).getTranslateY();
//                }
//            };
//
//    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
//            new EventHandler<MouseEvent>() {
//
//                @Override
//                public void handle(MouseEvent t) {
//                    double offsetX = t.getSceneX() - orgSceneX;
//                    double offsetY = t.getSceneY() - orgSceneY;
//                    double newTranslateX = orgTranslateX + offsetX;
//                    double newTranslateY = orgTranslateY + offsetY;
//
//                    ((Circle) (t.getSource())).setTranslateX(newTranslateX);
//                    ((Circle) (t.getSource())).setTranslateY(newTranslateY);
//                }
//            };
//
//}
