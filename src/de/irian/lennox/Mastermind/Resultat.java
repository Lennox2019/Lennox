package de.irian.lennox.Mastermind;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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

                this.farbfelder.add(farbfeld);
            }
        }
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20, 20, 20, 20));
    }

    public void setBlackWhite(Paint[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (result[i] == Color.BLACK) {
                this.farbfelder.get(i).setFill(Color.BLACK);
            }
            if (result[i] == Color.WHITE) {
                this.farbfelder.get(i).setFill(Color.WHITE);
            }
        }
    }
}
