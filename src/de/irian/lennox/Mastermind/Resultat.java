package de.irian.lennox.Mastermind;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Resultat extends GridPane {

    public Resultat() {
        init();
    }

    private void init() {
        for (int i = 0, n = 2; i < n; i++) {
            for (int y = 0, m = 2; y < m; y++) {
                Farbfeld farbfeld = new Farbfeld(0, 0, 5, Color.GRAY);
                GridPane.setConstraints(farbfeld, y, i);
                getChildren().add(farbfeld);

            }
        }
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(20, 20, 20, 20));
    }
}
