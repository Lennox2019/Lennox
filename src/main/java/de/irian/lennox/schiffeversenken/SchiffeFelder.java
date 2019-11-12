package de.irian.lennox.schiffeversenken;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class SchiffeFelder extends Rectangle {

    public SchiffeFelder(double recX, double rexY, double width, double higth, Color color) {

        initRectangle(recX,rexY, width, higth, color);
    }
    public void initRectangle(double recX, double recY, double width, double higth, Color color) {
        setX(recX);
        setY(recY);
        setHeight(higth);
        setWidth(width);
        if (color != null);
            setFill(color);
    }
    public static SchiffeFelder createSchiffeFeld(){
    SchiffeFelder schiffeFeld = new SchiffeFelder(20, 20, 20, 20, Color.WHITE);

        schiffeFeld.setFill(Color.WHITE);
        schiffeFeld.setStroke(Color.BLUE);
        return schiffeFeld;
    }
}