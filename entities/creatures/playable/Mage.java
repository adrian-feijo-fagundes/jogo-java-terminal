/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures.playable;

import java.util.Scanner;

import terminalrpg.entities.creatures.Creature;
import terminalrpg.entities.creatures.Player;
import terminalrpg.utils.Message;
import terminalrpg.utils.Screen;

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
                "\nUma rajada de pura energia arcana, liberada \ndiretamente no alvo. O ataque causa dano mediano \ncom um custo baixo de mana, sendo \numa habilidade confiável e eficiente para \nconjuradores em combate.");
    }

    @Override
    public void useSpecialAbility(Scanner sc, Creature other) {

        int manaCost = 1;
        Screen.clear();
        if (!hasMana(manaCost)) {
            System.out.println("Voce não tem mana suficiente, então realiza um ataque normal");
            attack(sc, other);
            return;
        }
        System.out.println("Voce usa " + manaCost + " de mana então ataca com " + this.getSpecialHabilityName());

        Message.enter("");
        sc.nextLine();
        
        int damage = (this.getTotalAttack() * 2 + 5);
        System.out.println("O dano total é de: " + damage);
        int newLife = other.getLife() - damage;
        System.out.println("A vida de " + other.getName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
    }

}
