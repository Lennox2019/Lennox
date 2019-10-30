package de.irian.lennox;

import java.util.Scanner;

public class Taschenrechner {
    public static void main(String[] args) {
        double zahl1= 0;
        double zahl2= 0;
        Scanner scanner = new Scanner(System.in);
        String eingabe;
        String plus = "Plus";
        String minus = "Minus";
        String mal = "Mal";
        String geteilt="Geteilt";

        System.out.println("Bitte geben sie die gewünschte Rechenoption an");
        System.out.println("Plus steht für +, Minus steht für -, Mal steht für * und Geteielt steht für /");
        System.out.println("Rechenoption:");
        eingabe = scanner.next();

        if (eingabe.equals(plus)) {
            System.out.println("Erste Zahl bitte:");
            zahl1 = scanner.nextDouble();
            System.out.println("Zweite Zahl bitte:");
            zahl2 = scanner.nextDouble();
            System.out.println("Ergebnis:" + (zahl1 + zahl2));
        }
        if (eingabe.equals(minus)) {
            System.out.println("Erste Zahl bitte:");
            zahl1 = scanner.nextDouble();
            System.out.println("Zweite Zahl bitte:");
            zahl2 = scanner.nextDouble();
            System.out.println("Ergebnis:" + (zahl1 - zahl2));
        }
        if (eingabe.equals(mal)) {
            System.out.println("Erste Zahl bitte:");
            zahl1 = scanner.nextDouble();
            System.out.println("Zweite Zahl bitte:");
            zahl2 = scanner.nextDouble();
            System.out.println("Ergebnis:" + zahl1 * zahl2);
        }
        if (eingabe.equals(geteilt)) {
            System.out.println("Erste Zahl bitte:");
            zahl1 = scanner.nextDouble();
            System.out.println("Zweite Zahl bitte:");
            zahl2 = scanner.nextDouble();
            System.out.println("Ergebnis:" + zahl1 / zahl2);
        }
    }
}
