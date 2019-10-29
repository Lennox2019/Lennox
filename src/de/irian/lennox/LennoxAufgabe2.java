package de.irian.lennox;


public class LennoxAufgabe2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        System.out.println(++a); // 2
        System.out.println(a); // 2
        System.out.println(b++); // 2
        System.out.println(b); // 3
        System.out.println((++c) + (++c)); // 9
        System.out.println(c); // 5
        System.out.println((d++) + (d++)); // 9
        System.out.println(d); // 6
        /*for(int i = 0; i < 10 ; ++i) {
            System.out.println("i=" + i);
        }*/
    }
}
