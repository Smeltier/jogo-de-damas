import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jogo.limparTerminal();

        Jogo damas = new Jogo();
        Scanner scanner = new Scanner(System.in);

        String jogadorAtual = "B";

        while (damas.verificarEstadoJogo() == -1) {
            System.out.println("Vez do jogador " + (jogadorAtual.equals("B") ? "Vermelho" : "Azul") + ":\n");
            damas.mostrarTabuleiro();

            int posicaoAtualX, posicaoAtualY, novaPosicaoX, novaPosicaoY;

            while (true) {
                System.out.println("Digite: linhaAtual colunaAtual novaLinha novaColuna");
                posicaoAtualX = scanner.nextInt();
                posicaoAtualY = scanner.nextInt();
                novaPosicaoX = scanner.nextInt();
                novaPosicaoY = scanner.nextInt();

                if (damas.jogadaValida(posicaoAtualX, posicaoAtualY, novaPosicaoX, novaPosicaoY, jogadorAtual)) {
                    break;
                } else {
                    System.out.println("Jogada inválida. Tente novamente.");
                }
            }

            damas.mover(posicaoAtualX, posicaoAtualY, novaPosicaoX, novaPosicaoY, jogadorAtual);

            jogadorAtual = jogadorAtual.equals("B") ? "P" : "B";

            Jogo.limparTerminal();
        }

        System.out.println("Fim de jogo!");
        if (damas.verificarEstadoJogo() == 0)
            System.out.println("Jogador Azul venceu!");
        else if (damas.verificarEstadoJogo() == 1)
            System.out.println("Jogador Vermelho venceu!");

        scanner.close();
    }
}
