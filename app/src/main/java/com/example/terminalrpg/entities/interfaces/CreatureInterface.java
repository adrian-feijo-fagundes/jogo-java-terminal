/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.terminalrpg.entities.interfaces;

/**
 *
 * @author Adrian
 */
public interface CreatureInterface {
    public void attack(CreatureInterface other);
    public boolean evade();
    public boolean criticalHit();
}
