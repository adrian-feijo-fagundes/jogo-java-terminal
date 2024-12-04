package rpg_terminal;

import java.util.List;
import java.util.Scanner;

import rpg_terminal.entities.scenarios.Scene;

public class TestingScenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Scene s1 = new Scene(List.of(
                "Você desperta lentamente, sentindo o chão frio e áspero contra sua pele. \nSeus músculos estão rígidos, como se tivessem sido congelados no tempo.",
                "O ambiente está escuro, mas seus olhos conseguem distinguir os contornos de \numa pequena sala de pedra. Não há janelas, apenas paredes desgastadas e uma \núnica porta à sua frente.",
                "Sua mente está um turbilhão. Não há lembranças de como chegou aqui, mas uma \ncoisa é clara: você precisa sair. Algo neste lugar não parece certo."));

        System.out.println("");

        s1.startEvent(sc, null);

        sc.close();
    }
}
