/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.scene;

import terminalrpg.entities.creatures.Player;
import terminalrpg.managers.PlayerManager;
import terminalrpg.utils.GameState;
import terminalrpg.utils.Message;

import java.util.Scanner;
import terminalrpg.entities.creatures.Enemy;

/**
 *
 * @author Adrian
 */
public class Combat extends Scene {
    private final Enemy creature;
    private Scene gameOver;

    public Combat(String name, Enemy creature, Scene gameOver) {
        super(name);
        this.creature = creature;
        this.gameOver = gameOver;
    }

    public boolean wasDefeated(GameState gameState) {
        return gameState.defeatEnemy(creature.getId());
    }

    public void startBattle(Scanner sc, Player player) {
        // Faz o calculo dos status do jogador no inicio do combate
        // para considerar os bonus de equipamentos
        player.calcTotalStatus();

        System.out.println("Combate Iniciou");
        boolean combat = true;
        do {
            System.out.println("\n------------------------------------------");
            System.out.println("-                 BATALHA                -");
            System.out.println("------------------------------------------");
            System.out.println(player.getName() + " HP: " + player.getLife() + " MANA: " + player.getMana());
            System.out.println(creature.getTypeName() + " HP: " + creature.getLife());
            System.out.println("------------------------------------------");
            System.out.println("1.Atacar        2.Usar habilidade");
            System.out.println("3.Item          4.fugir");
            System.out.println("------------------------------------------");
            System.out.print("\nEscolha uma opção: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Atacou");
                    if (player.attackPriority(creature)) {
                        // O jogador é mais rapido
                        player.attack(sc, creature);
                        if (!creature.isDead()) {
                            creature.attack(sc, player);
                        }
                    } else {
                        // O inimigo é mais rapido
                        creature.attack(sc, player);
                        if (!player.isDead()) {
                            player.attack(sc, creature);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Usou Habilidade especial\n");
                    if (player.attackPriority(creature)) {
                        // O jogador é mais rapido
                        player.useSpecialAbility(sc, creature);
                        if (!creature.isDead()) {
                            creature.attack(sc, player);
                        }
                    } else {
                        // O inimigo é mais rapido
                        creature.attack(sc, player);
                        if (!player.isDead()) {
                            player.useSpecialAbility(sc, creature);
                        }
                    }
                }
                case 3 -> {
                    if (player.hasConsumables()) {
                        player.useItem(sc);
                        creature.attack(sc, player);
                    } else {
                        System.out.println("Você não possui nenhum item consumivel");
                    }
                }
                case 4 -> {
                    if (player.flee(sc)) {
                        System.out.println("Conseguiu fugir!");
                        combat = false;
                    } else {
                        System.out.println("Não conseguiu fugir!");
                        creature.attack(sc, player);
                    }
                }
                default -> System.out.println("Escolha uma opção valida");
            }
            if (player.isDead() || creature.isDead()) {
                combat = false;
            }
        } while (combat);
    }

    @Override
    public Scene startEvent(Scanner sc, Player player, GameState gameState, PlayerManager playerManager) {
        if (!haveItem(player)) {
            System.out.println(this.getNeededItemMessage());
            Message.enter("Para voltar");
            sc.nextLine();
            return getLastScene();
        }

        
       

        // Inicia o combate se o inimigo não foi derrotado
        if (!wasDefeated(gameState)) {
            startBattle(sc, player);
        }

        showMessages(sc, currentMessages(isFirstVisit(gameState)));
        if (isFirstVisit(gameState)) {
            gameState.addToVisited(this.getId());
            Message.enter("");
        }
        
        // Verifica se o jogador morreu durante o combate
        if (player.isDead()) {
            return gameOver;
        }
        if (creature.isDead() && !wasDefeated(gameState)) {
            System.out.println("Você conseguiu derrotar " + creature.getType() + " " + creature.getName());

            Message.enter("");
            sc.nextLine();

            creature.drop(player);

            Message.enter("");
            sc.nextLine();
            // Marca o inimigo como derrotado
            gameState.addDefeatedEnemy(creature.getId());

            Scene nextScene = showOptions(sc, playerManager, currentMessages(isFirstVisit(gameState)));
            return nextScene;
        }
        if (creature.isDead() && wasDefeated(gameState)) {
            Scene nextScene = showOptions(sc, playerManager, currentMessages(isFirstVisit(gameState)));
            return nextScene;
        }
        return this.getLastScene();
    }
}
