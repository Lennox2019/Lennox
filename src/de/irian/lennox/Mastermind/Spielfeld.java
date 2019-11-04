package de.irian.lennox.Mastermind;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Spielfeld extends Rectangle {


    public Spielfeld() {
        initRectangle();
    }

    public void initRectangle() {
        setHeight(50);
        setWidth(300);
        setFill(Color.GRAY);
    }

}