/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalrpg.entities.scene;

import java.util.Scanner;
import terminalrpg.entities.creatures.Player;
import terminalrpg.entities.itens.Item;
import terminalrpg.utils.GameState;
import terminalrpg.utils.Message;

/**
 *
 * @author Adrian
 */
public class Reward extends Scene {
    private Item reward;

    public Reward(String name) {
        super(name);
    }

    public Item getReward() {
        return reward;
    }

    public void setReward(Item reward) {
        this.reward = reward;
    }
    
    @Override
    public Scene startEvent(Scanner sc, Player player, GameState gameState) {

        showMessages(sc, currentMessages(isFirstVisit(gameState)));
        // Marca a cena como visitada no GameState
        if (isFirstVisit(gameState)) {
            player.addItem(reward);
            System.out.println(reward.getDescription() + "\n");
            gameState.addToVisited(this.getId());
        }
        System.out.println(this.getOptions().get(0).description());
        Message.enter("");
        sc.nextLine();
        // Continua automaticamente para a próxima cena
        return this.getOptions().get(0).nextScene();

    }
    
    
    
}
