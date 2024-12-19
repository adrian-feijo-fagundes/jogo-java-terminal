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
    private final int bonusAttack;
    private final int bonusDefense;
    private final int bonusMana;
    private final int bonusSpeed;
    private final int bonusLuck;

    public Equipable(
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

    public int getBonusAttack() {
        return bonusAttack;
    }
    public int getBonusDefense() {
        return bonusDefense;
    }
    public int getBonusMana() {
        return bonusMana;
    }
    public int getBonusSpeed() {
        return bonusSpeed;
    }
    public int getBonusLuck() {
        return bonusLuck;
    }
}
