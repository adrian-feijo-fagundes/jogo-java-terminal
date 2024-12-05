package rpg_terminal;

import java.util.Scanner;

import rpg_terminal.managers.Scenes;
import rpg_terminal.utils.GameState;
import rpg_terminal.utils.Screen;

public class TestingScenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameState state = new GameState();
        Scenes game = new Scenes();
        Screen.clear();
        game.startGame(sc, null, state);
        sc.close();
    }
}
