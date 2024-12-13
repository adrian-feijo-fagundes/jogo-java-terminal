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
public class Warrior extends Player {
    public Warrior(
            int mana,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(
                mana + 5,
                "Warrior",
                life + 15,
                attack + 10,
                speed + 5,
                luck + 5,
                name);
        this.setSpecialHabilityName("Impacto Colossal");
        this.setSpecialHabilityDescription(
                "O guerreiro concentra toda \nsua força em um único golpe devastador, esmagando o alvo com uma força \ntremenda. O ataque consome uma alta quantidade de mana, mas causa um dano \nmassivo, perfeito para finalizar inimigos poderosos.");
    }

    @Override
    public void useSpecialAbility(Scanner sc, Creature other) {
        int manaCost = 5;

        if (!hasMana(manaCost)) {
            System.out.println(" Voce não tem mana suficiente, então realiza um ataque normal ");
            attack(sc, other);
            return;
        }
        System.out.println("Voce usa " + manaCost + " de mana então ataca com " + this.getSpecialHabilityName());
        int damage = (this.getTotalAttack() * 3);
        System.out.println("O dano total é de: " + damage);
        int newLife = other.getLife() - damage;
        System.out.println("A vida de " + other.getName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
    }
}
