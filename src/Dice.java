import java.util.Scanner;

public abstract class Dice {
    public static int roll(Scanner sc, int timesToRoll, int sides) {
        int total = 0;
        for (int i = 0; i < timesToRoll; i++) {
            System.out.println("Pressione Enter para rolar o dado" + i + " de " + timesToRoll + "(d" + sides + ")");
            sc.nextLine();
            int result = (int) (Math.random() * sides) + 1;
            System.out.println("Voce rolou:" + result);
            total += result;
        }

        return total; 
    }
}
