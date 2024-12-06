## **Classes**

### **Entity** (_Classe base para qualquer coisa que exista no jogo._)

- **Creature (extends Entity)** (_Representa seres vivos ou entidades com status_)
  - **Player (extends Creature)** (_O personagem controlado pelo jogador_)
  - **Enemy (extends Creature)** (_Entidades adversárias do jogador_)
- **Item (extends Entity)**

Representa objetos que podem ser coletados, equipados ou usados no jogo.

---

### **Scene (extends Entity)** (_Representa eventos ou momentos no jogo._)

- **Combat (extends Scene)** (_Cena de batalha_)
- **Reward (extends Scene)** (_Cena onde o jogador recebe itens ou benefícios_)
- **Trade (extends Scene)** (_Cena de negociação ou troca de itens_)

## **Interfaces**

- **ICreature** (_Criatura_)  
  Define métodos e propriedades que **Player** e **Enemy** devem implementar.

- **IPlayer** (_Jogador_)  
  Define funcionalidades exclusivas do jogador.

- **Item** (_Item_)
