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
import terminalrpg.entities.creatures.Player;
import terminalrpg.entities.itens.Consumable;
import terminalrpg.entities.itens.Equipable;
import terminalrpg.entities.itens.Item;
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
        // Consumable potion = new Consumable("Pocao pequena");
        // Equipable initialWeapon = new Equipable("Espada");
        // initialWeapon.setDescription("Uma espada simples e um pouco velha mas com a lamina mantém o corte");
        // initialWeapon.setBonus(10);
        // itens.put(potion.getName(), potion);
    }
    private void initializeScenes() {
        Scene room1 = new Scene("Sala 01");
        Scene room2 = new Scene("Sala 02");
        Scene room3 = new Scene("Sala 03");
        Scene room4 = new Scene("Sala 04");
        Scene room5 = new Scene("Sala 05");
        
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
        room3.addFirstMessages(new String[] {
            "Primeira vez na sala 03"
        });
        room3.addMessages(new String[] {"Voce entrou na sala 03"});


        //-----------------------------
        room4.addFirstMessages(new String[] {
            "Primeira vez na sala 04"
        });
        room4.addMessages(new String[] {"Voce entrou na sala 04"});

        //-----------------------------
        room5.addFirstMessages(new String[] {
            "Primeira vez na sala 05"
        });
        room5.addMessages(new String[] {"Voce entrou na sala 05"});

        room1.addOption("Ir para sala 2", room2);
        
        room2.addOption("Voltar para sala 1", room1);
        room2.addOption("Ir para sala 3", room2);

        room3.addOption("Voltar para sala 2", room2);
        room3.addOption("Ir para sala 4", room4);

        room4.addOption("Voltar para sala 3", room3);
        room4.addOption("Ir para sala 5", room5);
        
        room5.addOption("Voltar para sala 4", room4);
        // Adicionando as cenas na lista
        scenes.add(room1);
        scenes.add(room2);
        scenes.add(room3);
        scenes.add(room4);
        scenes.add(room5);
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
