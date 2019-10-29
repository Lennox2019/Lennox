package de.irian.lennox;

import java.util.Scanner;

public class LennoxAufgabe3 {
    public static void main(String[] args) {
        float gewicht = 78;
        double groesse = 1.75;
        int alter = 24;
        double Bmi = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Der der Bmi ist: ");
        Bmi = scanner.nextFloat();
        Bmi = gewicht / (groesse * groesse);
        System.out.print("Der Bmi ist: " + Bmi);
    }
}
