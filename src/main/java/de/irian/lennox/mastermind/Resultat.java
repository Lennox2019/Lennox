package de.irian.lennox.mastermind;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        int countBlack = 0;
        int countWhite = 0;
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
                countBlack++;
            }


            if (result[i] == Color.WHITE) {
                countWhite++;
            }

        }

        List<Integer> numbersUsed = new ArrayList<>();
        Random random = new Random();
        while (numbersUsed.size() != 4) {
            int nextInt = random.nextInt(4);
            if (!numbersUsed.contains(nextInt)) {
                numbersUsed.add(nextInt);
            }
        }
        System.out.println("white " + countWhite);
        System.out.println("black " + countBlack);
        for (int i : numbersUsed) {
            if (countBlack > 0) {
                System.out.println("set black " + countBlack);

                this.farbfelder.get(i).setFill(black);
                countBlack--;
                continue;
            }
            if (countWhite > 0) {
                System.out.println("set white " + countWhite);

                this.farbfelder.get(i).setFill(white);
                countWhite--;
            }
        }
    }
}