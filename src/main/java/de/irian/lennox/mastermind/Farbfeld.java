package de.irian.lennox.mastermind;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Farbfeld extends Circle{

    public Farbfeld (int centerX, int centerY, int radius, Color color){

        initCircle(centerX, centerY, radius, color);
    }

    public void initCircle (int centerX, int centerY, int radius, Color color){
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
        if (color != null) {
            setFill(color);
        }
    }
}