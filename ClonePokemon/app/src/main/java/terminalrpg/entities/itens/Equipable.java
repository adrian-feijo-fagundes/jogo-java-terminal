/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.itens;

/**
 *
 * @author Adrian
 */
public class Equipable extends Item {
    private String equipType;
    private int bonusAttack;
    private int bonusDefense;
    private int bonusMana;
    private int bonusSpeed;
    private int bonusLuck;

    public Equipable(
            String equipType,
            String name,
            int bonusAttack,
            int bonusDefense,
            int bonusMana,
            int bonusSpeed,
            int bonusLuck) {
        super(name);
        this.bonusAttack = bonusAttack;
        this.bonusDefense = bonusDefense;
        this.bonusMana = bonusMana;
        this.bonusSpeed = bonusSpeed;
        this.bonusLuck = bonusLuck;

    }

    public String getEquipType() {
        return equipType;
    }

    public void setType(String equipType) {
        this.equipType = equipType;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }

    public void setBonusAttack(int attack) {
        this.bonusAttack = attack;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public void setBonusDefense(int defense) {
        this.bonusDefense = defense;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public void setBonusMana(int mana) {
        this.bonusMana = mana;
    }

    public int getBonusSpeed() {
        return bonusSpeed;
    }

    public void setBonusSpeed(int speed) {
        this.bonusSpeed = speed;
    }

    public int getBonusLuck() {
        return bonusLuck;
    }

    public void setBonusLuck(int luck) {
        this.bonusLuck = luck;
    }

}
