/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package terminalrpg.entities.interfaces;

import java.util.Scanner;

import terminalrpg.entities.creatures.Creature;

/**
 *
 * @author Adrian
 */
public interface CreatureInterface {
    public void attack(Scanner sc, Creature other);

    public boolean evade(Scanner sc, int difficult);

    public int criticalHit(Scanner sc);
}
