package de.irian.lennox.Mastermind;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Farbfeld extends Circle{

    public Farbfeld (int centerX, int centerY, int radius, Color color){
        initCircle(centerX, centerY, radius, color);
    }

    public void initCircle (int centerX, int centerY, int radius, Color color){
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
        setFill(color);
    }

}
