package de.irian.lennox.mastermind;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static javafx.scene.paint.Color.*;

public class Mastermind {
    static List<Color> secretColors = new ArrayList<>();
    private static List<Color> guessedColors = new ArrayList<>();
    public static GridPane myGrid;
    public static Stage stage;
    public static AtomicInteger rowCount = new AtomicInteger(0);
    public static final boolean showSecretColors = true;

    public static void generateSecretColors() {
        secretColors = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            Random random = new Random();
            Color randomColor;

            Color[] farben = SpielfeldGrid.getFarben();
            int index = random.nextInt(farben.length);
            randomColor = farben[index];
            Mastermind.secretColors.add(randomColor);
        }
    }

    public static void setGuessedColors(List<Color> guessedColors) {
        Mastermind.guessedColors = guessedColors;
    }

    public static Color[] checkColors() {
        Color[] result = new Color[4];

        List<Color> temp = new ArrayList<>(Mastermind.secretColors);

        int counter = 0;

        for (int i = 0; i < Mastermind.guessedColors.size(); i++) {
            if (Mastermind.guessedColors.get(i) == Mastermind.secretColors.get(i)) {
                result[i] = Color.BLACK;
                temp.remove(Mastermind.secretColors.get(i));
                counter++;
            }
        }

        // wenn alle schwarz, dann zeige popup und return result
        if (counter == 4) {
            showDialog();
            return result;
        }

        boolean anotherTry = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != Color.BLACK) {
                if (temp.contains(Mastermind.guessedColors.get(i))) {
                    result[i] = Color.WHITE;
                    temp.remove(Mastermind.guessedColors.get(i));
                }
                anotherTry = true;
            }
        }
        if (anotherTry) {
            SpielfeldGrid spielfeld = new SpielfeldGrid();

            GridPane.setConstraints(spielfeld, 0, rowCount.incrementAndGet());
            myGrid.getChildren().add(spielfeld);
            stage.sizeToScene();
        }
        return result;
    }

    private static void showDialog() {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        VBox dialogVbox = new VBox(20);

        Text text = new Text("Gewonnen!");

        dialogVbox.setBackground(new Background(new BackgroundFill(BLACK, null, null)));

        text.setStroke(RED);
        text.setStrokeWidth(0.2);
        Effect dropShadow = new DropShadow(15, WHITE);
        text.setEffect(dropShadow);

        text.setFill(Color.GOLD);

        text.setScaleX(4);
        text.setScaleY(4);
        text.setScaleZ(4);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), text);
        fadeTransition.setFromValue(3.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();
        dialogVbox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().
                add(text);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialogScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>
                () {

            @Override
            public void handle(KeyEvent t) {
                if(t.getCode()== KeyCode.ESCAPE)
                {
                    Stage sb = (Stage)dialog.getScene().getWindow();//use any one object
                    sb.close();
                }
            }
        });
        dialog.show();
    }
}