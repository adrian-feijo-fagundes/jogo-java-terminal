package rpg_terminal;

import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.entities.creatures.Hunter;
import rpg_terminal.entities.creatures.Merchant;
import rpg_terminal.entities.creatures.Player;
import rpg_terminal.entities.creatures.Priest;
import rpg_terminal.entities.creatures.Warrior;

import rpg_terminal.scenarios.Scene;

import rpg_terminal.scenarios.Combat;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var player = createPlayer(sc);
        // Perguntar nome do personagem
        System.out.println(player.getInfo());
        sc.nextLine();
        // // test combate
        // Creature enemy = new Creature("Orc", 100, 40, 0, 0, 30, 10);
        // Creature player = new Warrior("Guerreiro", 10, 40, 0, 0, 30, 0);
        // Scene battleOne = new Combat("", enemy);

        // battleOne.startEvent(sc, player);

        Screen.clear();

        sc.close();
    }

    public static Player createPlayer(Scanner sc) {
        System.out.println("\nQual o nome do seu Personagem?");

        String name = sc.nextLine();
        System.out.println("\nVocê deseja escolher qual classe para o seu personagem?");
        System.out.println("1. Caçador");
        System.out.println("2. Sacerdorte");
        System.out.println("3. Guerreiro");
        System.out.println("4. Mercador");
        System.out.println("Digite sua escolha");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 4) {
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
            case 2 -> player = new Priest(name, life, attack, mana, speed, luck);
            case 3 -> player = new Warrior(name, life, attack, mana, speed, luck);
            case 4 -> player = new Merchant(name, life, attack, mana, speed, luck);
        }
        return player;
    }
}