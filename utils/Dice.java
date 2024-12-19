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
            int result = (int) (Math.random() * sides) + 1;
            System.out.print("Rolando d" + sides + ", " + (i + 1) + "/" + timesToRoll + " O resultado foi: " + result + "     ");
            Message.enter("");
            sc.nextLine();
            total += result;
        }
        System.out.println("O resultado total foi " + total);
        sc.nextLine();
        return total;
    }

    public static int percent(Scanner sc) {
        int total;
        
        Message.dice(sc, 2);
        int r1 = (int) (Math.random() * 10) + 1;
        System.out.print("\nRolando d10, 1/2  O resultado foi: " + r1 + "     ");
        Message.enter("");
        sc.nextLine();
        int r2 = (int) (Math.random() * 10) + 1;
        System.out.print("\nRolando d10, 2/2  O resultado foi: " + r2 + "     ");
        Message.enter("");
        sc.nextLine();
        total = (r1 * 10) + r2;
        System.out.print("Voce conseguiu " + total + " pontos.     ");
        Message.enter("");
        sc.nextLine();
        Screen.clear();
        return total;
    }
}
