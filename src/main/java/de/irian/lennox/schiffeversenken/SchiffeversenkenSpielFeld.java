package de.irian.lennox.schiffeversenken;

import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.*;

public class SchiffeversenkenSpielFeld extends GridPane {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;
    SchiffeFelder schiffeFelder = new SchiffeFelder(10, 10, 10, 10, Color.BLACK);


    public SchiffeversenkenSpielFeld(Color color) {
        init(color);
    }

    void init(Color color) {
        createSpielFeld(color);
    }

    void createSpielFeld(Color color) {
        for (int j = 0; j < rowCount; j++) {
            for (int i = 0; i < ammountFields; i++) {
                if (i > ammountFields) ;
                SchiffeFelder schiffeFeld = SchiffeFelder.createSchiffeFeld(color);
                GridPane.setConstraints(schiffeFeld, i, j);
                getChildren().add(schiffeFeld);
            }
        }
    }
}