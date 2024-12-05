package rpg_terminal;

import java.util.Scanner;

import rpg_terminal.entities.creatures.playable.Hunter;
import rpg_terminal.entities.creatures.playable.Merchant;
import rpg_terminal.entities.creatures.playable.Player;
import rpg_terminal.entities.creatures.playable.Warrior;
import rpg_terminal.utils.Dice;
import rpg_terminal.utils.Screen;



public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var player = createPlayer(sc);
        System.out.println(player.getInfo());
        sc.nextLine();
        Screen.clear();
        sc.close();
    }

    public static Player createPlayer(Scanner sc) {
        System.out.println("\nQual o nome do seu Personagem?");

        String name = sc.nextLine();
        System.out.println("\nVocê deseja escolher qual classe para o seu personagem?");
        System.out.println("1. Caçador");
        System.out.println("2. Guerreiro");
        System.out.println("3. Mercador");
        System.out.println("Digite sua escolha");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Escolha uma opção válida");
            choice = sc.nextInt();
        }
        System.out.println("\nAgora vamos rolar os dados para calcular os atributos do seu personagem");
        sc.nextLine();
        System.out.println("\nRolando dados para o HP (vida)");
        int life = Dice.roll(sc, 3, 6);
        System.out.println("\nRolando dados para o MP (mana)");
        int mana = Dice.roll(sc, 3, 6);
        System.out.println("\nRolando dados para o ATK (ataque)");
        int attack = Dice.roll(sc, 2, 6);
        System.out.println("\nRolando dados para o SPD (velocidade)");
        int speed = Dice.roll(sc, 2, 6);
        System.out.println("\nRolando dados para o LUCK (sorte)");
        int luck = Dice.roll(sc, 2, 6);
        Player player = null;
        switch (choice) {
            case 1 -> player = new Hunter(name, life, attack, mana, speed, luck);
            case 2 -> player = new Warrior(name, life, attack, mana, speed, luck);
            case 3 -> player = new Merchant(name, life, attack, mana, speed, luck);
        }
        return player;
    }
}