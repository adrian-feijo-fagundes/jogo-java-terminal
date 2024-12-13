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
public interface PlayerInterface {
    public void useItem(Scanner sc);

    public void useSpecialAbility(Scanner sc, Creature other);

    public boolean flee(Scanner sc);
}
