package de.irian.lennox;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Taschenrechner {
    public static void main(String[] args) {
        BigDecimal zahl1 = new BigDecimal("0");
        BigDecimal zahl2 = new BigDecimal("0");
        Scanner scanner = new Scanner(System.in);
        BigDecimal ergebnis = new BigDecimal("0");
        String eingabe = "";
        String plus = "Plus";
        String minus = "Minus";
        String mal = "Mal";
        String geteilt = "Geteilt";
        String quadrat = "Quadrat";
        String wurzel = "Wurzel";
        while (!eingabe.equals("beenden")) {
            System.out.println("Bitte geben sie die gewünschte Rechenoption an");
            System.out.println("Plus steht für +, Minus steht für -, Mal steht für *, Geteielt steht für /, Quadrat steht für ^ und Wurzel steht für √");
            System.out.println("Für Beenden beenden eingeben");
            System.out.println("Deine Rechenoption / Beenden:");
            eingabe = scanner.next();

            if (eingabe.equals("beenden")) {
                System.out.println("Bye Bye");
            } else if (!eingabe.equals(plus) && !eingabe.equals(minus) && !eingabe.equals(mal) && !eingabe.equals(geteilt) && !eingabe.equals(quadrat) && !eingabe.equals(wurzel)) {
                System.out.println("Leider geht die Rechenoption nicht.");
            } else {
                System.out.println("Erste Zahl bitte:");
                zahl1 = scanner.nextBigDecimal();
                System.out.println("Zweite Zahl bitte:");
                zahl2 = scanner.nextBigDecimal();

                if (eingabe.equals(plus)) {
                    ergebnis = zahl1.add(zahl2);
                }
                if (eingabe.equals(minus)) {
                    ergebnis = zahl1.subtract(zahl2);
                }
                if (eingabe.equals(mal)) {
                    ergebnis = zahl1.multiply(zahl2);
                }
                if (eingabe.equals(geteilt)) {
                    ergebnis = zahl1.divide(zahl2, MathContext.DECIMAL64);
                }
                if (eingabe.equals(quadrat)) {
                    ergebnis = zahl1.pow(zahl2.intValue()); // Math.pow(zahl1, zahl2);
                }
            }
            if (eingabe.equals(wurzel)) {
                ergebnis =  zahl1.sqrt(MathContext.DECIMAL64);    //Math.sqrt(zahl1);
            }
            System.out.println("Ergebnis:" + ergebnis);
        }
    }
}
