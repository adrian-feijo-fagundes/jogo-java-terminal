/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.scene;

import terminalrpg.entities.Entity;
import terminalrpg.entities.creatures.Player;
import terminalrpg.managers.PlayerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import terminalrpg.utils.GameState;
import terminalrpg.utils.Message;
import terminalrpg.utils.Option;

/**
 *
 * @author Adrian
 */
public class Scene extends Entity {
    private final List<String> messages;
    private final List<String> firstMessages;
    private final List<Option> options;

    private String neededItem;
    private String neededItemMessage;

    public Scene(String name) {
        super(name);
        this.messages = new ArrayList<>();
        this.firstMessages = new ArrayList<>();
        this.options = new ArrayList<>();
        this.neededItem = "";
    }



    public void setNeededItem(String neededItem) {
        this.neededItem = neededItem;
    }

    public String getNeededItemMessage() {
        return neededItemMessage;
    }

    public void setNeededItemMessage(String neededItem) {
        this.neededItemMessage = neededItem;
    }

    public List<Option> getOptions() {
        return options;
    }

    public Scene getLastScene() {
        return this.getOptions().get(this.getOptions().size() - 1).nextScene();
    }

    public void addOption(String optionDescription, Scene nextScene) {
        this.options.add(new Option(optionDescription, nextScene));
    }

    public void addMessages(String[] newMessages) {
        this.messages.addAll(Arrays.asList(newMessages));
    }

    public boolean isFirstVisit(GameState gameState) {
        return !gameState.hasVisited(this.getId());
    }

    public void addFirstMessages(String[] newFirstMessages) {
        this.firstMessages.addAll(Arrays.asList(newFirstMessages));
    }

    public List<String> currentMessages(boolean isFirstVisit) {
        return isFirstVisit ? this.firstMessages : this.messages;
    }

    public void showMessages(Scanner sc, List<String> currentMessages) {
        for (String currentMessage : currentMessages) {
            System.out.println(currentMessage + "\n");
            Message.enter("");
            sc.nextLine();// Aguarda o jogador pressionar Enter

        }
    }

    public boolean dontHaveItem(Player player) {
        if (this.neededItem == null || this.neededItem.isEmpty()) {
            return false;
        }
        return !player.includes(this.neededItem);
    }

    public Scene showOptions(Scanner sc, PlayerManager playerManager, List<String> currentMessages) {
        if (!this.options.isEmpty()) {
            // Captura e valida a escolha do jogador
            int choice;
            while (true) {
                System.out.println("\nO que você deseja fazer?");
                for (int i = 0; i < this.options.size(); i++) {
                    System.out.printf("%d. %s\n", i + 1, this.options.get(i).description());
                }
                System.out.println("0. ver menu informativo\n ");
                System.out.print("\nEscolha uma opção: ");
                choice = sc.nextInt();

                if (choice > 0 && choice <= this.options.size()) {
                    break;
                } else if (choice == 0) {
                    playerManager.menu(sc, currentMessages.get(currentMessages.size() - 1));
                } else {
                    System.out.println("Escolha uma opção válida");
                }

            }
            // Retorna a próxima cena conforme a escolha
            return this.options.get(choice - 1).nextScene();
        }
        System.out.println("\nNão há mais opções nesta cena. Fim de jogo.");
        return null;
    }

    public Scene startEvent(Scanner sc, Player player, GameState gameState, PlayerManager playerManager) {
        if (dontHaveItem(player)) {
            System.out.println(neededItemMessage);
            Message.enter("Para voltar");
            sc.nextLine();
            return getLastScene();
        }

        showMessages(sc, currentMessages(isFirstVisit(gameState)));
        // Marca a cena como visitada no GameState
        if (isFirstVisit(gameState)) {
            gameState.addToVisited(this.getId());
        }
        // Exibe as opções disponíveis
        return showOptions(sc, playerManager, currentMessages(isFirstVisit(gameState)));
    }

}
