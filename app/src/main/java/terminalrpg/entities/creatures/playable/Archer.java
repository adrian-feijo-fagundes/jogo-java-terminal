package terminalrpg.entities.creatures.playable;

import java.util.Scanner;
import terminalrpg.entities.creatures.Creature;
import terminalrpg.entities.creatures.Player;

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
        this.setSpecialHabilityDescription(
                " Uma flecha envolta em energia crepuscular, disparada com \nprecisão letal. Ao atingir o alvo, concentra toda a força \nem um único ponto, causando dano mediano.");
    }

    @Override
    public void useSpecialAbility(Scanner sc, Creature other) {
        int manaCost = 2;

        if (!hasMana(manaCost)) {
            System.out.println(" Voce não tem mana suficiente, então realiza um ataque normal");
            attack(sc, other);
            return;
        }
        System.out.println("Voce usa " + manaCost + " de mana então ataca com " + this.getSpecialHabilityName());

        int damage = (this.getTotalAttack() * 2 + 5);
        System.out.println("O dano total é de: " + damage);
        int newLife = other.getLife() - damage;
        System.out.println("A vida de " + other.getName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
    }
}
