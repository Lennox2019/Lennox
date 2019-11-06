package de.irian.lennox.Mastermind;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Resultat extends GridPane {

    private List<Farbfeld> farbfelder = new ArrayList<>();

    public Resultat() {
        init();
    }

    private void init() {
        for (int i = 0, n = 2; i < n; i++) {
            for (int y = 0, m = 2; y < m; y++) {
                Farbfeld farbfeld = new Farbfeld(0, 0, 5, Color.GRAY);
                setConstraints(farbfeld, y, i);
                getChildren().add(farbfeld);

                RadialGradient gradient1 = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
                        new Stop(0, Color.LIGHTGRAY),
                        new Stop(1, Color.BLACK)
                });

                farbfeld.setFill(gradient1);
                farbfeld.setStroke(Color.BLACK);


                this.farbfelder.add(farbfeld);
            }
        }
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20, 20, 20, 20));
    }

    public void setBlackWhite(Paint[] result) {
        RadialGradient black = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.BLACK),
                new Stop(1, Color.WHITE)
        });
        RadialGradient white = new RadialGradient(0, 0, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
                new Stop(0, Color.WHITE),
                new Stop(1, Color.BLACK)
        });
        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i]);
            if (result[i] == Color.BLACK) {
                this.farbfelder.get(i).setFill(black);
            }


            if (result[i] == Color.WHITE) {
                this.farbfelder.get(i).setFill(white);
            }

        }
    }
}
