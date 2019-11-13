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

    public static SchiffeFeld einserSchiff() {
        SchiffeFeld schiffeFeld = new SchiffeFeld(20, 20, 20, 20, Color.BLACK);
        schiffeFeld.setFill(Color.BLACK);
        schiffeFeld.setStroke(Color.BLACK);
        return schiffeFeld;
    }
    public static SchiffeFeld zweierSchiff() {
        SchiffeFeld schiffeFeld = new SchiffeFeld(40, 20, 40, 20, Color.BLACK);
        schiffeFeld.setFill(Color.BLACK);
        schiffeFeld.setStroke(Color.BLACK);
        return schiffeFeld;
    }
    public static SchiffeFeld dreierSchiff() {
        SchiffeFeld schiffeFeld = new SchiffeFeld(60, 20, 60, 20, Color.BLACK);
        schiffeFeld.setFill(Color.BLACK);
        schiffeFeld.setStroke(Color.BLACK);
        return schiffeFeld;
    }
    public static SchiffeFeld viererSchiffe() {
        SchiffeFeld schiffeFeld = new SchiffeFeld(80, 20, 80, 20, Color.BLACK);
        schiffeFeld.setFill(Color.BLACK);
        schiffeFeld.setStroke(Color.BLACK);
        return schiffeFeld;
    }
}