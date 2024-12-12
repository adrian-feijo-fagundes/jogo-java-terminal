/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures.playable;

import java.util.Scanner;

import terminalrpg.entities.creatures.Creature;
import terminalrpg.entities.creatures.Player;

/**
 *
 * @author Adrian
 */
public class Archer extends Player {

    public Archer(
            int mana,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(
                mana + 5,
                "Archer",
                life + 5,
                attack + 10,
                speed + 10,
                luck + 5,
                name);

        this.setSpecialHabilityName("Tiro do Crepúsculo");
        this.setSpecialHabilityDescription("Uma flecha envolta em energia crepuscular, disparada com precisão letal. Ao atingir o alvo, concentra toda a força em um único ponto, causando dano mediano. Com um custo médio de mana, é uma habilidade equilibrada para ataques à distância.");
    }

    @Override
    public void useSpecialAbility(Scanner sc,Creature other) {
            int manaCost = 2;

            if (!hasMana(manaCost)) {
                System.out.println("Voce não tem mana suficiente, então realiza um ataque normal");
                attack(sc, other);
                return;
            }
            System.out.println("Voce usa " + manaCost + "de mana então ataca com ");
            System.out.println(this.getSpecialHabilityName());
            

            int damage = (this.getTotalAttack() * 2 + 5);
            System.out.println("O dano total é de: " +  damage);
            int newLife = other.getLife() -  damage;
            System.out.println("A vida de " + other.getName() + "foi de " + other.getLife() + " para " + newLife);
    
            other.setLife(newLife);
    }
}
