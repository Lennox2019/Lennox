package de.irian.lennox.schiffeversenken;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Schiff extends GridPane {

    private static final int anzahlEinser = 1;
    private static final int anzahlZweier = 1;
    private static final int anzahlDreier = 1;
    private static final int anzahlVierer = 1;

    private Typ typ = null;
    private double x = 0;
    private double y = 0;
    private List<SchiffeFeld> schiffeFelder = null;

    Schiff() {
        init();
    }

    Schiff(Typ typ, double x, double y, List<SchiffeFeld> schiffeFelder) {
        this.typ = typ;
        this.x = x;
        this.y = y;
        this.schiffeFelder = schiffeFelder;
    }

    void init() {
        SchiffeFeld schiffeFeld = SchiffeFeld.createSchiffeFeld(Color.BLACK);
        schiffeFeld.setFill(Color.BLACK);
        List<Schiff> schiffe = new ArrayList<>();
        List<SchiffeFeld> schiffeFelder = new ArrayList<>();

        for (int i = 0; i < anzahlEinser; i++) {
            schiffeFelder.add(schiffeFeld);
            Schiff schiff = new Schiff(Typ.EINSER, 0, 0, schiffeFelder);
            schiffe.add(schiff);
        }

        schiffeFelder = new ArrayList<>();
        for (int i = 0; i < anzahlZweier; i++) {
            for(int j=0; j<2; j++) {
                schiffeFelder.add(schiffeFeld);
            }
            Schiff schiff = new Schiff(Typ.ZWEIER, 0, 0, schiffeFelder);
            schiffe.add(schiff);
        }

        schiffeFelder = new ArrayList<>();
        for (int i = 0; i < anzahlDreier; i++) {
            for(int j=0; j<3; j++) {
                schiffeFelder.add(schiffeFeld);
            }
            Schiff schiff = new Schiff(Typ.DREIER, 0, 0, schiffeFelder);
            schiffe.add(schiff);
        }

        schiffeFelder = new ArrayList<>();
        for (int i = 0; i < anzahlVierer; i++) {
            for(int j=0; j<4; j++) {
                schiffeFelder.add(schiffeFeld);
            }
            Schiff schiff = new Schiff(Typ.VIERER, 0, 0, schiffeFelder);
            schiffe.add(schiff);
        }

        int i = 100;
        for(Schiff schiff : schiffe) {
            GridPane.setConstraints(schiff, i++, 1);
            getChildren().add(schiff);
        }
    }
}

enum Typ {
    EINSER,
    ZWEIER,
    DREIER,
    VIERER
}