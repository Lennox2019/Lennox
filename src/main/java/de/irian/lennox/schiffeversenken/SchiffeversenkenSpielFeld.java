package de.irian.lennox.schiffeversenken;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SchiffeversenkenSpielFeld extends GridPane {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;
    //SchiffeFeld schiffeFeld = new SchiffeFeld(10, 10, 10, 10, Color.BLACK);


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
                SchiffeFeld schiffeFeld = SchiffeFeld.createSchiffeFeld(color);

                schiffeFeld.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {
                    @Override
                    public void handle(MouseDragEvent mouseDragEvent) {
                        schiffeFeld.setFill(SchiffeversenkenFX.getDragDropHolder().getFill());
                    }
                });
                SchiffeversenkenFX.setDragDropHolder(null);

                GridPane.setConstraints(schiffeFeld, i, j);
                getChildren().add(schiffeFeld);
            }
        }
    }
}