/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import terminalrpg.entities.creatures.Enemy;
import terminalrpg.entities.itens.Consumable;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.entities.itens.Item;
import terminalrpg.entities.scene.Combat;
import terminalrpg.entities.scene.Reward;
import terminalrpg.entities.scene.Scene;
import terminalrpg.utils.GameState;

/**
 *
 * @author Adrian
 */
public class GameData {

    private final List<Scene> scenes; // Lista que armazena todas as cenas
    private final Map<String, Item> itens; // Lista que armazena todas os itens
    private Scene currentScene; // Cena atual que está sendo exibida
    private final Map<String, Enemy> enemies; // armazena todos os inimigos
    private final Map<String, Equipable> equipables; // Equipaveis

    public GameData() {
        scenes = new ArrayList<>();
        itens = new HashMap<>();
        enemies = new HashMap<>();
        equipables = new HashMap<>();
        initializeEquipables();
        initializeScenes(); // Método para inicializar as cenas
        initializeItens();
        initializeEnemies();
    }

    private void initializeEquipables() {
        Equipable initialWarriorItem = new Equipable("Warrior", "Espada enferrujada", 10, 0, 0, 0, 0);
        Equipable initialMageItem = new Equipable("Mage", "Cajado Arcano", 5, 0, 2, 2, 0);
        Equipable initialArcherItem = new Equipable("Archer", "Arco de Madeira de Lei", 3, 0, 0, 5, 5);

        equipables.put(initialWarriorItem.getName(), initialWarriorItem);
        equipables.put(initialArcherItem.getName(), initialArcherItem);
        equipables.put(initialMageItem.getName(), initialMageItem);
    }

    // Método para inicializar todas as cenas
    private void initializeItens() {
        Consumable potion = new Consumable("Pocao de Vida", "life", 5);
        Consumable elixir = new Consumable("Elixir de Mana", "mana", 5);
        Item chave = new Item("Chave");

        itens.put(potion.getName(), potion);
        itens.put(elixir.getName(), elixir);
        itens.put(chave.getName(), chave);
    }

    private void initializeEnemies() {
        Enemy goblin = new Enemy("Pequeno", "Goblin", 0, 30, 10, 10, 10);
        Enemy aranha = new Enemy("Pequena", "Aranha", 0, 20, 15, 15, 10);
        Enemy esqueleto = new Enemy("Pequeno", "Esqueleto", 30, 60, 30, 5, 0);
        Enemy dragao = new Enemy("Dragao", "Infernal", 0, 1000, 100, 100, 0);

        goblin.setDrop(itens.get("Pocao de Vida"));
        aranha.setDrop(itens.get("Elixir de Mana"));
        esqueleto.setDrop(itens.get("Chave"));
        enemies.put(goblin.getName(), goblin);
        enemies.put(aranha.getName(), aranha);
        enemies.put(esqueleto.getName(), esqueleto);
        enemies.put(dragao.getName(), dragao);
    }

    private void initializeScenes() {
        Scene gameOver = new Scene("Game over");
        gameOver.addFirstMessages(new String[] {
                "GAME OVER",
                "NÃO FOI DESSA VEZ BOA SORTE NA PRÓXIMA"
        });

        Scene saida = new Scene("Saida");
        saida.setNeededItem("Chave Mágica");
        saida.setNeededItemMessage("A porta ainda está trancada preciso encontrar a chave");

        Scene inicio = new Scene("Sala 01");
        Scene salaGoblin = new Combat("Sala 02", enemies.get("Goblin"), gameOver);
        Scene salaAranha = new Combat("Sala 03", enemies.get("Aranha"), gameOver);
        Scene salaEsqueleto = new Combat("Sala 04", enemies.get("Esqueleto"), gameOver);
        Scene salaDragao = new Combat("Sala 05", enemies.get("Dragao"), gameOver);
        // -----------------------------

        inicio.addFirstMessages(new String[] {
                "Voce chega ao local desafio, voce é jogado em uma masmorra \ne a porta atras de voce está fechada. Voce deve sair da masmorra",

                "Voce olha ao redor e além da saida voce ve apenas outra porta."
        });
        inicio.addMessages(new String[] { "Voce olha novamente as portas da primeira sala" });

        // -----------------------------
        salaGoblin.addFirstMessages(new String[] {
                "Voce olhar ao redor e duas novas portas surgem"
        });
        salaGoblin.addMessages(new String[] { "Voce volta para sala onde encontrou seu primeiro inimigo" });

        // -----------------------------
        salaAranha.addFirstMessages(new String[] {
                "Voce olhar ao redor e a sala está vazia ela não tem saida"
        });
        salaAranha.addMessages(new String[] { "Voce volta o ninho da aranha parece que não tem mais nada aqui" });

        salaEsqueleto.addFirstMessages(new String[] {
                "Voce olhar ao redor e tem apenas uma porta"
        });

        salaAranha.addMessages(new String[] { "Voce volta o covil parece que não tem mais nada aqui" });

        // ---------------------------------
        inicio.addOption("Abrir a porta e ir para outra sala", salaGoblin);
        inicio.addOption("Tentar sair da masmorra", saida);

        salaGoblin.addOption("Entrar pela primeira porta", salaAranha);
        salaGoblin.addOption("Entrar pela segunda porta", salaEsqueleto);
        salaGoblin.addOption("Voltar para o inicio da masmorra", inicio);

        salaAranha.addOption("Voltar", salaGoblin);

        salaEsqueleto.addOption("Entrar na porta", salaDragao);
        salaEsqueleto.addOption("Voltar", salaGoblin);

        salaDragao.addOption("Voltar", salaEsqueleto);
        // Adicionando as cenas na lista
        scenes.add(saida);
        scenes.add(inicio);
        scenes.add(salaGoblin);
        scenes.add(salaAranha);
        scenes.add(salaDragao);
        scenes.add(salaEsqueleto);

        // Definindo a cena inicial
        this.currentScene = inicio;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, GameState state, PlayerManager playerManager) {
        while (currentScene != null) {
            System.out.println("-----------------\n");
            currentScene = currentScene.startEvent(sc, playerManager.player, state, playerManager);
        }
    }
}
