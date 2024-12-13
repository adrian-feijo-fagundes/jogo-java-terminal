/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.EnemyInterface;
import terminalrpg.entities.itens.Consumable;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.entities.itens.Item;

import java.util.Objects;

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

    public void setDropMage(Equipable drop) {
        this.dropMage = drop;
    }
    public void setDropWarrior(Equipable drop) {
        this.dropWarrior = drop;
    }
    public void setDropArcher(Equipable drop) {
        this.dropArcher = drop;
    }

    @Override
    public void drop(Player player) {
        if (this.drop == null) {
            return;
        }
        if (dropMage != null && Objects.equals(player.getType(), "Mage")) {
            player.addEquipment(dropMage);
        }
        if (dropArcher != null && Objects.equals(player.getType(), "Archer")) {
            player.addEquipment(dropArcher);
        }
        if (dropWarrior != null && Objects.equals(player.getType(), "Warrior")) {
            player.addEquipment(dropWarrior);
        }
        System.out.println("O item " + this.drop.getName() + " foi encontrado!");
        if (drop instanceof Consumable) {
            player.addConsumable((Consumable) drop);
        } else {
            player.addItem(drop);
        }
    }
}
