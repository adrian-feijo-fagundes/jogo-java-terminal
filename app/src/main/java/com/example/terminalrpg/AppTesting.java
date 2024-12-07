/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg;

import com.example.terminalrpg.managers.Scenes;
import com.example.terminalrpg.utils.GameState;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class AppTesting {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            GameState state = new GameState();
            Scenes game = new Scenes();

            game.startGame(sc, null, state);
        }
    }
}
