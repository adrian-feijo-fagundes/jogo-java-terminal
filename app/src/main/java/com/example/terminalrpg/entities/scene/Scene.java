/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.entities.scene;

import com.example.terminalrpg.utils.Option;
import com.example.terminalrpg.entities.Entity;
import com.example.terminalrpg.entities.creatures.Player;
import com.example.terminalrpg.utils.GameState;
import com.example.terminalrpg.utils.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Scene extends Entity {
    private final List<String> messages;
    private final List<String> firstMessages;
    private final List<Option> options;

    public Scene(String name) {
        super(name);
        this.messages = new ArrayList<>();
        this.firstMessages = new ArrayList<>();
        this.options = new ArrayList<>();
    }

    public void addOption(String optionDescription, Scene nextScene, String firstMessage, String message) {
        this.options.add(new Option(optionDescription, nextScene, firstMessage, message));
    }

    public void addMessages(String[] newMessages) {
        this.messages.addAll(Arrays.asList(newMessages));
    }

    public void addFirstMessages(String[] newFirstMessages) {
        this.firstMessages.addAll(Arrays.asList(newFirstMessages));
    }

    public void showMessages(Scanner sc, List<String> currentMessages) {

        for (int i = 0; i < currentMessages.size(); i++) {

            if (i < currentMessages.size() - 1) {
                System.out.println(currentMessages.get(i));
                Message.enter("");
                sc.nextLine();// Aguarda o jogador pressionar Enter
            } else {
                System.out.println(currentMessages.get(i));
            }
        }
    }
    public Scene showOptions(Scanner sc) {
        if (!this.options.isEmpty()) {
            System.out.println("\nO que você deseja fazer?");
            for (int i = 0; i < this.options.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, this.options.get(i).description());
            }

            // Captura e valida a escolha do jogador
            int escolha = -1;
            while (escolha < 1 || escolha > this.options.size()) {
                System.out.print("\nEscolha uma opção: ");
                try {
                    escolha = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    sc.nextLine(); // Limpa a entrada inválida
                    System.out.println("Por favor, insira um número válido.");
                }
            }
            // Retorna a próxima cena conforme a escolha
            return this.options.get(escolha - 1).nextScene();
        }
        System.out.println("\nNão há mais opções nesta cena. Fim de jogo.");
        return null;
    }
    public Scene startEvent(Scanner sc, Player player, GameState gameState) {
        // Verifica se esta cena já foi visitada no GameState
        boolean isFirstVisit = !gameState.hasVisited(this.getId());
        List<String> currentMessages = isFirstVisit ? this.firstMessages : this.messages;

        showMessages(sc, currentMessages);
        // Marca a cena como visitada no GameState
        if (isFirstVisit) {
            gameState.addToVisited(this.getId());
        }

        // Exibe as opções disponíveis
        Scene nextScene = showOptions(sc);

        if (!haveItem()) {
            return null;
        }
        return nextScene;
        // Caso não haja opções

    }
    public boolean haveItem() {
        return true;
    }
}
