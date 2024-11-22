package entities;

public class Creature{
    public String name;
    public int life;
    public int attack;
    public int mana;
    public int defense;
    public int speed;
    public int luck;

    public Creature(
        String name,
        int life,
        int attack,
        int mana,
        int defense,
        int speed,
        int luck
    ) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.luck = luck;
    }
    public String getInfo() {
        return "";
    }
}