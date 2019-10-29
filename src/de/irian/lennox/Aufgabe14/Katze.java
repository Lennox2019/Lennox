package de.irian.lennox.Aufgabe14;

public class Katze {
    String rasse;
    int alter;
    int gebJahr;
    int lebensErwarung;

    public void miauen() {
        System.out.println("Miau");

    }

    public void alterinTagen() {
        System.out.println("alter ist in Tagen:" + alter * 365);
    }


}
