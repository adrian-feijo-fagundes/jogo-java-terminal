/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.EnemyInterface;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.entities.itens.Item;

/**
 *
 * @author Adrian
 */
public class Enemy extends Creature implements EnemyInterface {
    private Item drop;
    private Equipable dropMage;
    private Equipable dropWarrior;
    private Equipable dropArcher;

    public Enemy(
            String type,
            String name,
            int mana,
            int life,
            int attack,
            int speed,
            int luck) {
        super(
                mana,
                type,
                life,
                attack,
                speed,
                luck,
                name);
        this.drop = null;
    }

    public void setDrop(Item drop) {
        this.drop = drop;
    }

    public void setDropEquipment(Equipable drop) {
        switch (drop.getEquipType()) {
            case "Mage" -> {
                this.dropMage = drop;
            }
            case "Warrior" -> {
                this.dropWarrior = drop;
            }
            case "Archer" -> {
                this.dropMage = drop;
            }
        }
    }

    @Override
    public void drop(Player player) {
        if (this.drop == null)
            return;

        switch (player.getType()) {
            case "Mage" -> {
                player.addEquipment(dropMage);
            }
            case "Warrior" -> {
                player.addEquipment(dropWarrior);
            }
            case "Archer" -> {
                player.addEquipment(dropArcher);
            }
        }
        System.out.println("O item " + this.drop.getName() + " foi encontrado!");
        player.addItem(drop);
    }
}
