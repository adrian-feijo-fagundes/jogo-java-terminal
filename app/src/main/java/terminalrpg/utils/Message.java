/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.utils;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public abstract class Message {
    public static void enter( String message) {
        if ("".equals(message)) {
            System.out.print("\033[32m" + "press enter... " + "\033[0m");
        } else {
            System.out.print("\033[0m" + "press enter... " + message + "\033[0m");
        }
    }

    public static void dice(Scanner sc, int timesToRoll) {
        System.out.print("\nVoce devera rolar o dado " + timesToRoll + " Vezes.   ");
        Message.enter( "");
        sc.nextLine();
    }
}
