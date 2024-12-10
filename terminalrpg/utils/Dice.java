/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.utils;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public abstract class Dice {
    public static int roll(Scanner sc, int timesToRoll, int sides) {
        Message.dice(sc, timesToRoll);
        int total = 0;
        for (int i = 0; i < timesToRoll; i++) {
            System.out.println((i + 1) + " vez rolando o dado");
            System.out.println("Pressione Enter para rolar o d" + sides);
            sc.nextLine();

            int result = (int) (Math.random() * sides) + 1;
            System.out.println("O resultado foi: " + result);

            Message.enter("");
            sc.nextLine();
            total += result;
        }
        System.out.println("O resultado total foi " + total);
        sc.nextLine();
        return total;
    }

    public static int percent() {
        int total;
        try (Scanner sc = new Scanner(System.in)) {
            Message.dice(sc, 2);
            System.out.println("1 vez rolando o dado");
            Message.enter("para rolar o d10");
            int r1 = (int) (Math.random() * 10) + 1;
            System.out.println("O resultado foi: " + r1);
            sc.nextLine();
            System.out.println("2 vez rolando o dado");
            Message.enter("para rolar o d10");
            int r2 = (int) (Math.random() * 10) + 1;
            System.out.println("O resultado foi: " + r2);
            sc.nextLine();
            Message.enter("");
            sc.nextLine();
            total = (r1 * 10) + r2;
        }
        return total;
    }
}
