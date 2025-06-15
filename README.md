# Jogo de Damas

Este é um projeto simples de **Jogo de Damas** desenvolvido em Java. Ele implementa as funcionalidades básicas de um jogo de damas, incluindo a movimentação das peças, captura de peças adversárias, e verificação do estado do jogo.

## Estrutura do Projeto

O projeto é composto por três classes principais:

1. **Jogo**: Controla a lógica principal do jogo, incluindo as jogadas e as verificações do estado do jogo.
2. **Main**: Ponto de entrada para o jogo, onde os jogadores interagem com o tabuleiro e realizam suas jogadas.
3. **Tabuleiro**: Responsável pela criação e manipulação do tabuleiro, além de exibir o estado atual do jogo.

## Como Jogar

1. **Iniciar o Jogo**: O jogo começa com a execução da classe `Main`.
2. **Escolha da Jogada**: Durante cada rodada, o jogador escolhe uma peça a ser movida e as novas coordenadas (linha e coluna).
3. **Validação de Jogada**: O sistema valida se a jogada é permitida (movimento de uma peça para um espaço vazio ou captura de uma peça adversária).
4. **Captura de Peças**: Se uma peça adversária for capturada, ela é removida do tabuleiro.
5. **Fim do Jogo**: O jogo termina quando todas as peças de um jogador são capturadas.

## Regras do Jogo

- O jogo é jogado em um tabuleiro de **8x8**.
- As peças se movem diagonalmente e capturam peças adversárias pulando sobre elas.
- Cada jogador começa com 12 peças, que são inicialmente colocadas nas casas escuras da parte inferior do tabuleiro para um jogador e nas casas escuras da parte superior para o outro.
- O jogador **Vermelho** (representado por "B") começa sempre.
- O jogo termina quando um jogador captura todas as peças do adversário.

## Como Executar o Projeto

### Pré-requisitos

Certifique-se de que você tenha o Java instalado na sua máquina. Caso não tenha, baixe e instale o Java JDK mais recente no [site oficial](https://www.oracle.com/java/technologies/javase-downloads.html).

### Passos

1. Clone este repositório:
    ```bash
    git clone https://github.com/Smeltier/jogo-de-damas.git
    ```

2. Entre no diretório do projeto:
    ```bash
    cd jogo-de-damas
    ```

3. Compile o código:
    ```bash
    javac damas/*.java
    ```

4. Execute o jogo:
    ```bash
    java damas.Main
    ```


## Funcionalidades

- **Limpeza do Terminal**: O terminal é limpo a cada movimento, proporcionando uma visualização limpa do tabuleiro.
- **Exibição do Tabuleiro**: O tabuleiro é exibido após cada movimento, com peças representadas pelas cores vermelha e azul.
- **Verificação de Vitória**: O jogo detecta quando um jogador vence ao capturar todas as peças adversárias..

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
