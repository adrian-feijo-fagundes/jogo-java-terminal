package entities;

public class Creature{
    public int life;
    public int attack;
    public int mana;
    public int defense;
    public int speed;
    public int luck;

    public Creature(int[] attributes) {
        this.life = attributes[0];
        this.attack = attributes[1];
        this.mana = attributes[2];
        this.defense = attributes[3];
        this.speed = attributes[4];
        this.luck = attributes[5];
    }

}