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
public class Mage extends Player {

    public Mage(
            int mana,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(
                mana + 15,
                "Mage",
                life + 5,
                attack + 5,
                speed + 5,
                luck + 10,
                name);
        this.setSpecialHabilityName("Explosão Arcana");
        this.setSpecialHabilityDescription(
                "Uma rajada de pura energia arcana, liberada diretamente no \nalvo. O ataque causa dano mediano com um custo baixo de \nmana, sendo uma habilidade confiável e eficiente para \nconjuradores em combate.");
    }

    @Override
    public void useSpecialAbility(Scanner sc, Creature other) {

        int manaCost = 1;

        if (!hasMana(manaCost)) {
            System.out.println("Voce não tem mana suficiente, então realiza um ataque normal");
            attack(sc, other);
            return;
        }
        System.out.println("Voce usa " + manaCost + " de mana então ataca com " + this.getSpecialHabilityName());
        System.out.println(this.getSpecialHabilityName());

        int damage = (this.getTotalAttack() * 2 + 5);
        System.out.println("O dano total é de: " + damage);
        int newLife = other.getLife() - damage;
        System.out.println("A vida de " + other.getName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
    }

}
