package rpg_terminal;

import java.util.Scanner;

import rpg_terminal.entities.scenes.Scene;

public class TestingScenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Scene s1 = new Scene();

        System.out.println("");

        s1.startEvent(sc, null);

        sc.close();
    }
}
