package de.irian.lennox;

import java.util.Scanner;

public class Taschenrechner {
    public static void main(String[] args) {
        double zahl1 = 0;
        double zahl2 = 0;
        Scanner scanner = new Scanner(System.in);
        double ergebnis = 0;
        String eingabe = "";
        String plus = "Plus";
        String minus = "Minus";
        String mal = "Mal";
        String geteilt = "Geteilt";

        while (!eingabe.equals("beenden")) {
            System.out.println("Bitte geben sie die gewünschte Rechenoption an");
            System.out.println("Plus steht für +, Minus steht für -, Mal steht für * und Geteielt steht für /");
            System.out.println("Für Beenden beenden eingeben");
            System.out.println("Rechenoption:");
            eingabe = scanner.next();

            if (eingabe.equals("beenden")) {
                System.out.println("Bye Bye");
            }
            else if (!eingabe.equals(plus) && !eingabe.equals(minus) && !eingabe.equals(mal) && !eingabe.equals(geteilt)) {
                System.out.println("Leider geht die Rechenoption nicht.");
            } else {
                System.out.println("Erste Zahl bitte:");
                zahl1 = scanner.nextDouble();
                System.out.println("Zweite Zahl bitte:");
                zahl2 = scanner.nextDouble();

                if (eingabe.equals(plus)) {
                    ergebnis = zahl1 + zahl2;
                }
                if (eingabe.equals(minus)) {
                    ergebnis = zahl1 - zahl2;
                }
                if (eingabe.equals(mal)) {
                    ergebnis = zahl1 * zahl2;
                }
                if (eingabe.equals(geteilt)) {
                    ergebnis = zahl1 / zahl2;
                }
                System.out.println("Ergebnis:" + ergebnis);
            }
        }
    }
}