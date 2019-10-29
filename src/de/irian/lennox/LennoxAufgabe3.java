package de.irian.lennox;

import java.util.Scanner;

public class LennoxAufgabe3 {
    public static void main(String[] args){
        float gewicht  = 78;
        float groesse = 0;
        int mehrwertsteuer = 19;
        Scanner scanner = new Scanner (System.in);
        System.out.print("Der Nettopreis ist: ");
        nettopreis = scanner.nextFloat();
        brutopreis = nettopreis + (nettopreis / 100 * mehrwertsteuer);
        System.out.print("Der Brutopreis ist: "+ brutopreis);
    }
}
