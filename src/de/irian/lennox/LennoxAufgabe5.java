package de.irian.lennox;

public class LennoxAufgabe5 {
    public static void main(String[] args) {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 16; i++) {
                if (j < 1) {
                    if (j < 8) {
                        System.out.print(".");
                    } else {
                        System.out.print("+");
                    }
                } else {
                    if (i < 2) {


                        System.out.print("+");
                    } else {
                        System.out.print(".");
                    }
                }
            }
            System.out.println();
        }

        String blume = "Gerane";
        if (blume.equals("Geranie")) {
            System.out.println(blume);
        } else {
            System.out.println("keine Geranie");
        }

    }
}