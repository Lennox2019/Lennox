package de.irian.lennox.Aufgabe14;

public class Hund {
    String rasse;
    int alter;
    int gebJahr;
    int lebensErwarung;

    public void bellen() {
        System.out.println("WufWuf");

    }

    public void alterinTagen() {
        System.out.println("alter in Tagen ist:" + alter * 365);
    }
}
