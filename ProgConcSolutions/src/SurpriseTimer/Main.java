package SurpriseTimer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Bomb b = new Bomb();
        Bomb b2 = new Bomb();
        b.start();
        b2.start();

        s.nextLine();
        b.interrupt();

    }
}
