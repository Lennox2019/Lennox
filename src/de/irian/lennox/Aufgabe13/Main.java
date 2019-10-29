package de.irian.lennox.Aufgabe13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        float gewicht;
        double groesse;
        int alter;


        Scanner scanner = new Scanner(System.in);
        System.out.print("Die groesse ist: ");
        groesse = scanner.nextDouble();

        System.out.print("Das gewicht ist:");
        gewicht=scanner.nextFloat();

        System.out.print("Das alter ist:");
        alter=scanner.nextInt();

        System.out.print("Der name ist:");
        name=scanner.next();



        Person person = new Person(name, gewicht, groesse, alter);
        double Bmi = person.gewicht / (person.groesse * person.groesse);
        System.out.println("Bmi von " + person.name + " ist:" + Bmi);





    }

}