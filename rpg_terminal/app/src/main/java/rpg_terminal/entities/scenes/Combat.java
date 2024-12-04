package rpg_terminal.entities.scenes;

import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;

public class Combat extends Scene {
    private Creature creature;

    public Combat(List<String> messages, Creature creature) {
        super();
        this.creature = creature;
    }

    @Override
    public Scene startEvent(Scanner sc, Creature player) {
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
                    if (player.run()) {
                        System.out.println("Conseguiu fugir!");
                        combat = false;
                    } else {
                        System.out.println("Não conseguiu fugir!");
                        creature.attack(player);
                    }
                    break;
                default:
                    System.out.println("Escolha uma opção valida");
                    break;
            }
        } while (combat);
        return null;
    }
}
