package de.irian.lennox.Mastermind;

import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        String eingabe = "";
        Scanner scanner = new Scanner(System.in);
        String Mehrspieler;
        String Einzelspieler;

        while (!eingabe.equals("3")) {
            System.out.println("MASTERMIND");
            System.out.println("1 Einzelspieler");
            System.out.println("2 Mehrspieler");
            System.out.println("3 Beenden");
            System.out.print("eingabe:");
            eingabe = scanner.next();

            if (eingabe.equals("1")) ; {

            }
            if (eingabe.equals("2")) ; {

            }
        }


    }
}



