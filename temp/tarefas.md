
Criação da História
Sistema de Itens
Sistema de Combate

Condições para certas ocasioes

Quais são os possiveis cenários

Primeira visita atendendo os pre-requisitos
Primeira visita atendendo os pre-requisitos
Visitas Posteriores não atendendo os pre-requisitos
Visitas Posteriores não atendendo os pre-requisitos


Mensagens para primeira visita
Mensagens para visitas posteriores

Mensagens atendendo os requisitos

Como eu posso estruturar isso para ter menos trabalho?

Ter cena especifica para atender condições
ou escolhas necessitarem de condição

Criar cenas que só são acessadas caso as condições das opções sejam atendidas

Primeiro:

 Sistema de Itens
 Opções com requisitos
    Como podem ser feitos os requisitos?
        Acessando o nome do item

 Cena de Troca
    Personagem possuir item e receber outro item
 Cena de recompensa
    Personagem receber item

Primeiros cenarios para construir

    - Personagem acordando no quarto
    - Personagem explorando o quarto e recebendo recompensa
        - Recompensa não precisa ter condição
        - Apenas mensagem da primeira visita e visitas posteriores
            - Primeira visita obtem item
            - Outras visitas não obtem nada
        metodo: ReceiveItem(), addItem()
    - Personagem saindo do quarto