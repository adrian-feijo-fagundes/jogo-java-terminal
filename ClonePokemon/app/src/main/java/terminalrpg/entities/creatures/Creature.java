/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.CreatureInterface;
import terminalrpg.utils.Dice;
import terminalrpg.entities.Entity;

/**
 *
 * @author Adrian
 */
public class Creature extends Entity implements CreatureInterface {
    private String type;
    private int life;
    private int attack;
    private int speed;
    private int luck;

    public Creature(
            String type,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {

        super(name);
        this.type = type;
        this.life = life;
        this.attack = attack;
        this.speed = speed;
        this.luck = luck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    @Override
    public void attack(Creature other) {
        int critical = this.criticalHit();

        // Verifica se o oponente esquivou
        if (other.evade(this.calcDifficult())) {
            return;
        }
        int damage = this.attack * this.criticalHit();
        int newLife = other.getLife() - damage;
        other.setLife(newLife);

        if (critical > 1) {
            System.out.println("Acertou um ataque crítico");
        }
    }

    @Override
    public boolean evade(int difficult) {
        int dodgeChance = 100 - (((int) (this.luck * 0.4)) + ((int) (this.speed * 0.6)) - difficult);

        int result = Dice.percent();

        System.out.println("Para desviar do golpe era necessário conseguir pelo menos " + dodgeChance + " pontos");

        boolean dodge = result >= dodgeChance;

        if (dodge) {
            System.out.println(this.getId() + "Conseguiu esquivar!");
        } else {
            System.out.println(this.getId() + "Não conseguiu esquivar!");
        }
        return dodge;
    }

    @Override
    public int criticalHit() {
        int randomValue = Dice.percent();

        if (randomValue <= this.luck) {
            return 2; // Multiplicador crítico
        }
        return 1; // Ataque normal
    }

    public boolean attackPriority(Creature other) {
        return this.speed > other.speed;

    }

    private int calcDifficult() {
        return ((int) (this.luck * 0.5)) + ((int) (this.speed * 0.5));
    }

    public String getInfo() {
        return String.format(
                "\nid: %d\nNome: %s\nHP: %d\nAtaque: %d\nVelocidade: %d\nSorte: %d",
                this.getId(),
                this.getName(),
                this.life,
                this.attack,
                this.speed,
                this.luck);
    }
}
