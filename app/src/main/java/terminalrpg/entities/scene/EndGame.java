package terminalrpg.entities.scene;

import java.util.Scanner;

import terminalrpg.entities.creatures.Player;
import terminalrpg.managers.PlayerManager;
import terminalrpg.utils.GameState;
import terminalrpg.utils.Message;

public class EndGame extends Scene {
    public EndGame(String name) {
        super(name);
    }

    @Override
    public Scene startEvent(Scanner sc, Player player, GameState gameState, PlayerManager playerManager) {
        if (dontHaveItem(player)) {
            System.out.println(this.getNeededItemMessage());
            Message.enter("Para voltar");
            sc.nextLine();
            return getLastScene();
        }

        showMessages(sc, currentMessages(isFirstVisit(gameState)));

        return null;
    }
}
