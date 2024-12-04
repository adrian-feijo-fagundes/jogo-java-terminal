package rpg_terminal.utils;

import java.util.HashSet;
import java.util.Set;

public class GameState {

    private Set<String> visited;
    private Set<String> obtainedItens;
    private Set<String> defeatedEnemies;

    public GameState() {
        this.visited = new HashSet<>();
        this.obtainedItens = new HashSet<>();
        this.defeatedEnemies = new HashSet<>();
    }

    // Métodos para manipular as cenas visitadas
    public boolean hasVisited(String sceneName) {
        return visited.contains(sceneName);
    }

    public void addToVisited(String sceneName) {
        visited.add(sceneName);
    }

    // Métodos para manipular os itens obtidos
    public boolean hasItem(String item) {
        return obtainedItens.contains(item);
    }

    public void addItem(String item) {
        obtainedItens.add(item);
    }

    // Métodos para manipular inimigos derrotados
    public boolean defeatEnemy(String inimigo) {
        return defeatedEnemies.contains(inimigo);
    }

    public void addDefeatedEnemy(String inimigo) {
        defeatedEnemies.add(inimigo);
    }

    // Método para exibir o estado atual (opcional, para depuração)
    public void showState() {
        System.out.println("Cenas visitadas: " + visited);
        System.out.println("Itens obtidos: " + obtainedItens);
        System.out.println("Inimigos derrotados: " + defeatedEnemies);
    }
}
