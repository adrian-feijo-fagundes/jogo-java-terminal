/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.scene;

import terminalrpg.entities.Entity;
import terminalrpg.entities.creatures.Player;
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

    public Scene(String name) {
        super(name);
        this.messages = new ArrayList<>();
        this.firstMessages = new ArrayList<>();
        this.options = new ArrayList<>();
    }

    public String getNeededItem() {
        return neededItem;
    }

    public void setNeededItem(String neededItem) {
        this.neededItem = neededItem;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(String optionDescription, Scene nextScene) {
        this.options.add(new Option(optionDescription, nextScene));
    }

    public void addMessages(String[] newMessages) {
        this.messages.addAll(Arrays.asList(newMessages));
    }

    public void addFirstMessages(String[] newFirstMessages) {
        this.firstMessages.addAll(Arrays.asList(newFirstMessages));
    }
    public List<String> currentMessages(boolean isFirstVisit) {
        return isFirstVisit ? this.firstMessages : this.messages;
    }
    public boolean isFirstVisit(GameState gameState) {
        return !gameState.hasVisited(this.getId());
    }
    public void showMessages(Scanner sc, List<String> currentMessages) {

        for (int i = 0; i < currentMessages.size(); i++) {

            if (i < currentMessages.size() - 1) {
                System.out.println(currentMessages.get(i) + "\n");

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

        showMessages(sc, currentMessages(isFirstVisit(gameState)));
        // Marca a cena como visitada no GameState
        if (isFirstVisit(gameState)) {
            gameState.addToVisited(this.getId());
        }
        // Exibe as opções disponíveis
        Scene nextScene = showOptions(sc);
        return nextScene;
        // Caso não haja opções

    }
    public boolean haveItem(Player player, Option option) {
        return null != player.getItem(this.neededItem);
    }
}
