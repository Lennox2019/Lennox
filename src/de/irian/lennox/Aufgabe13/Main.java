package de.irian.lennox.Aufgabe13;

public class Main {
    public static void main(String[] args) {
        Person klaus = new Person("klaus", 78, 1.75, 24);
        double Bmi = klaus.gewicht / (klaus.groesse * klaus.groesse);
        System.out.println("Bmi von " + klaus.name + " ist:" + Bmi);





    }

}