/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures.playable;

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
                mana,
                "Archer",
                life,
                attack,
                speed,
                luck,
                name);
    }

}
