package de.irian.lennox.schiffeversenken;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SchiffeversenkenSpielFeld extends GridPane {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;
    SchiffeFelder schiffeFelder = new SchiffeFelder(10, 10, 10, 10, Color.BLACK);

    public SchiffeversenkenSpielFeld() {
        init();
    }

    void init() {
        for (int j = 0; j < rowCount; j++) {
            for (int i = 0; i < ammountFields; i++) {
                if (i > ammountFields) ;
                SchiffeFelder schiffeFeld = SchiffeFelder.createSchiffeFeld();
                GridPane.setConstraints(schiffeFeld, i, j);
                getChildren().add(schiffeFeld);
            }
        }
    }
}