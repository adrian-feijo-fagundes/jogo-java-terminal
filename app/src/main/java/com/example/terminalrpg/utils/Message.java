/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.utils;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public abstract class Message {
    public static void enter(String message) {
        if ("".equals(message)) {
            System.out.println("Pressione enter...");
        } else {
            System.out.println("Pressione enter " + message);
        }

    }
    public static void dice(Scanner sc, int timesToRoll) {
        System.out.println("Voce deverá rolar o dado " + timesToRoll + " Vezes.");
        Message.enter("");
        sc.nextLine();
    }
}
