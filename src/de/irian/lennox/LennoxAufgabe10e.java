package de.irian.lennox;

public class LennoxAufgabe10e {
    public static void main(String[] args) {

        final int GESAMT = 19;
        int anzahl = 9;
        int plus = 0;
        int punkte = 0;

        for (int j = 0; j < 10; j++) {

            punkte = 0;
            for (int i = 0; i < anzahl; i++) {
                System.out.print(".");
                punkte = i + 1;

            }
            plus = GESAMT - punkte * 2;
            for (int k = 0; k < plus; k++) {
                System.out.print("+");
            }
            for (int i = 0; i < anzahl; i++) {
                System.out.print(".");
            }
            System.out.println();
            anzahl -= 1;
        }
    }
}
