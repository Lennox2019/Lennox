package de.irian.lennox.Mastermind;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Mastermind {
    static List<Color> secretColors = new ArrayList<>();
    private static List<Color> guessedColors = new ArrayList<>();
    public static GridPane myGrid;
    public static Stage stage;
    public static AtomicInteger rowCount = new AtomicInteger(0);

    public static void generateSecretColors() {

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

        Set<Color> temp = new HashSet<>(Mastermind.secretColors);

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
                    //temp.remove(Mastermind.guessedColors.get(i));
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

        text.setScaleX(2);
        text.setScaleY(2);
        text.setScaleZ(2);
        dialogVbox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().
                add(text);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}






