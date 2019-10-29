package de.irian.lennox.Aufgabe13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LennoxAufgabeJasmin {
    public static void main(String[] args) {


        List<String> listStrings = new ArrayList<>();
        listStrings.add("Auto");
        listStrings.add("Fahrrad");
        listStrings.add("Bus");
        listStrings.add("Zug");
        System.out.println(listStrings);


        String[] arrayStrings = {"Auto", "Fahrrad", "Bus", "Zug"};
        for (int i = 0; i < arrayStrings.length; i++) {
            System.out.print(arrayStrings[i] + " ");
        }

        System.out.println();

        List<Integer> zahlenliste = new ArrayList<>();
        zahlenliste.add(1);
        zahlenliste.add(5);
        zahlenliste.add(18);
        zahlenliste.add(12);
        zahlenliste.add(30);
        System.out.println(zahlenliste);

        Integer[] zahlenStrings = {1, 5, 18, 12, 30};
        for (int i = 0; i < zahlenStrings.length; i++) {
            System.out.print(zahlenStrings[i] + " ");
        }
    }
}
