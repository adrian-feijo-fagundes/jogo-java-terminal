package rpg_terminal.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.entities.scenes.Scene;

public class Scenes {
    private List<Scene> scenes; // Lista que armazena todas as cenas
    private Scene currentScene; // Cena atual que está sendo exibida

    public Scenes() {
        scenes = new ArrayList<>();
        initializeScenes(); // Método para inicializar as cenas
    }

    // Método para inicializar todas as cenas
    private void initializeScenes() {
        Scene salaInicial = new Scene();
        Scene salaInicialInvestigar = new Scene();
        Scene salaInicialRecompensa = new Scene();
        Scene salaPrincipal = new Scene();
        Scene salaPrincipalPortas = new Scene();
        Scene homemMisterioso = new Scene();

        // QUARTO INICIAL
        salaInicial.addOption("Abrir a porta", salaPrincipal);
        salaInicial.addOption("Investigar o quarto", salaInicialInvestigar);

        salaInicialInvestigar.addOption("Abrir caixa", salaInicialRecompensa);
        salaInicialInvestigar.addOption("Abrir a porta", salaPrincipal);

        salaInicialRecompensa.addOption("Abrir a porta", salaPrincipal);

        // SALA PRINCIPAL
        salaPrincipal.addOption("Voltar para o quarto", salaInicial);
        salaPrincipal.addOption("Ir até as portas", salaPrincipalPortas);
        salaPrincipal.addOption("Conversar com o homem", homemMisterioso);

        salaPrincipalPortas.addOption("Investigar porta a esquerda", homemMisterioso);
        salaPrincipalPortas.addOption("Conversa", homemMisterioso);
        salaPrincipalPortas.addOption("Conversar com o homem", homemMisterioso);

        // Adicionando as cenas na lista
        scenes.add(salaInicial);
        scenes.add(salaPrincipal);
        scenes.add(salaPrincipalPortas);

        // Definindo a cena inicial
        this.currentScene = salaInicial;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, Creature player) {
        while (currentScene != null) {

        }
    }
}