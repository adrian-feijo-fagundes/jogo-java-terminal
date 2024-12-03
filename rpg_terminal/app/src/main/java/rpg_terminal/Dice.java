package rpg_terminal;

import java.util.Scanner;

public abstract class Dice {

    public static int simpleRoll(int sides) {
        return (int) (Math.random() * sides) + 1;
    }

    public static int roll(Scanner sc, int timesToRoll, int sides) {
        message(sc, timesToRoll);
        int total = 0;
        for (int i = 0; i < timesToRoll; i++) {
            System.out.println((i + 1) + " vez rolando o dado");
            System.out.println("Pressione Enter para rolar o d" + sides);
            sc.nextLine();

            int result = (int) (Math.random() * sides) + 1;
            System.out.println("O resultado foi: " + result);

            System.out.println("PRESSIONE ENTER PARA CONTINUAR");
            sc.nextLine();
            Screen.clear();
            total += result;
        }
        System.out.println("O resultado total foi " + total);
        sc.nextLine();
        return total;
    }

    public static int percent() {
        Scanner sc = new Scanner(System.in);
        message(null, 2);
        System.out.println("1 vez rolando o dado");
        System.out.println("Pressione Enter para rolar o d10");

        int r1 = (int) (Math.random() * 10) + 1;
        System.out.println("O resultado foi: " + r1);
        sc.nextLine();
        Screen.clear();

        System.out.println("2 vez rolando o dado");
        System.out.println("Pressione Enter para rolar o d10");

        int r2 = (int) (Math.random() * 10) + 1;
        System.out.println("O resultado foi: " + r2);
        sc.nextLine();
        Screen.clear();

        System.out.println("PRESSIONE ENTER PARA CONTINUAR");
        sc.nextLine();
        Screen.clear();
        int total = (r1 * 10) + r2;
        sc.close();
        return total;
    }

    private static void message(Scanner sc, int timesToRoll) {
        System.out.println("Voce deverá rolar o dado " + timesToRoll + " Vezes.");
        System.out.println("");
        System.out.println("PRESSIONE ENTER PARA CONTINUAR");
        sc.nextLine();
        Screen.clear();
    }
}
