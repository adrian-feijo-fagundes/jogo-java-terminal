package rpg_terminal.entities.scenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.creatures.Creature;

public class SceneManager {
    private List<Scene> scenes; // Lista que armazena todas as cenas
    private Scene currentScene; // Cena atual que está sendo exibida

    public SceneManager() {
        scenes = new ArrayList<>();
        initializeScenes(); // Método para inicializar as cenas
    }

    // Método para inicializar todas as cenas
    private void initializeScenes() {
        Scene cenaInicial = new Scene(List.of(
                "Você acorda em uma sala escura, sem lembrar como chegou aqui.",
                "O chão é frio, e a única saída parece ser uma porta à frente."));

        Scene cenaExploracao = new Scene(List.of(
                "Você decide explorar a sala e encontra símbolos estranhos nas paredes.",
                "Eles parecem te observar de volta."));

        Scene cenaPorta = new Scene(List.of(
                "Você abre a porta e encontra um corredor escuro.",
                "O ar é pesado e há um silêncio perturbador."));

        Scene cenaFinal = new Scene(List.of(
                "Você chegou ao fim do corredor e encontra uma saída. O jogo terminou.",
                "Parabéns, você completou a jornada!"));

        // Adicionando opções para as cenas
        cenaInicial.addOption("Explorar a sala", cenaExploracao);
        cenaInicial.addOption("Abrir a porta", cenaPorta);

        cenaExploracao.addOption("Examinar os símbolos", cenaPorta);
        cenaExploracao.addOption("Voltar para a sala inicial", cenaInicial);

        cenaPorta.addOption("Entrar no corredor", cenaFinal);
        cenaPorta.addOption("Voltar para a sala inicial", cenaInicial);

        // Adicionando as cenas na lista
        scenes.add(cenaInicial);
        scenes.add(cenaExploracao);
        scenes.add(cenaPorta);
        scenes.add(cenaFinal);

        // Definindo a cena inicial
        this.currentScene = cenaInicial;
    }

    // Método para navegar pela cena atual e para a próxima cena
    public void startGame(Scanner sc, Creature player) {
        while (currentScene != null) {
            currentScene = currentScene.startEvent(sc, player); // Atualiza a cena atual com a próxima cena
        }
    }
}
