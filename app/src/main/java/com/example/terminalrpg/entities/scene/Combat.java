/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.entities.scene;

import com.example.terminalrpg.entities.creatures.Creature;
import com.example.terminalrpg.utils.GameState;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Combat extends Scene {
    private final Creature creature;

    public Combat(String id, String name, Creature creature) {
        super(id, name);
        this.creature = creature;
    }

    @Override
    public Scene startEvent(Scanner sc, Creature player, GameState gameState) {
        System.out.println("Combate Iniciou");
        boolean combat = true;
        do {
            System.out.println("Sua Vida: " + player.getLife());
            System.out.println("Inimigo Vida: " + creature.getLife());
            System.out.println("O que vc deseja fazer?");
            System.out.println("1.Atacar");
            System.out.println("2.Usar habilidade");
            System.out.println("3.Usar item");
            System.out.println("4.fugir");
            switch (sc.nextInt()) {
                case 1 -> {
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
                }
                case 2 -> System.out.println("Usou habilidade");
                case 3 -> System.out.println("Usou item");
                // player.useItem();
                // enemy.attack(player);
                case 4 -> {
                    if (player.evade()) {
                        System.out.println("Conseguiu fugir!");
                        combat = false;
                    } else {
                        System.out.println("Não conseguiu fugir!");
                        creature.attack(player);
                    }
                }
                default -> System.out.println("Escolha uma opção valida");
            }
        } while (combat);
        return null;
    }
}
