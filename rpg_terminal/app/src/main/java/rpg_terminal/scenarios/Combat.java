package rpg_terminal.scenarios;

import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.entities.creatures.Player;

public class Combat extends Scene {
    private Creature creature;

    public Combat(String description, Creature creature) {
        super(description);
        this.creature = creature;
    }

    @Override
    public void startEvent(Scanner sc, Player player) {
        System.out.println("Combate Iniciou");
        boolean combat = true;
        do {
            System.out.println("Sua Vida: " + player.life);
            System.out.println("Inimigo Vida: " + creature.life);
            System.out.println("O que vc deseja fazer?");
            System.out.println("1.Atacar");
            System.out.println("2.Usar habilidade");
            System.out.println("3.Usar item");
            System.out.println("4.fugir");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Atacou");
                    if (player.attackPriority(creature)) {
                        System.out.println("O jogador é mais rapido");
                        player.attack(creature);
                        creature.attack(player);
                    } else {
                        System.out.println("O inimigo é mais rapido");
                        creature.attack(player);
                        player.attack(creature);
                    }
                    break;
                case 2:
                    System.out.println("Usou habilidade");
                    break;
                case 3:
                    System.out.println("Usou item");
                    // player.useItem();
                    // enemy.attack(player);
                    break;
                case 4:
                    System.out.println("Fugiu!");
                    // if (player.run()) combat = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida");
                    break;
            }
        } while (combat);
    }
}
