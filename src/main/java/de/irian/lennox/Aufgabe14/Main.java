package de.irian.lennox.Aufgabe14;

public class Main {
    public static void main(String[] args) {
        Hund hannes = new Hund();
        hannes.alter = 12;
        hannes.rasse = "jackrussel";
        hannes.alterinTagen();
        hannes.bellen();

        Katze mietzie = new Katze();
        mietzie.alter = 5;
        mietzie.rasse = "persa";
        mietzie.miauen();
        mietzie.alterinTagen();
    }

}
