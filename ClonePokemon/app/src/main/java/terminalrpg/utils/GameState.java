/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.utils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Adrian
 */
public class GameState {
    private final Set<Integer> visited;
    private final Set<Integer> obtainedItens;
    private final Set<Integer> defeatedEnemies;

    public GameState() {
        this.visited = new HashSet<>();
        this.obtainedItens = new HashSet<>();
        this.defeatedEnemies = new HashSet<>();
    }

    // Métodos para manipular as cenas visitadas
    public boolean hasVisited(int sceneName) {
        return visited.contains(sceneName);
    }

    public void addToVisited(int sceneName) {
        visited.add(sceneName);
    }

    // Métodos para manipular os itens obtidos
    public boolean hasItem(int item) {
        return obtainedItens.contains(item);
    }

    public void addItem(int item) {
        obtainedItens.add(item);
    }

    // Métodos para manipular inimigos derrotados
    public boolean defeatEnemy(int inimigo) {
        return defeatedEnemies.contains(inimigo);
    }

    public void addDefeatedEnemy(int inimigo) {
        defeatedEnemies.add(inimigo);
    }

    // Método para exibir o estado atual (opcional, para depuração)
    public void showState() {
        System.out.println("Cenas visitadas: " + visited);
        System.out.println("Itens obtidos: " + obtainedItens);
        System.out.println("Inimigos derrotados: " + defeatedEnemies);
    }
}
