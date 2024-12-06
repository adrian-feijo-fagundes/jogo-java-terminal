/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.example.terminalrpg.entities.scene;

/**
 *
 * @author Adrian
 */
public record Option(String description, Scene nextScene, String firstMessage, String message) {
}
