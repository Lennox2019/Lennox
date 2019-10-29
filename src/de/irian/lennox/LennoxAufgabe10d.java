package de.irian.lennox;

public class LennoxAufgabe10d {
    public static void main(String[] args) {
        final int GESAMT = 14;
        int anzahl = 14;
        int plus = 0;
        int punkte = 0;

        for (int j = 0; j < 8; j++) {
            punkte = 0;

            for (int i = 0; i < anzahl; i++) {
                System.out.print(".");
                punkte = i+1;
            }

            plus = GESAMT - punkte;
            if (plus > 0) {
                for (int k = 0; k < plus; k++ ) {
                    System.out.print("+");
                }
            }

            System.out.println();
            anzahl -= 2;
        }
    }
}