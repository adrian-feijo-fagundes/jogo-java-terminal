/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities;

/**
 *
 * @author Adrian
 */
public abstract class Entity {
    private static int idCounter = 0;
    private final int id;
    private String name;

    public Entity(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int    getId()               { return id;        }
    public String getName()             { return name;      }
    public void   setName(String name)  { this.name = name; }
}
