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
import terminalrpg.entities.scene.Scene;
import terminalrpg.utils.GameState;

/**
 *
 * @author Adrian
 */
public class GameData {

    private final List<Scene> scenes; // Lista que armazena todas as cenas
    private final Map<String ,Item> itens; // Lista que armazena todas as cenas
    private Scene currentScene; // Cena atual que está sendo exibida

    public GameData() {
        scenes = new ArrayList<>();
        itens = new HashMap<>();
        initializeScenes(); // Método para inicializar as cenas
        initializeItens();
    }

    // Método para inicializar todas as cenas
    private void initializeItens() {               
        Consumable potion = new Consumable("Pocao de Vida", "life", 5);
        Equipable initialWeapon = new Equipable("Warrior",
            null,
            null,
            10,
            0,
            0,
            0,
            0);
        initialWeapon.setDescription("Uma espada simples e um pouco velha mas com a lamina mantém o corte");
        
        itens.put(potion.getName(), potion);
    }
    private void initializeScenes() {
        Scene gameOver = new Scene("Game over");
        gameOver.addFirstMessages(new String[] {
            "GAME OVER",
            "NÃO FOI DESSA VEZ BOA SORTE NA PRÓXIMA"
        });
        Scene room1 = new Scene("Sala 01");
        Scene room2 = new Combat("Sala 02",
            new Enemy(0, "Goblin", 30, 5, 5, 5, "Pequeno")
            ,gameOver);
        //-----------------------------
        room1.addFirstMessages(new String[] {
            "Primeira vez na sala 01"
        });
        room1.addMessages(new String[] {"Voce entrou na sala 01"});


        //-----------------------------
        room2.addFirstMessages(new String[] {
            "Primeira vez na sala 02"
        });
        room2.addMessages(new String[] {"Voce entrou na sala 02"});


        //-----------------------------

        room1.addOption("Ir para sala 2", room2);
        
        room2.addOption("Voltar para sala 1", room1);
        
        // Adicionando as cenas na lista
        scenes.add(room1);
        scenes.add(room2);

        // Definindo a cena inicial
        this.currentScene = room1;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, GameState state, PlayerManager playerManager) {
        while (currentScene != null) {
            System.out.println("-----------------\n");            
            currentScene = currentScene.startEvent(sc, playerManager.player, state, playerManager);
        }
    }
}
