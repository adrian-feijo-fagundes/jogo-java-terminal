/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.terminalrpg.managers;

import com.example.terminalrpg.entities.creatures.Player;
import com.example.terminalrpg.entities.scene.Scene;
import com.example.terminalrpg.utils.GameState;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Scenes {

    private final List<Scene> scenes; // Lista que armazena todas as cenas
    private Scene currentScene; // Cena atual que está sendo exibida

    public Scenes() {
        scenes = new ArrayList<>();
        initializeScenes(); // Método para inicializar as cenas
    }

    // Método para inicializar todas as cenas
    private void initializeScenes() {
        Scene quartoInicial = new Scene("Quarto Inicial");
        Scene quartoInicialRecompensa = new Scene("Quarto Inicial Recompensa");

        
        Scene corredor = new Scene("Corredor");
        Scene corredorNpc = new Scene("Joseph");
        
        Scene salaUm = new Scene("Sala 01");
        Scene salaUmInimigo = new Scene("Sala 01 Inimigo");
        Scene recompensaItem = new Scene("Sala 01 Recompensa");
        Scene recompensaChave = new Scene("Sala 01 Recompensa Chave");
        Scene salaDois = new Scene("Sala 02");
        Scene salaDoisInimigo = new Scene("Sala 02 Inimigo");
        Scene recompensaChaveSaida = new Scene("Sala 02 Recompensa Chave Saída");    
        Scene saida = new Scene("Saida");
        
        quartoInicial.addFirstMessages(null);
        quartoInicialRecompensa.addFirstMessages(null);
        
        
        salaUm.addFirstMessages(null);
        salaUmInimigo.addFirstMessages(null);
        recompensaItem.addFirstMessages(null);
        recompensaChave.addFirstMessages(null);
        salaDois.addFirstMessages(null);
        salaDoisInimigo.addFirstMessages(null);
        recompensaChaveSaida.addFirstMessages(null);
        saida.addFirstMessages(null);



        salaInicial.addOption("Tentar abrir a porta", salaPrincipal, "", "");

        // Adicionando as cenas na lista
        scenes.add(salaInicial);
        // Definindo a cena inicial
        this.currentScene = salaInicial;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, Player player, GameState state) {
        while (currentScene != null) {
            currentScene = currentScene.startEvent(sc, player, state);
        }
    }
}
