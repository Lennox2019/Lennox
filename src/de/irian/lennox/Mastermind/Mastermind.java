package de.irian.lennox.Mastermind;


import javafx.scene.paint.Color;

import java.util.*;
import java.util.List;

public class Mastermind {
    private static List<Color> secretColors = new ArrayList<>();
    private static List<Color> guessedColors = new ArrayList<>();

    public static void generateSecretColors() {

        for (int i = 0; i <= 3; i++) {
            Random random = new Random();
            Color randomColor;

            Color[] farben = SpielfeldGrid.getFarben();
            int index = random.nextInt(farben.length);
            randomColor = farben[index];
            Mastermind.secretColors.add(randomColor);
            //System.out.println(randomColor);
        }
    }

    public static void setGuessedColors(List<Color> guessedColors) {
        Mastermind.guessedColors = guessedColors;
    }

    public static Color[] checkColors() {
        Color[] result = new Color[4];

        Set<Color> temp = new HashSet<>(Mastermind.secretColors);

        for (int i = 0; i < Mastermind.guessedColors.size(); i++) {
            if (Mastermind.guessedColors.get(i) == Mastermind.secretColors.get(i)) {
                result[i] = Color.BLACK;
                temp.remove(Mastermind.secretColors.get(i));
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != Color.BLACK) {
                if (temp.contains(Mastermind.guessedColors.get(i))){
                    result[i] = Color.WHITE;
                }
            }
        }
        return result;
    }
}





