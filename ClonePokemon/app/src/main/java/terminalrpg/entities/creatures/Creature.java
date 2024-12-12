/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.creatures;

import terminalrpg.entities.interfaces.CreatureInterface;
import java.util.Scanner;

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
    private int mana;
    private int totalDefense;
    private int totalSpeed;
    
    public Creature(
            int mana,
            String type,
            int life,
            int attack,
            int speed,
            int luck,
            String name) {
        super(name);
        this.mana       = mana;
        this.type       = type;
        this.life       = life;
        this.attack     = attack;
        this.speed      = speed;
        this.luck       = luck;
        totalDefense    = 0;
        totalSpeed      = speed;
       
    }
    
    public String  getType()             { return type;                         }
    public String  getTypeName()         { return type + " " + this.getName();  }
    public int     getMana()             { return mana;                         }
    public void    setMana(int mana)     { this.mana = mana;                    }
    public int     getLife()             { return life;                         }
    public void    setLife(int life)     { this.life = life;                    }
    public int     getAttack()           { return attack;                       }
    public void    setAttack(int attack) { this.attack = attack;                }
    public int     getSpeed()            { return speed;                        }
    public void    setSpeed(int speed)   { this.speed = speed;                  }
    public int     getLuck()             { return luck;                         }
    public void    setLuck(int luck)     { this.luck = luck;                    }
    
    public int     getTotalDefense()                { return totalDefense;            }
    public void    setTotalDefense(int defense)     { this.totalDefense = defense;    }
    public int     getTotalSpeed()                  { return totalSpeed;              }
    public void    setTotalSpeed(int speed)         { this.totalSpeed = speed;        }

    public boolean isDead() {
        return this.getLife() < 0;
    }

    @Override
    public boolean evade(Scanner sc, int difficult) {
        int dodgeChance = 100 - (((int) (this.luck * 0.4)) + ((int) (this.speed * 0.6)) - difficult);
        int result = (int) (Math.random() * 100) + 1;
        boolean dodge = result >= dodgeChance;

        if (dodge) {
            System.out.println(this.getTypeName() + " Conseguiu esquivar!");
        } else {
            System.out.println(this.getTypeName() + " Não conseguiu esquivar!");
        }
        return dodge;
    }

    @Override
    public int criticalHit(Scanner sc) {
        int randomValue = (int) (Math.random() * 100) + 1;

        if (randomValue <= this.luck) {
            return 2; // Multiplicador crítico
        }
        return 1; // Ataque normal
    }

    public boolean attackPriority(Creature other) {
        return this.speed > other.getTotalSpeed();
    }

    protected int calcDifficult() {
        return ((int) (this.luck * 0.5)) + ((int) (this.speed * 0.5));
    }
 
    @Override
    public void attack(Scanner sc, Creature other) {
        System.out.println(this.getTypeName() + "Começou a atacar!\n");
        // Verifica se o oponente esquivou
        if (other.evade(sc ,this.calcDifficult())) {
            return;
        }
        int critical = this.criticalHit(sc);
        
        if (critical > 1) {
            System.out.println("Acertou um ataque crítico");
        }

        int damage = (this.attack * critical) - other.getTotalDefense();
        System.out.println("O dano total é de: " +  damage);
        int newLife = other.getLife() -  damage;
        System.out.println("A vida de " + other.getTypeName() + " foi de " + other.getLife() + " para " + newLife);

        other.setLife(newLife);
        
    }

}
