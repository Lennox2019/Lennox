package de.irian.lennox.schiffeversenken;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class Schiff extends GridPane {

    private static final int anzahlEinser = 1;
    private static final int anzahlZweier = 1;
    private static final int anzahlDreier = 1;
    private static final int anzahlVierer = 1;

    private Typ typ = null;
    private SchiffeFeld schiffeFeld = null;

    Schiff() {
        init();
    }

    Schiff(Typ typ, SchiffeFeld schiffeFeld) {
        this.typ = typ;
        this.schiffeFeld = schiffeFeld;
    }

    void init() {
        List<Schiff> schiffe = new ArrayList<>();

        for (int i = 0; i < anzahlEinser; i++) {
            SchiffeFeld schiffeFeld = SchiffeFeld.einserSchiff();
            Schiff schiff = new Schiff(Typ.EINSER, schiffeFeld);
            schiffe.add(schiff);
        }

        for (int i = 0; i < anzahlZweier; i++) {
            SchiffeFeld schiffeFeld = SchiffeFeld.zweierSchiff();
            Schiff schiff = new Schiff(Typ.ZWEIER, schiffeFeld);
            schiffe.add(schiff);
        }

        for (int i = 0; i < anzahlDreier; i++) {
            SchiffeFeld schiffeFeld = SchiffeFeld.dreierSchiff();
            Schiff schiff = new Schiff(Typ.DREIER, schiffeFeld);
            schiffe.add(schiff);
        }

        for (int i = 0; i < anzahlVierer; i++) {
            SchiffeFeld schiffeFeld = SchiffeFeld.viererSchiffe();
            Schiff schiff = new Schiff(Typ.VIERER, schiffeFeld);
            schiffe.add(schiff);
        }

        int i = 0;
        for (Schiff schiff : schiffe) {
            schiff.schiffeFeld.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    schiff.schiffeFeld.startFullDrag();
                    Schiffeversenken.stage.getScene().setCursor(Cursor.HAND);
                    SchiffeversenkenFX.setDragDropHolder(schiff.schiffeFeld);
                }
            });
            GridPane.setConstraints(schiff.schiffeFeld, 40, i++);
            getChildren().add(schiff.schiffeFeld);
            setVgap(10);
        }
    }
}

enum Typ {
    EINSER,
    ZWEIER,
    DREIER,
    VIERER
}
