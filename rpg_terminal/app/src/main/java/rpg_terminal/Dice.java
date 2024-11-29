package rpg;

import java.util.Scanner;

public abstract class Dice {
    public static int roll(Scanner sc, int timesToRoll, int sides) {
        int total = 0;
        for (int i = 0; i < timesToRoll; i++) {
            System.out.println("Pressione Enter para rolar o dado " + (i+1) + " de " + timesToRoll + " (d" + sides + ")");
            sc.nextLine();
            int result = (int) (Math.random() * sides) + 1;
            System.out.println("Voce rolou:" + result);
            total += result;
        }

        return total; 
    }

    public static int simpleRoll(int sides) {
        return (int) (Math.random() * sides) + 1;
    }
}