package terminalrpg.entities.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.example.terminalrpg.entities.creatures.Player;

import terminalrpg.entities.Entity;
import terminalrpg.utils.GameState;
import terminalrpg.utils.Option;

public class Event extends Entity {
    private Map<String, String> messages;
    private List<Option> options;
    private String neededItem;

    public Event(String name) {
        super(name);
        this.messages = new HashMap<>();
        this.options = new ArrayList<>();
    }

    public Scene showMessages () {
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
    };
    public void showOptions () {};


    public Event start(Scanner sc, Player player, GameState gameState) {
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
}
