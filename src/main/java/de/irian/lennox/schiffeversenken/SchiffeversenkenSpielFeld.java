package de.irian.lennox.schiffeversenken;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SchiffeversenkenSpielFeld extends GridPane {
    private static final int ammountFields = 20;
    private static final int rowCount = 20;

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
                        if(SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.ZWEIER || SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.DREIER || SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.VIERER) {
                            int anzahlFelder = 0;

                            if (SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.ZWEIER) anzahlFelder = 2;
                            if (SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.DREIER) anzahlFelder = 3;
                            if (SchiffeversenkenFX.getDragDropHolder().getTyp() == Typ.VIERER) anzahlFelder = 4;

                            for(int i = 0; i<anzahlFelder; i++) {
                                double x = (i*20);
                                schiffeFeld.setX(x);
                                schiffeFeld.setFill(SchiffeversenkenFX.getDragDropHolder().getSchiffeFeld().getFill());
                            }
                        }
                        else {
                            schiffeFeld.setFill(SchiffeversenkenFX.getDragDropHolder().getSchiffeFeld().getFill());
                        }
                    }

                });
                SchiffeversenkenFX.setDragDropHolder(null);

                GridPane.setConstraints(schiffeFeld, i, j);
                getChildren().add(schiffeFeld);
            }
        }
    }
}