package rpg_terminal.entities.creatures.playable;

import rpg_terminal.entities.creatures.Creature;

public interface Character {
	void attack(Creature other);

	void specialAttack();
}
