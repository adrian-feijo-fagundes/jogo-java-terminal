package interfaces;

import entities.Creature;

public interface Character {
    void attack(Creature other);
    void specialAttack();
}
