package de.irian.lennox.schiffeversenken;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SchiffeFeld extends Rectangle {

    public SchiffeFeld(double recX, double rexY, double width, double higth, Color color) {

        initRectangle(recX, rexY, width, higth, color);
    }

    public void initRectangle(double recX, double recY, double width, double higth, Color color) {
        setX(recX);
        setY(recY);
        setHeight(higth);
        setWidth(width);
        if (color != null) {
            setFill(color);
        }
    }

    public static SchiffeFeld createSchiffeFeld(Color color) {
        SchiffeFeld schiffeFeld = new SchiffeFeld(20, 20, 20, 20, Color.TRANSPARENT);
        schiffeFeld.setFill(Color.TRANSPARENT);
        schiffeFeld.setStroke(color);
        return schiffeFeld;
    }
}