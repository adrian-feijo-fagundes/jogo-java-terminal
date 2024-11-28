package rpg.interfaces;

import rpg.entities.Creature;

public interface Character {
    void attack(Creature other);
    void specialAttack();
}
