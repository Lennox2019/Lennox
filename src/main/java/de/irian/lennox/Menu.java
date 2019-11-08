package de.irian.lennox;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String eingabe = "";
        Scanner scanner = new Scanner(System.in);
        String geschlecht;
        String name = "";


        while (!eingabe.equals("3")) {
            System.out.println("Menü");
            System.out.println("1 Name:");
            System.out.println("2 Geschlecht:");
            System.out.println("3 Beenden:");
            System.out.print("eingabe:");
            eingabe = scanner.next();


            if (eingabe.equals("1")) {
                System.out.println("name eingeben");
                name = scanner.next();
                System.out.println(name);
            }
            if (eingabe.equals("2")) {
                System.out.println("Geschlecht angeben");
                geschlecht = scanner.next();
                if (geschlecht.equals("Männlich")) {
                    System.out.println("Herr" + name);
                } else {
                    System.out.println("Frau" + name);
                }


            }


        }


    }
}

