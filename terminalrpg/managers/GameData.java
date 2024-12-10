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
import terminalrpg.entities.scene.Reward;
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
        Consumable potion = new Consumable("Pocao pequena");
        Equipable initialWeapon = new Equipable("Espada");
        initialWeapon.setDescription("Uma espada simples e um pouco velha mas com a lamina mantém o corte");
        initialWeapon.setBonus(10);
        itens.put(potion.getName(), potion);
    }
    private void initializeScenes() {
        Scene quartoInicial = new Scene("Quarto Inicial");
        Scene quartoInicialInvestigar = new Scene("Quarto Inicial Investigar");
        Reward quartoInicialRecompensa = new Reward("Quarto Inicial Recompensa");
        quartoInicialRecompensa.setReward(itens.get(""));
        
        Scene corredor = new Scene("Corredor");
        Scene corredorNpc = new Scene("Joseph");
        
        Scene salaUm = new Scene("Sala 01");
        Scene salaUmInimigo = new Scene("Sala 01 Inimigo");
        
        Reward recompensaItem = new Reward("Sala 01 Recompensa");
        
        
        Scene recompensaChave = new Reward("Sala 01 Recompensa Chave");
        
        Scene salaDois = new Scene("Sala 02");
        Scene salaDoisInimigo = new Scene("Sala 02 Inimigo");
        
        Scene recompensaChaveSaida = new Reward("Sala 02 Recompensa Chave Saída");    
        
        Scene saida = new Scene("Saida");
        
        quartoInicial.addFirstMessages(new String[] {
            "Você desperta no chão frio de um quarto vazio. Suas roupas estão sujas de poeira, e sua cabeça\ndói como se tivesse levado um golpe.",
            "Não há móveis, apenas uma porta velha e trincada à sua frente. \nO silêncio é absoluto, exceto pelo som distante de algo pingando."
        });
        
        quartoInicial.addMessages(new String[] {
            "Você está ", 
            "Realmente não é um ambiente agradavel"
        });
        
        quartoInicialInvestigar.addFirstMessages(new String[] {
            "Enquanto seus olhos se ajustam à penumbra, você nota alguns panos jogados em um canto do quarto. \nEles parecem deslocados, mas nada mais chama atenção à primeira vista.",
            "Você revira os panos no canto e descobre uma pequena caixa de madeira, parcialmente coberta de \npoeira. A tampa está solta, como se alguém tivesse esquecido de fechá-la completamente."
        });
        quartoInicialInvestigar.addMessages(new String[] {
            "Além da Caixa não existe mais nada que pareça ser útil aqui",
            "O cheiro aqui é nojento"
        });
        
        quartoInicialRecompensa.addFirstMessages(new String[] {
            "Ao abrir a caixa, você nota que tem algo ali"
        });
        
        quartoInicialRecompensa.addMessages(new String[] {
            "Não tem mais nada nessa caixa que droga",
            "...Oh",
            "Um bilhete",
            "...você tem sorte de não estar sozinho."
        });
  
        quartoInicialRecompensa.addOption("Você fecha a caixa novamente", quartoInicialInvestigar);
        
        corredor.addFirstMessages(null);
        corredorNpc.addFirstMessages(null);
        
        salaUm.addFirstMessages(null);
        salaUmInimigo.addFirstMessages(null);
        recompensaItem.addFirstMessages(null);
        recompensaChave.addFirstMessages(null);
        salaDois.addFirstMessages(null);
        salaDoisInimigo.addFirstMessages(null);
        recompensaChaveSaida.addFirstMessages(null);
        saida.addFirstMessages(null);



        corredor.addOption("Tentar abrir a porta", salaUm);

        // Adicionando as cenas na lista
        scenes.add(quartoInicial);
        // Definindo a cena inicial
        this.currentScene = quartoInicial;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, Player player, GameState state) {
        while (currentScene != null) {
            System.out.println(currentScene.getId() + " " + currentScene.getName());
            currentScene = currentScene.startEvent(sc, player, state);
        }
    }
}
