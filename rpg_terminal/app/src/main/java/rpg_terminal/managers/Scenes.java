package rpg_terminal.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;
import rpg_terminal.entities.scenes.Scene;
import rpg_terminal.utils.GameState;

public class Scenes {
    private List<Scene> scenes; // Lista que armazena todas as cenas
    private Scene currentScene; // Cena atual que está sendo exibida

    public Scenes() {
        scenes = new ArrayList<>();
        initializeScenes(); // Método para inicializar as cenas
    }

    // Método para inicializar todas as cenas
    private void initializeScenes() {
        Scene salaInicial = new Scene("s001");
        salaInicial.addFirstMessages(new String[] {
                "Você desperta no chão frio de um quarto vazio. Suas roupas estão sujas de poeira, e sua cabeça\ndói como se tivesse levado um golpe.",
                "Não há móveis, apenas uma porta velha e trincada à sua frente. \nO silêncio é absoluto, exceto pelo som distante de algo pingando."
        });
        salaInicial.addMessages(new String[] {
                "Você voltou para o quarto"
        });

        Scene salaInicialInvestigar = new Scene("s002");
        salaInicialInvestigar.addFirstMessages(new String[] {
                "Enquanto seus olhos se ajustam à penumbra, você nota alguns panos jogados em um canto do quarto. \nEles parecem deslocados, mas nada mais chama atenção à primeira vista.",
                "Você revira os panos no canto e descobre uma pequena caixa de madeira, parcialmente coberta de \npoeira. A tampa está solta, como se alguém tivesse esquecido de fechá-la completamente."
        });
        salaInicialInvestigar.addMessages(new String[] {
                "Além da Caixa não existe mais nada que pareça ser útil aqui",
                "O cheiro aqui é nojento"
        });

        Scene salaInicialRecompensa = new Scene("s003");
        salaInicialRecompensa.addFirstMessages(new String[] {
                "Ao abrir a caixa, você encontra uma arma simples, mas robusta, com sinais de uso, como se tivesse \nsido carregada por alguém que a usava regularmente. Embora pareça comum, você sente que ela pode \nser mais do que aparenta."
        });
        salaInicialRecompensa.addMessages(new String[] {
                "Não tem mais nada nessa caixa que droga",
                "...Oh",
                "Um bilhete",
                "...você tem sorte de não estar sozinho."
        });

        Scene salaPrincipal = new Scene("s004");

        Scene salaPrincipalPortas = new Scene("s005");

        Scene homemMisterioso = new Scene("s006");

        // QUARTO INICIAL
        salaInicial.addOption("Tentar abrir a porta", salaPrincipal, "", "");
        salaInicial.addOption("Investigar o quarto", salaInicialInvestigar, "", "");

        salaInicialInvestigar.addOption("Abrir caixa", salaInicialRecompensa, "", "");
        salaInicialInvestigar.addOption("Abrir a porta", salaPrincipal, "", "");

        salaInicialRecompensa.addOption("Abrir a porta", salaPrincipal, "", "");

        // SALA PRINCIPAL
        salaPrincipal.addOption("Voltar para o quarto", salaInicial, "", "");
        salaPrincipal.addOption("Ir até as portas", salaPrincipalPortas, "", "");
        salaPrincipal.addOption("Conversar com o homem", homemMisterioso, "", "");

        salaPrincipalPortas.addOption("Investigar porta a esquerda", homemMisterioso, "", "");
        salaPrincipalPortas.addOption("Investigar porta a direita", homemMisterioso, "", "");
        salaPrincipalPortas.addOption("Conversar com o homem", homemMisterioso, "", "");

        // Adicionando as cenas na lista
        scenes.add(salaInicial);
        scenes.add(salaPrincipal);
        scenes.add(salaPrincipalPortas);

        // Definindo a cena inicial
        this.currentScene = salaInicial;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, Creature player, GameState state) {
        while (currentScene != null) {
            currentScene = currentScene.startEvent(sc, player, state);
        }
    }
}
