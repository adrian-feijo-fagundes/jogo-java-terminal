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
    private final Set<Integer> defeatedEnemies;

    public GameState() {
        this.visited = new HashSet<>();
        this.defeatedEnemies = new HashSet<>();
    }
    // Métodos para manipular as cenas visitadas
    public boolean hasVisited(int sceneName) {
        return visited.contains(sceneName);
    }
    public void addToVisited(int sceneName) {
        visited.add(sceneName);
    }
    // Métodos para manipular inimigos derrotados
    public boolean defeatEnemy(int inimigo) {
        return defeatedEnemies.contains(inimigo);
    }
    public void addDefeatedEnemy(int inimigo) {
        defeatedEnemies.add(inimigo);
    }
}
